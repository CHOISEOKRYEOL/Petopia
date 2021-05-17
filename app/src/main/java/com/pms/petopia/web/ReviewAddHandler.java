package com.pms.petopia.web;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Review;
import com.pms.petopia.service.ReviewService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/review/add")
public class ReviewAddHandler extends HttpServlet {

  private String uploadDir;

  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("/jsp/review/review_form.jsp").include(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ReviewService reviewService = (ReviewService) request.getServletContext().getAttribute("reviewService");

    Review r = new Review();

    r.setServiceRating(Integer.parseInt(request.getParameter("serviceRating")));
    r.setCleanlinessRating(Integer.parseInt(request.getParameter("cleanlinessRating")));
    r.setCostRating(Integer.parseInt(request.getParameter("costRating")));
    r.setComment(request.getParameter("comment"));

    Part photoPart = request.getPart("photo");

    if(photoPart.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      photoPart.write(this.uploadDir + "/" + filename);
      r.setPhoto(filename);


      Thumbnails.of(this.uploadDir + "/" + filename)
      .size(100, 100)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_100x100";
        }
      });
    }

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    r.setWriter(loginUser);

    Hospital h = new Hospital();
    h.setNo(6);
    r.setHospital(h);

    try {
      reviewService.add(r);

      response.sendRedirect("../main");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}







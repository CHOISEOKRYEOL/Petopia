package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Review;
import com.pms.petopia.service.ReviewService;

@SuppressWarnings("serial")
@WebServlet("/review/add")
public class ReviewAddHandler extends HttpServlet {

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
    r.setPhoto(request.getParameter("photo"));

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







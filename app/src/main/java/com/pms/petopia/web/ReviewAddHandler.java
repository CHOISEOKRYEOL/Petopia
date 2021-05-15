package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
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
    h.setNo(1);
    r.setHospital(h);

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>리뷰 작성</title>");
    out.println("</head>");
    out.println("<body>");

    try {
      reviewService.add(r);

      out.println("<h1>리뷰 등록 완료</h1>");
      response.setHeader("Refresh", "1;url=../main");

    } catch (Exception e) {
      throw new ServletException(e);
    }

    out.println("</body>");
    out.println("</html>");
  }
}







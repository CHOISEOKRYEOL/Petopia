package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.ReviewService;

@SuppressWarnings("serial")
@WebServlet("/review/delete")
public class ReviewDeleteHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ReviewService reviewService = (ReviewService) request.getServletContext().getAttribute("reviewService");
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    int no = Integer.parseInt(request.getParameter("no"));

    try {
      reviewService.delete(no);
      if(loginUser.getRole() == 1) {
        int hno = Integer.parseInt(request.getParameter("hno"));
        response.sendRedirect("../hospital/detail?no=" + hno);
      }
      else {
        response.sendRedirect("../admin/reviewlist");
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}







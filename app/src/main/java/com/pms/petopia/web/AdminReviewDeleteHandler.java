package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.service.ReviewService;

@SuppressWarnings("serial")
@WebServlet("/admin/reviewdelete")
public class AdminReviewDeleteHandler extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ReviewService reviewService =
        (ReviewService) request.getServletContext().getAttribute("reviewService");

    int no = Integer.parseInt(request.getParameter("no"));

    try {

      reviewService.delete(no);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/admin/review_delete.jsp").include(request, response);
      response.setHeader("Refresh", "1;url='reviewlist'");

    } catch (Exception e) {
      throw new ServletException(e);
    }

  }

}

package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.service.ReviewService;

@SuppressWarnings("serial")
@WebServlet("/review/delete")
public class ReviewDeleteHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ReviewService reviewService = (ReviewService) request.getServletContext().getAttribute("reviewService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      reviewService.delete(no);

      response.setHeader("Refresh", "1;url=list");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}






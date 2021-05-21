package com.pms.petopia.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Review;
import com.pms.petopia.service.ReviewService;

@SuppressWarnings("serial")
@WebServlet("/review/list")
public class ReviewListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ReviewService reviewService = (ReviewService) request.getServletContext().getAttribute("reviewService");

    Hospital h = new Hospital();

    h.setNo(Integer.parseInt(request.getParameter("no")));

    try {
      List<Review> list = reviewService.list(h.getNo());
      request.setAttribute("hospital", h);
      request.setAttribute("list", list);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/review/list.jsp").include(request, response);
    } catch (Exception e) {
      throw new ServletException(e);
    }

  }
}







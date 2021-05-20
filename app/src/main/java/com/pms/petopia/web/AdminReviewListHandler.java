package com.pms.petopia.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Review;
import com.pms.petopia.service.ReviewService;

@SuppressWarnings("serial")
@WebServlet("/admin/reviewlist")
public class AdminReviewListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ReviewService reviewService = (ReviewService) request.getServletContext().getAttribute("reviewService");

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if(loginUser.getRole() == 1) {
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/admin/access_fail.jsp").include(request, response);
      response.setHeader("Refresh", "1;url=../main");
    }
    else {
      try {
        List<Review> list = reviewService.listAll();

        request.setAttribute("list", list);
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/jsp/admin/review_list.jsp").include(request, response);
      }
      catch (Exception e) {
        throw new ServletException(e);
      }
    }
  }
}

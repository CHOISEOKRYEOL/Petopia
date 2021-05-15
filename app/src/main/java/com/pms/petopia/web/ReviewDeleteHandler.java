package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
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

    if(loginUser == null) {
      throw new ServletException("접근 권한이 없습니다.");
    }

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>리뷰 삭제</title>");
    out.println("</head>");
    out.println("<body>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      reviewService.delete(no);

      out.println("<h1>리뷰 삭제 완료</h1>");
      response.setHeader("Refresh", "1;url=../main");

    } catch (Exception e) {
      throw new ServletException(e);
    }

    out.println("</body>");
    out.println("</html>");
  }
}







package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ReviewService reviewService = (ReviewService) request.getServletContext().getAttribute("reviewService");

    request.setCharacterEncoding("UTF-8");

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

    try {
      //      int no = Integer.parseInt(request.getParameter(1));
      reviewService.delete(1);

      out.println("<meta http-equiv='Refresh' content='1;url=../main'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>리뷰 삭제 완료</h1>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>리뷰 삭제 실패</h1>");
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }
}







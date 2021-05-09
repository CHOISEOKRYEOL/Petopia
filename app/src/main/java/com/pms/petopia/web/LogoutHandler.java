package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;

@SuppressWarnings("serial")
@WebServlet("/logout")
public class LogoutHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>로그아웃</title>");
    out.println("</head>");
    out.println("<body>");
    Member member = (Member) request.getSession().getAttribute("loginUser");
    if (member == null) {
      throw new ServletException("알 수 없는 오류가 발생하였습니다.");
    }

    request.getSession().invalidate();

    out.printf("%s 님 로그아웃 하였습니다.\n", member.getName());
    out.println("<meta http-equiv='Refresh' content='1;url=main'>");

    out.println("</body>");
    out.println("</html>");

  }
}







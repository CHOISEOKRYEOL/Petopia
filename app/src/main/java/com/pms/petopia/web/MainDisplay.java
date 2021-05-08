package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/main")
public class MainDisplay extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    HttpServletRequest httpRequest = request;
    Member loginUser = (Member) httpRequest.getSession().getAttribute("loginUser");

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>회원 가입</title>");
    out.println("</head>");
    out.println("<body>");
    if(loginUser == null) {
      out.println("<h1>회원 가입 및 로그인</h1>");
      out.println("<p><a href='form.html'>가입</a></p>");
      out.println("<p><a href='login.html'>로그인</a></p>");
    }
    else {
      out.println("<h1>메인 화면</h1>");
      out.println("<p><form action='detail' method='get'></p>");
      out.println("<input name='update' type='submit' value='내 정보 변경'></form>");
      out.println("<p><form action='logout' method='post'></p>");
      out.println("<input name='logout' type='submit' value='로그아웃'></form>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}

package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    String id = request.getParameter("id");
    boolean check = isEmail(id);
    String password = request.getParameter("password");
    Member member = null;


    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<body>");

    try {
      if(check) {
        member = memberService.getEmail(id, password);
      }
      else {
        member = memberService.getId(id, password);
      }


      if (member == null) {
        request.getSession().invalidate();
        out.println("</head>");
        response.sendRedirect("login");
        out.println("<h1>로그인 결과</h1>");
        out.println("<p>사용자 정보가 맞지 않습니다.</p>");
        response.setHeader("Refresh", "1;url=login");
      }

      request.getSession().setAttribute("loginUser", member);
      response.sendRedirect("main");

    } catch (Exception e) {
      throw new ServletException(e);
    } 

    out.println("</body>");
    out.println("</html>");
  }

  private boolean isEmail(String id) { 
    boolean check = false; 
    String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$"; 
    Pattern p = Pattern.compile(regex); 
    Matcher email = p.matcher(id);
    if(email.matches()) { 
      check = true; 
    } 
    return check; 
  }

}

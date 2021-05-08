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
import com.pms.petopia.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/add")
public class MemberAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    request.setCharacterEncoding("UTF-8");

    Member m = new Member();
    m.setName(request.getParameter("name"));
    m.setId(request.getParameter("id"));
    m.setNick(request.getParameter("nick"));
    m.setEmail(request.getParameter("email"));
    m.setPassword(request.getParameter("password"));
    String checkPassword = request.getParameter("checkPassword");
    if(!m.getPassword().equals(checkPassword)) {
      throw new ServletException("비밀번호가 일치하지 않습니다.");
    }
    m.setEmail(request.getParameter("email"));
    m.setTel(request.getParameter("tel"));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    try {
      memberService.add(m);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>회원 가입 완료</h1>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>회원 가입 오류</h1>");
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }
}







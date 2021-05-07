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
@WebServlet("/member/update")
public class MemberUpdateHandler extends HttpServlet {

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    try {
      out.println("[회원 변경]");

      int no = Integer.parseInt(request.getParameter("no"));

      Member oldMember = memberService.get(no);
      if (oldMember == null) {
        out.println("해당 번호의 회원이 없습니다.");
        return;
      }

      Member m = new Member();
      m.setNo(oldMember.getNo());

      m.setName(request.getParameter("name"));
      m.setNick(request.getParameter("nick"));
      m.setEmail(request.getParameter("email"));
      m.setPassword(request.getParameter("password"));
      m.setEmail(request.getParameter("email"));
      m.setTel(request.getParameter("tel"));
      memberService.update(m);

      out.println("회원을 변경하였습니다.");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.println(strWriter.toString());
    }
  }
}







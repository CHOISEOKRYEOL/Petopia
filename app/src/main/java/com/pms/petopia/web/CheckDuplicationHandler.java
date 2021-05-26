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
@WebServlet("/member/check")
public class CheckDuplicationHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    String id = request.getParameter("id");
    String email = request.getParameter("email");
    String nick = request.getParameter("nick");

    try {

      Member m = null;

      if(id != null && email == null && nick == null) {
        m = memberService.getId(id);
      }
      else if(email != null && id == null && nick == null) {
        m = memberService.getEmail(email);
      }
      else if(nick != null && id == null && email == null) {
        m = memberService.getNick(nick);
      }

      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();

      if(m != null) {
        out.print("yes");
      }
      else {
        out.print("no");
      }

    }
    catch (Exception e) {
      throw new ServletException(e);
    }

  }
}

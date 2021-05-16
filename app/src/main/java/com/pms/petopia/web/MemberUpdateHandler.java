package com.pms.petopia.web;

import java.io.IOException;
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
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    Member m = new Member();
    m.setNo(loginUser.getNo());
    m.setNick(request.getParameter("nick"));
    m.setPassword(request.getParameter("password"));
    m.setTel(request.getParameter("tel"));

    try {

      memberService.update(m);
      request.setAttribute("member", loginUser);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/member/update.jsp").include(request, response);
      response.setHeader("Refresh", "1;url=../main");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}







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
@WebServlet("/member/delete")
public class MemberDeleteHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    try {

      memberService.delete(loginUser.getNo());
      request.getSession().invalidate();
      request.setAttribute("member", loginUser);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/member/delete.jsp");
      response.setHeader("Refresh", "content=1;url='../main'");

    } catch (Exception e) {
      throw new ServletException(e);
    }

  }
}







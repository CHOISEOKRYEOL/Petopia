package com.pms.petopia.web;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/admin/memberdelete")
public class AdminMemberDeleteHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    Member m = new Member();
    m.setNo(Integer.parseInt(request.getParameter("no")));
    m.setEmail(UUID.randomUUID().toString());
    m.setName(UUID.randomUUID().toString());
    m.setPassword(UUID.randomUUID().toString());
    m.setTel(UUID.randomUUID().toString());
    m.setNick(UUID.randomUUID().toString());
    m.setState(0);

    try {

      memberService.delete(m);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/admin/member_delete.jsp").include(request, response);
      response.setHeader("Refresh", "1;url='memberlist'");

    } catch (Exception e) {
      throw new ServletException(e);
    }

  }
}







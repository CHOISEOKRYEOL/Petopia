package com.pms.petopia.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/admin/memberlist")
public class AdminMemberHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    System.out.println(loginUser);

    if(loginUser.getRole() == 1) {
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/admin/list_fail.jsp").include(request, response);
      response.setHeader("Refresh", "1;url=../main");
    }
    else {
      try {
        List<Member> list = memberService.list();

        request.setAttribute("list", list);
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/jsp/admin/list.jsp").include(request, response);

      } catch (Exception e) {
        throw new ServletException(e);
      }
    }
  }
}







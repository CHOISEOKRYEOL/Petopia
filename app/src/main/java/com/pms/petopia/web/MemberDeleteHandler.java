package com.pms.petopia.web;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.BookmarkService;
import com.pms.petopia.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/delete")
public class MemberDeleteHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");
    BookmarkService bookmarkService = (BookmarkService) request.getServletContext().getAttribute("bookmarkService");
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    Member m = new Member();
    m.setNo(loginUser.getNo());
    m.setEmail(UUID.randomUUID().toString());
    m.setName(UUID.randomUUID().toString());
    m.setPassword(UUID.randomUUID().toString());
    m.setTel(UUID.randomUUID().toString());
    m.setNick(UUID.randomUUID().toString());
    m.setState(1);

    try {

      bookmarkService.deleteAll(loginUser.getNo());
      memberService.delete(m);
      request.getSession().invalidate();
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/member/delete.jsp").include(request, response);
      response.setHeader("Refresh", "1;url='../main'");

    } catch (Exception e) {
      throw new ServletException(e);
    }

  }
}







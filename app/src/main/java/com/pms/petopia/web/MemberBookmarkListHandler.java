package com.pms.petopia.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Bookmark;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.BookmarkService;

@SuppressWarnings("serial")
@WebServlet("/member/bookmarklist")
public class MemberBookmarkListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    BookmarkService bookmarkService = (BookmarkService) request.getServletContext().getAttribute("bookmarkService");

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    try {
      List<Bookmark> list = bookmarkService.list(loginUser.getNo());

      request.setAttribute("list", list);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/member/bookmark.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

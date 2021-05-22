package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.service.BookmarkService;

@SuppressWarnings("serial")
@WebServlet("/member/bookmarkdelete")
public class MemberBookmarkDeleteHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    BookmarkService bookmarkService = (BookmarkService) request.getServletContext().getAttribute("bookmarkService");

    int bno = Integer.parseInt(request.getParameter("bno"));
    int hno = Integer.parseInt(request.getParameter("hno"));

    try {

      bookmarkService.delete(bno);

      response.sendRedirect("../hospital/detail?no=" + hno);

    }
    catch (Exception e) {
      throw new ServletException(e);
    }

  }
}
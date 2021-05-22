package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Bookmark;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.BookmarkService;

@SuppressWarnings("serial")
@WebServlet("/member/bookmarkadd")
public class MemberBookmarkAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    BookmarkService bookmarkService = (BookmarkService) request.getServletContext().getAttribute("bookmarkService");

    Bookmark b = new Bookmark();

    Member m = new Member();
    m.setNo(Integer.parseInt(request.getParameter("mno")));

    Hospital h = new Hospital();
    h.setNo(Integer.parseInt(request.getParameter("hno")));

    b.setMember(m);
    b.setHospital(h);

    try {

      bookmarkService.add(b);

      response.setContentType("text/html;charset=UTF-8");
      response.sendRedirect("../hospital/detail?no=" + h.getNo());

    }
    catch(Exception e) {
      throw new ServletException(e);
    }

  }

}

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
import com.pms.petopia.service.HospitalService;

@SuppressWarnings("serial")
@WebServlet("/hospital/detail")
public class HospitalDetailHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HospitalService hospitalService = (HospitalService) request.getServletContext().getAttribute("hospitalService");
    BookmarkService bookmarkService = (BookmarkService) request.getServletContext().getAttribute("bookmarkService");
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");


    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Hospital hospital = hospitalService.get(no);

      Bookmark bookmark = bookmarkService.get(loginUser.getNo(), hospital.getNo());

      request.setAttribute("bookmark", bookmark);
      request.setAttribute("hospital", hospital);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/hospital/detail.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

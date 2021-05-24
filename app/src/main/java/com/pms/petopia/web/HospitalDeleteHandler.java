package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.service.BookmarkService;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.ReviewService;

@SuppressWarnings("serial")
@WebServlet("/hospital/delete")
public class HospitalDeleteHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HospitalService hospitalService = (HospitalService) request.getServletContext().getAttribute("hospitalService");
    ReviewService reviewService = (ReviewService) request.getServletContext().getAttribute("reviewService");
    BookmarkService bookmarkService = (BookmarkService) request.getServletContext().getAttribute("bookmarkService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      reviewService.deleteByAdmin(no);
      bookmarkService.deleteByAdmin(no);
      hospitalService.delete(no);
      response.sendRedirect("../admin/hospitallist");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

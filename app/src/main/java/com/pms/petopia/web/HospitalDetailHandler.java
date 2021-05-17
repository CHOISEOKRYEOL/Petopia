package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.service.HospitalService;

@SuppressWarnings("serial")
@WebServlet("/hospital/detail")
public class HospitalDetailHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HospitalService hospitalService = (HospitalService) request.getServletContext().getAttribute("hospitalService");
    //ReviewService reviewService = (ReviewService) request.getServletContext().getAttribute("reviewService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Hospital h = hospitalService.get(no);
      request.setAttribute("hospital", h);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/hospital/detail.jsp").include(request, response);

      //List<Review> reviews = reviewService.list(h.getNo());

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

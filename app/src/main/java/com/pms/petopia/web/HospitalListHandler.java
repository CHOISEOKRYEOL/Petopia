package com.pms.petopia.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.service.HospitalService;

@SuppressWarnings("serial")
@WebServlet("/hospital/list")
public class HospitalListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HospitalService hospitalService = (HospitalService) request.getServletContext().getAttribute("hospitalService");

    try {
      List<Hospital> hospitals = hospitalService.list();

      request.setAttribute("list", hospitals);

      //      HttpSession session = request.getSession();
      //      session.setAttribute("list", request.getParameter("list"));

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/hospital/list.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

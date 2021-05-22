package com.pms.petopia.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.SmallAddressService;

@SuppressWarnings("serial")
@WebServlet("/mytown/main")
public class MyTownBoardMainHandler extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    SmallAddressService smallAddressService = (SmallAddressService) request.getServletContext().getAttribute("smallAddressService");

    response.setContentType("text/html;charset=UTF-8");

    try {

      List<SmallAddress> smallAddresses = smallAddressService.list();

      request.setAttribute("smallAddresses", smallAddresses);
      request.getRequestDispatcher("/jsp/mytown/main.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

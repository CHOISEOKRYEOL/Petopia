package com.pms.petopia.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.SmallAddressService;

@SuppressWarnings("serial")
@WebServlet("/mytown/list")

public class MytownBoardListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MyTownBoardService myTownBoardService =
        (MyTownBoardService) request.getServletContext().getAttribute("myTownBoardService");
    SmallAddressService smallAddressService =
        (SmallAddressService) request.getServletContext().getAttribute("smallAddressService");

    int stateNo = Integer.parseInt(request.getParameter("stateNo"));
    int cityNo = Integer.parseInt(request.getParameter("cityNo"));
    String keyword = request.getParameter("keyword");

    try {
      List<MyTownBoard> boards = myTownBoardService.list(cityNo, stateNo);
      SmallAddress smallAddress = smallAddressService.get(cityNo);
      List<SmallAddress> smallAddresses = smallAddressService.list();

      if (boards.size() > 0) {

        if (keyword != null && keyword.length() > 0) {
          boards = myTownBoardService.search(stateNo, cityNo, keyword);
        } else {
          boards = myTownBoardService.list(stateNo, cityNo);
        }
      }

      response.setContentType("text/html;charset=UTF-8");
      request.setAttribute("boards", boards);
      request.setAttribute("smallAddresses", smallAddresses);
      request.setAttribute("smallAddress", smallAddress);
      request.getRequestDispatcher("/jsp/mytownboard/list.jsp").include(request, response);
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}



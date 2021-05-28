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
import com.pms.petopia.service.RecommentService;
import com.pms.petopia.service.SmallAddressService;

@SuppressWarnings("serial")
@WebServlet("/mytown/list")

public class MyTownBoardListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MyTownBoardService myTownBoardService =
        (MyTownBoardService) request.getServletContext().getAttribute("myTownBoardService");
    SmallAddressService smallAddressService =
        (SmallAddressService) request.getServletContext().getAttribute("smallAddressService");
    RecommentService recommentService = (RecommentService)request.getServletContext().getAttribute("RecommentService");

    int stateNo = Integer.parseInt(request.getParameter("stateNo"));
    int cityNo = Integer.parseInt(request.getParameter("cityNo"));
    String keyword = request.getParameter("keyword");
    String r = request.getParameter("r");

    try {
      List<MyTownBoard> boards = myTownBoardService.list(cityNo, stateNo);
      SmallAddress smallAddress = smallAddressService.get(cityNo);
      List<SmallAddress> smallAddresses = smallAddressService.list();

      if (boards.size() > 0) {

        if (keyword != null && keyword.length() > 0 && r == null) {
          boards = myTownBoardService.search(stateNo, cityNo, keyword);
        }else if(keyword == null && r != null) {
          boards = myTownBoardService.listRecomment(stateNo, cityNo);
        }else {
          boards = myTownBoardService.list(stateNo, cityNo);
        }
      }
      response.setContentType("text/html;charset=UTF-8");
      request.setAttribute("boards", boards);
      request.setAttribute("smallAddresses", smallAddresses);
      request.setAttribute("smallAddress", smallAddress);
      request.setAttribute("keyword", keyword);
      request.setAttribute("r", r);
      request.setAttribute("stateNo", stateNo);
      request.setAttribute("cityNo", cityNo);
      request.getRequestDispatcher("/jsp/mytown/list.jsp").include(request, response);
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
package com.pms.petopia.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.SmallAddressService;

@SuppressWarnings("serial")
@WebServlet("/mytown/add")
public class MyTownBoardAddHandler extends HttpServlet{

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    SmallAddressService smallAddressService = (SmallAddressService) request.getServletContext().getAttribute("smallAddressService");
    response.setContentType("text/html;charset=UTF-8");

    int stateNo= Integer.parseInt(request.getParameter("stateNo")); //일단 가져왔음
    int cityNo = Integer.parseInt(request.getParameter("cityNo"));
    try {
      SmallAddress smallAddress = smallAddressService.get(cityNo);
      List<SmallAddress> smallAddresses = smallAddressService.list();

      request.setAttribute("smallAddress", smallAddress);
      request.setAttribute("smallAddresses", smallAddresses);
      request.getRequestDispatcher("/jsp/mytown/form.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MyTownBoardService myTownBoardService = (MyTownBoardService)request.getServletContext().getAttribute("myTownBoardService");
    SmallAddressService smallAddressService = (SmallAddressService) request.getServletContext().getAttribute("smallAddressService");

    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");

    MyTownBoard b = new MyTownBoard();

    try {
      int no = Integer.parseInt(request.getParameter("cityNo"));
      SmallAddress s = smallAddressService.get(no);
      b.setSmallAddress(s);
      b.setTitle(request.getParameter("title"));
      b.setContent(request.getParameter("content"));
      Member loginUser = (Member)request.getSession().getAttribute("loginUser");
      b.setWriter(loginUser);


      myTownBoardService.add(b);
      String webAdress= String.format("list?stateNo=%s&cityNo=%s", s.getBigAddress().getNo(), s.getNo());
      response.sendRedirect(webAdress);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}





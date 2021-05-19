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
import com.pms.petopia.service.MyTownBoardService;

@SuppressWarnings("serial")
@WebServlet("/admin/mytownlist")

public class AdminMyTownBoardHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MyTownBoardService myTownBoardService = (MyTownBoardService) request.getServletContext().getAttribute("myTownBoardService");

    int stateNo = Integer.parseInt(request.getParameter("stateNo"));
    int cityNo = Integer.parseInt(request.getParameter("cityNo"));

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if(loginUser.getRole() != 0) {
      return;
    }

    try {
      List<MyTownBoard> boards = myTownBoardService.list(cityNo,stateNo);
      MyTownBoard board = boards.get(0);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}







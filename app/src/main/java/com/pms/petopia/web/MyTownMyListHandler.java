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
@WebServlet("/mypage/mytownlist")
public class MyTownMyListHandler extends HttpServlet{

  @Override
  protected void service(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MyTownBoardService myTownBoardService =
        (MyTownBoardService) request.getServletContext().getAttribute("myTownBoardService");
    response.setContentType("text/html;charset=UTF-8");

    //int memberNo = Integer.parseInt(request.getParameter("memberNo"));

    try {

      Member loginUser = (Member)request.getSession().getAttribute("loginUser");
      List<MyTownBoard> myTownList = myTownBoardService.listMine(loginUser.getNo());

      String emptyList = null;
      if (myTownList.size() == 0) {
        emptyList = "true";
      }

      request.setAttribute("emptyList", emptyList);
      request.setAttribute("myTownList", myTownList);
      request.getRequestDispatcher("/jsp/mypage/mytownlist.jsp").include(request, response);
    } catch (Exception e) {

      throw new ServletException(e);
    }
  }
}

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
import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.SharingMarketBoardService;

@SuppressWarnings("serial")
@WebServlet("/admin/boardlist")
public class AdminBoardListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    SharingMarketBoardService sharingMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("sharingMarketBoardService");
    MyTownBoardService myTownBoardService = (MyTownBoardService) request.getServletContext().getAttribute("myTownBoardService");
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    if(loginUser.getRole() == 1) {
      if(loginUser.getRole() == 1) {
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/jsp/admin/access_fail.jsp").include(request, response);
        response.setHeader("Refresh", "1;url=../main");
      }
    }
    else {
      try {
        List<SharingMarketBoard> sList = sharingMarketBoardService.list();
        List<MyTownBoard> mList = myTownBoardService.listAll();

        request.setAttribute("sList", sList);
        request.setAttribute("mList", mList);

        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/jsp/admin/board_list.jsp").include(request, response);

      }
      catch (Exception e) {
        throw new ServletException(e);
      }
    }
  }
}

package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.service.MyTownBoardCommentService;
import com.pms.petopia.service.MyTownBoardService;

@SuppressWarnings("serial")
@WebServlet("/mytown/delete")
public class MyTownBoardDeleteHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    MyTownBoardService myTownBoardService = (MyTownBoardService) request.getServletContext().getAttribute("myTownBoardService");
    MyTownBoardCommentService myTownBoardCommentService = (MyTownBoardCommentService) request.getServletContext().getAttribute("myTownBoardCommentService");

    int no = Integer.parseInt(request.getParameter("no"));

    try {
      MyTownBoard oldBoard = myTownBoardService.get(no);
      if (oldBoard == null) {
        throw new Exception("해당 번호의 게시글이 없습니다.");
      }

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
        throw new Exception("삭제 권한이 없습니다!");
      }

      if (myTownBoardCommentService.count(no).equals("0")) {
        myTownBoardService.delete(no);
      } else {
        myTownBoardService.deleteAll(no); // 댓글까지 지우기 
      }

      String webAddress = String.format("list?stateNo=%d&cityNo=%d", 
          oldBoard.getBigAddress().getNo(), oldBoard.getSmallAddress().getNo());
      request.getRequestDispatcher("/jsp/mytownboard/delete.jsp").include(request, response);
      response.setHeader("Refresh", "3;url=" + webAddress);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

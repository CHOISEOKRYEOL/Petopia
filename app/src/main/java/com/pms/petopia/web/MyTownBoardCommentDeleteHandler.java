package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.MyTownBoardComment;
import com.pms.petopia.service.MyTownBoardCommentService;
import com.pms.petopia.service.MyTownBoardService;

@SuppressWarnings("serial")
@WebServlet("/mytowncomment/delete")
public class MyTownBoardCommentDeleteHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    MyTownBoardCommentService myTownBoardCommentService = (MyTownBoardCommentService) request.getServletContext().getAttribute("myTownBoardCommentService");
    MyTownBoardService myTownBoardService = (MyTownBoardService) request.getServletContext().getAttribute("myTownBoardService");

    int no = Integer.parseInt(request.getParameter("no"));

    try {
      MyTownBoardComment oldBoardComment = myTownBoardCommentService.get(no);
      if (oldBoardComment == null) {
        throw new Exception("해당 번호의 댓글이 없습니다.");
      }

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (oldBoardComment.getWriter().getNo() != loginUser.getNo()) {
        throw new Exception("삭제 권한이 없습니다!");
      }

      myTownBoardCommentService.delete(no);
      int oldBoardNo = oldBoardComment.getMyTownBoard().getNo();
      MyTownBoard oldBoard = myTownBoardService.get(oldBoardNo);

      String webAdress= String.format("../mytown/detail?stateNo=%d&cityNo=%d&no=%d", 
          oldBoard.getBigAddress().getNo(), oldBoard.getSmallAddress().getNo(), oldBoard.getNo());
      response.sendRedirect(webAdress);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

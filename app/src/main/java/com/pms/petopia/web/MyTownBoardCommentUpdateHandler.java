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
@WebServlet("/mytowncomment/update")
public class MyTownBoardCommentUpdateHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MyTownBoardCommentService myTownBoardCommentService = (MyTownBoardCommentService) request.getServletContext().getAttribute("myTownBoardCommentService");
    MyTownBoardService myTownBoardService = (MyTownBoardService) request.getServletContext().getAttribute("myTownBoardService");
    response.setContentType("text/html;charset=UTF-8");

    try {
      int no = Integer.parseInt(request.getParameter("no"));


      MyTownBoardComment oldBoardComment = myTownBoardCommentService.get(no);
      if (oldBoardComment == null) {
        throw new Exception ("해당 번호의 댓글이 없습니다.");
      }
      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (oldBoardComment.getWriter().getNo() != loginUser.getNo()) {
        throw new Exception("변경 권한이 없습니다!");
      }

      MyTownBoardComment comment = new MyTownBoardComment();
      comment.setNo(oldBoardComment.getNo());
      comment.setContent(request.getParameter("content"));

      myTownBoardCommentService.update(comment);
      MyTownBoard board = myTownBoardService.get(oldBoardComment.getMyTownBoard().getNo());

      String webAddress = String.format("../mytown/detail?stateNo=%d&cityNo=%d&no=%d", 
          board.getBigAddress().getNo(), board.getSmallAddress().getNo(), board.getNo());
      response.sendRedirect(webAddress);

    } catch (Exception e) {
      throw new ServletException(e);
    }

  }
}

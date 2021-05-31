package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.MyTownBoardComment;
import com.pms.petopia.service.MyTownBoardCommentService;
import com.pms.petopia.service.MyTownBoardService;

@Controller
public class MyTownBoardCommentUpdateHandler {

  MyTownBoardService myTownBoardService;
  MyTownBoardCommentService myTownBoardCommentService;

  public MyTownBoardCommentUpdateHandler(MyTownBoardService myTownBoardService, MyTownBoardCommentService myTownBoardCommentService) {
    this.myTownBoardService = myTownBoardService;
    this.myTownBoardCommentService = myTownBoardCommentService;
  }

  @RequestMapping("/mytowncomment/update")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

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

    return "redirect:webAddress";
    //      response.sendRedirect(webAddress);


  }
}

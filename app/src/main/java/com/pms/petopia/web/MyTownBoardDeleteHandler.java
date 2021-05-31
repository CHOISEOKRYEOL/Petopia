package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.service.MyTownBoardCommentService;
import com.pms.petopia.service.MyTownBoardService;

@Controller
public class MyTownBoardDeleteHandler {

  MyTownBoardService myTownBoardService;
  MyTownBoardCommentService myTownBoardCommentService;

  public MyTownBoardDeleteHandler(MyTownBoardService myTownBoardService, MyTownBoardCommentService myTownBoardCommentService) {
    this.myTownBoardService = myTownBoardService;
    this.myTownBoardCommentService = myTownBoardCommentService;
  }

  @RequestMapping("/mytown/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {


    int no = Integer.parseInt(request.getParameter("no"));

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

    return "/jsp/mytown/delete.jsp";

    //      response.setHeader("Refresh", "3;url=" + webAddress);

  }
}

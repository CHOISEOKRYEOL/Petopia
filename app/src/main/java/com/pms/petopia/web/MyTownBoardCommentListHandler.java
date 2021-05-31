//package com.pms.petopia.web;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import com.pms.petopia.domain.Member;
//import com.pms.petopia.domain.MyTownBoard;
//import com.pms.petopia.domain.MyTownBoardComment;
//import com.pms.petopia.service.MyTownBoardCommentService;
//import com.pms.petopia.service.MyTownBoardService;
//
//@Controller
//public class MyTownBoardCommentListHandler {
//
//  MyTownBoardService myTownBoardService;
//  MyTownBoardCommentService myTownBoardCommentService;
//
//  public MyTownBoardCommentListHandler(MyTownBoardService myTownBoardService, MyTownBoardCommentService myTownBoardCommentService) {
//    this.myTownBoardService = myTownBoardService;
//    this.myTownBoardCommentService = myTownBoardCommentService;
//  }
//
//  @RequestMapping("/mytowncomment/list")
//  public String execute(HttpServletRequest request, HttpServletResponse response)
//      throws Exception {
//
//
//    MyTownBoardComment c = new MyTownBoardComment();
//    int boardNo = Integer.parseInt(request.getParameter("boardNo"));
//    MyTownBoard t = myTownBoardService.get(boardNo);
//    c.setMyTownBoard(t);
//    Member loginUser = (Member)request.getSession().getAttribute("loginUser");
//    c.setWriter(loginUser);
//    c.setContent(request.getParameter("content"));
//
//    myTownBoardCommentService.add(c);
//    String webAdress= String.format("../mytown/detail?stateNo=%d&cityNo=%d&no=%d\n", 
//        t.getBigAddress().getNo(), t.getSmallAddress().getNo(), boardNo);
//
//    return "redirect:webAdress";
//    //    response.sendRedirect(webAdress);
//
//  }
//}

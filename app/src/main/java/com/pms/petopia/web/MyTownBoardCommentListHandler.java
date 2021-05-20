//package com.pms.petopia.web;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import com.pms.petopia.domain.Member;
//import com.pms.petopia.domain.MyTownBoard;
//import com.pms.petopia.domain.MyTownBoardComment;
//import com.pms.petopia.service.MyTownBoardCommentService;
//import com.pms.petopia.service.MyTownBoardService;
//
//@SuppressWarnings("serial")
//@WebServlet("/mytowncomment/list")
//public class MyTownBoardCommentListHandler extends HttpServlet {
//
//  @Override
//  protected void doPost(HttpServletRequest request, HttpServletResponse response)
//      throws ServletException, IOException {
//
//    MyTownBoardCommentService myTownBoardCommentService = (MyTownBoardCommentService)request.getServletContext().getAttribute("myTownBoardCommentService");
//    MyTownBoardService myTownBoardService = (MyTownBoardService)request.getServletContext().getAttribute("myTownBoardService");
//
//    response.setContentType("text/html;charset=UTF-8");
//
//    MyTownBoardComment c = new MyTownBoardComment();
//    try {
//      int boardNo = Integer.parseInt(request.getParameter("boardNo"));
//      MyTownBoard t = myTownBoardService.get(boardNo);
//      c.setMyTownBoard(t);
//      Member loginUser = (Member)request.getSession().getAttribute("loginUser");
//      c.setWriter(loginUser);
//      c.setContent(request.getParameter("content"));
//
//      myTownBoardCommentService.add(c);
//      String webAdress= String.format("../mytown/detail?stateNo=%d&cityNo=%d&no=%d\n", 
//          t.getBigAddress().getNo(), t.getSmallAddress().getNo(), boardNo);
//      response.sendRedirect(webAdress);
//
//    } catch (Exception e) {
//      throw new ServletException(e);
//    }
//  }
//}

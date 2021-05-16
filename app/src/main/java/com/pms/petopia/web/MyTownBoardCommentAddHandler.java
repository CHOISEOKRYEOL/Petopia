package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
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
@WebServlet("/mytowncomment/add")
public class MyTownBoardCommentAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MyTownBoardCommentService myTownBoardCommentService = (MyTownBoardCommentService)request.getServletContext().getAttribute("myTownBoardCommentService");
    MyTownBoardService myTownBoardService = (MyTownBoardService)request.getServletContext().getAttribute("myTownBoardService");

    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");
    PrintWriter out = response.getWriter();

    MyTownBoardComment c = new MyTownBoardComment();
    try {
      int boardNo = Integer.parseInt(request.getParameter("boardNo"));
      MyTownBoard t = myTownBoardService.get(boardNo);
      c.setMyTownBoard(t);
      Member loginUser = (Member)request.getSession().getAttribute("loginUser");
      c.setWriter(loginUser);
      c.setContent(request.getParameter("content"));

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<meta charset='UTF-8'>");
      out.println("<title>우리동네 새 댓글</title>");

      myTownBoardCommentService.add(c);
      String webAdress= String.format("../mytown/detail?stateNo=%d&cityNo=%d&no=%d\n", 
          t.getBigAddress().getNo(), t.getSmallAddress().getNo(), boardNo);
      response.sendRedirect(webAdress);

    } catch (Exception e) {
      // 상세 오류 내용을 StringWriter로 출력한다.
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>댓글 등록 오류</h1>");
      out.printf("<pre>%s</pre>\n", strWriter.toString());
      out.println("<a href='../mytown/main'>목록</a></p>\n");
    }
    out.println("</head>");
    out.println("<body>");
  }
}

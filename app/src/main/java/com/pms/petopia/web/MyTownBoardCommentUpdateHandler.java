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
@WebServlet("/mytowncomment/update")
public class MyTownBoardCommentUpdateHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MyTownBoardCommentService myTownBoardCommentService = (MyTownBoardCommentService) request.getServletContext().getAttribute("myTownBoardCommentService");
    MyTownBoardService myTownBoardService = (MyTownBoardService) request.getServletContext().getAttribute("myTownBoardService");
    response.setContentType("text/html;charset=UTF-8");

    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>댓글 변경</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>댓글 변경</h1>");

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

      MyTownBoard board = myTownBoardService.get(comment.getMyTownBoard().getNo());

      out.printf("<meta http-equiv='Refresh' content='1;url=list?stateNo=%d&cityNo=%d>",
          board.getBigAddress().getNo(), board.getSmallAddress().getNo());
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>댓글 변경</h1>");
      out.println("<p>댓글을 변경하였습니다.</p>");
      //response.setHeader("Refresh", "1;url=../main");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>댓글 변경 오류</h1>");
      out.printf("<p>%s</p>\n",e.getMessage());
      out.printf("<pre>%s</pre>\n", strWriter.toString());
      out.println("<a href='list'>목록</a></p>\n");
    }

    out.println("</body>");
    out.println("</html>");
  }
}

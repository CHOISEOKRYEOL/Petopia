package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.domain.SharingMarketBoardComment;
import com.pms.petopia.service.SharingMarketBoardCommentService;
import com.pms.petopia.service.SharingMarketBoardService;

@SuppressWarnings("serial")
@WebServlet("/sharingmarketboardcomment/update")
public class SharingMarketBoardCommentUpdateHandler extends HttpServlet{

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    SharingMarketBoardService sharingMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("sharingMarketBoardService");
    SharingMarketBoardCommentService sharingMarketBoardCommentService = (SharingMarketBoardCommentService) request.getServletContext().getAttribute("sharingMarketBoardCommentService");

    try {
      PrintWriter out = response.getWriter();
      response.setContentType("text/html;charset=UTF-8");
      int no = Integer.parseInt(request.getParameter("no"));
      SharingMarketBoard oldBoard = sharingMarketBoardService.get(no);

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
        throw new Exception("변경 권한이 없습니다!");
      }

      SharingMarketBoardComment oldSmbComt = sharingMarketBoardCommentService.getNo(no);
      SharingMarketBoardComment smbComt = new SharingMarketBoardComment();

      smbComt.setNo(oldSmbComt.getNo());
      smbComt.setSharingmarketboard(oldBoard);
      String content = request.getParameter("content");

      if(content == "") {
        out.print("empty");
      }else {
        out.print("working");
      }
      smbComt.setContent(content);
      sharingMarketBoardCommentService.update(smbComt);


    } catch (Exception e) {
      throw new ServletException(e);
    }

  }
}

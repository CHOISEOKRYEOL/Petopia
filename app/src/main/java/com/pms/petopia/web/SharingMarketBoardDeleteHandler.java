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
import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.service.SharingMarketBoardService;

@SuppressWarnings("serial")
@WebServlet("/sharingmarketboard/delete")
public class SharingMarketBoardDeleteHandler extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    SharingMarketBoardService sharingMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("sharingMarketBoardService");

    try {
    	
      int no = Integer.parseInt(request.getParameter("no"));
      SharingMarketBoard oldBoard = sharingMarketBoardService.get(no);
      if (oldBoard == null) {
        throw new Exception("해당 번호의 게시글이 없습니다.");
      }

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
        throw new Exception("삭제 권한이 없습니다!");
      }

      sharingMarketBoardService.delete(no);

      response.sendRedirect("list");

    } catch (Exception e) {
    	throw new ServletException(e);

    }


  }

}

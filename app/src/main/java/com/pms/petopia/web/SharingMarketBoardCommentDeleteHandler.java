package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.SharingMarketBoardComment;
import com.pms.petopia.service.SharingMarketBoardCommentService;

@SuppressWarnings("serial")
@WebServlet("/sharingmarketboardcomment/delete")
public class SharingMarketBoardCommentDeleteHandler extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    SharingMarketBoardCommentService sharingMarketBoardCommentService = (SharingMarketBoardCommentService)request.getServletContext().getAttribute("sharingMarketBoardCommentService");
    try {
    	
      int no = Integer.parseInt(request.getParameter("no"));
      SharingMarketBoardComment smbComt = sharingMarketBoardCommentService.getNo(no);
      
      int detailBoardNo = smbComt.getSharingmarketboard().getNo();
      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (smbComt.getWriter().getNo() != loginUser.getNo()) {
        throw new Exception("삭제 권한이 없습니다!");
      }
      sharingMarketBoardCommentService.delete(no);
      response.sendRedirect("../sharingmarketboard/detail?no="+detailBoardNo);

    } catch (Exception e) {
    	throw new ServletException(e);

    }


  }

}

package com.pms.petopia.web;

import java.io.IOException;

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
@WebServlet("/sharingmarketboardcomment/add")
public class SharingMarketBoardCommentAddHandler extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SharingMarketBoardService sharingMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("sharingMarketBoardService");
		SharingMarketBoardCommentService sharingMarketBoardCommentService = (SharingMarketBoardCommentService) request.getServletContext().getAttribute("sharingMarketBoardCommentService");

		 SharingMarketBoardComment smbComt = new SharingMarketBoardComment();
		 
	    try {
	        int boardNo = Integer.parseInt(request.getParameter("no"));
	        SharingMarketBoard oldBoard = sharingMarketBoardService.get(boardNo);
	        smbComt.setSharingmarketboard(oldBoard);
		    smbComt.setContent(request.getParameter("content"));
		    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
		    smbComt.setWriter(loginUser);
		    
	    	sharingMarketBoardCommentService.add(smbComt);
	    	
	      response.sendRedirect("../sharingmarketboard/detail?no="+smbComt.getSharingmarketboard().getNo());
	      //request.getRequestDispatcher("/jsp/sharingmarketboard/detail.jsp").include(request, response);
	      
	    } catch (Exception e) {
	      throw new ServletException(e);
	    }
		
	}
}

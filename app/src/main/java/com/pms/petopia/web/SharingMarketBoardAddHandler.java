package com.pms.petopia.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.service.SharingMarketBoardCategoryService;
import com.pms.petopia.service.SharingMarketBoardService;

@SuppressWarnings("serial")
@WebServlet("/sharingmarketboard/add")
public class SharingMarketBoardAddHandler extends HttpServlet {
	
	@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SharingMarketBoardCategoryService sharingMarketBoardCategoryService = (SharingMarketBoardCategoryService) request.getServletContext().getAttribute("sharingMarketBoardCategoryService");
	
	    try {
	    request.setAttribute("catList", sharingMarketBoardCategoryService.list());
	    response.setContentType("text/html;charset=UTF-8");
	    request.getRequestDispatcher("/jsp/sharingmarketboard/form.jsp").include(request, response);
    	
    } catch (Exception e) {
    	throw new ServletException(e);
    }
  }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SharingMarketBoardService sharingMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("sharingMarketBoardService");
		SharingMarketBoardCategoryService sharingMarketBoardCategoryService = (SharingMarketBoardCategoryService) request.getServletContext().getAttribute("sharingMarketBoardCategoryService");
		
		SharingMarketBoard smb = new SharingMarketBoard();
		
		try {
			
			int cat = Integer.parseInt(request.getParameter("category"));
			smb.setCategory(sharingMarketBoardCategoryService.get(cat));
			smb.setTitle(request.getParameter("title"));
			smb.setContent(request.getParameter("content"));
			
			Member loginUser = (Member) request.getSession().getAttribute("loginUser");
		   	smb.setWriter(loginUser);
		   	
		   	sharingMarketBoardService.add(smb);
		   	response.sendRedirect("list");
		
		}catch (Exception e) {
			throw new ServletException(e);
		    }

	}
}





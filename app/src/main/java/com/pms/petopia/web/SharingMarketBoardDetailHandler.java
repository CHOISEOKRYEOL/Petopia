package com.pms.petopia.web;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.service.SharingMarketBoardCategoryService;
import com.pms.petopia.service.SharingMarketBoardService;

@SuppressWarnings("serial")
@WebServlet("/sharingmarketboard/detail")
public class SharingMarketBoardDetailHandler extends HttpServlet{

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SharingMarketBoardService sharingMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("sharingMarketBoardService");
		SharingMarketBoardCategoryService sharingMarketBoardCategoryService = (SharingMarketBoardCategoryService) request.getServletContext().getAttribute("sharingMarketBoardCategoryService");
		

	    try {
	     int no = Integer.parseInt(request.getParameter("no"));

	      request.setAttribute("smb", sharingMarketBoardService.get(no));
	      request.setAttribute("catList", sharingMarketBoardCategoryService.list());

	      response.setContentType("text/html;charset=UTF-8");
	      request.getRequestDispatcher("/jsp/sharingmarketboard/detail.jsp").include(request, response);
	    
	    } catch (Exception e) {
	    	throw new ServletException(e);
	    }

		
	}
	

	
}

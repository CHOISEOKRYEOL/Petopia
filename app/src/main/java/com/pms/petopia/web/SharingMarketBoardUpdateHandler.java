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
@WebServlet("/sharingmarketboard/update")
public class SharingMarketBoardUpdateHandler extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	SharingMarketBoardCategoryService sharingMarketBoardCategoryService = (SharingMarketBoardCategoryService) request.getServletContext().getAttribute("sharingMarketBoardCategoryService");
	SharingMarketBoardService sharingMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("sharingMarketBoardService");
	
    try {
    	
    int no = Integer.parseInt(request.getParameter("no"));
    	 
    request.setAttribute("smb", sharingMarketBoardService.get(no));
    request.setAttribute("catList", sharingMarketBoardCategoryService.list());
    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("/jsp/sharingmarketboard/update.jsp").include(request, response);
	
} catch (Exception e) {
	throw new ServletException(e);
}
}
	
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    SharingMarketBoardService sharingMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("sharingMarketBoardService");
    SharingMarketBoardCategoryService sharingMarketBoardCategoryService = (SharingMarketBoardCategoryService) request.getServletContext().getAttribute("sharingMarketBoardCategoryService");
 

    try {
    	
    	 response.setContentType("text/html;charset=UTF-8");
	     request.getRequestDispatcher("/jsp/sharingmarketboard/update.jsp").include(request, response);
	      
	      
      int no = Integer.parseInt(request.getParameter("no"));

      SharingMarketBoard oldBoard = sharingMarketBoardService.get(no);
      if (oldBoard == null) {
        throw new Exception("해당 번호의 게시글이 없습니다.");
      } 

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
        throw new Exception("변경 권한이 없습니다!");
      }

      SharingMarketBoard smbBoard = new SharingMarketBoard();
      smbBoard.setNo(oldBoard.getNo());
     
      int categoryNo = Integer.parseInt(request.getParameter("category"));
      smbBoard.setCategory(sharingMarketBoardCategoryService.get(categoryNo));
      
      smbBoard.setTitle(request.getParameter("title"));
      smbBoard.setContent(request.getParameter("content"));
      
      sharingMarketBoardService.update(smbBoard);
      
      response.sendRedirect("list");

    } catch (Exception e) {
    	 throw new ServletException(e);
    }


  }
}

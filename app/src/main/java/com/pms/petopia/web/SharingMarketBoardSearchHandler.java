package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.service.SharingMarketBoardService;



@SuppressWarnings("serial")
@WebServlet("/sharingmarketboard/search")
public class SharingMarketBoardSearchHandler extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SharingMarketBoardService sharingMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("sharingMarketBoardService");

	    response.setContentType("text/plain;charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    try {
	      String keyword = request.getParameter("keyword");

	      if (keyword.length() == 0) {
	        out.println("검색어를 입력하세요.");
	        return;
	      }

	      List<SharingMarketBoard> list = sharingMarketBoardService.search(keyword);

	      if (list.size() == 0) {
	        out.println("검색어에 해당하는 게시글이 없습니다.");
	        return;
	      }

	      for (SharingMarketBoard smb : list) {
	        out.printf("%d, %s, %s, %s, %d\n", 
	            smb.getNo(), 
	            smb.getCategory(),
	            smb.getTitle(), 
	            smb.getWriter().getName(),
	            smb.getCreatedDate());
	      }

	    } catch (Exception e) {
	      StringWriter strWriter = new StringWriter();
	      PrintWriter printWriter = new PrintWriter(strWriter);
	      e.printStackTrace(printWriter);
	      out.println(strWriter.toString());
	    }
	
	
	}

}

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
import com.pms.petopia.domain.SharingMarketBoardCategory;
import com.pms.petopia.service.SharingMarketBoardService;

@SuppressWarnings("serial")
@WebServlet("/sharingmarketboard/add")
public class SharingMarketBoardAddHandler extends HttpServlet {
	
	@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	SharingMarketBoardService sharingMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("sharingMarketBoardService");
	SharingMarketBoard smb = new SharingMarketBoard();
	SharingMarketBoardCategory c = new SharingMarketBoardCategory();
	
	request.setCharacterEncoding("UTF-8");
	
	c.setNo(Integer.parseInt(request.getParameter("category")));
	smb.setCategory(c);
	smb.setTitle(request.getParameter("title"));
	smb.setContent(request.getParameter("content"));
	
	Member loginUser = (Member) request.getSession().getAttribute("loginUser");
	smb.setWriter(loginUser);
	
	response.setContentType("text/html;charset=UTF-8");
	PrintWriter out = response.getWriter();
	  
	
	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>나눔장터 게시 등록</title>");

    try {
      sharingMarketBoardService.add(smb);

      out.println("<p>나눔장터 게시글을 등록했습니다.</p>");
      response.setHeader("Refresh", "1;url=../main");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>나눔 장터 게시글 등록 오류</h1>");
      out.printf("<pre>%s</pre>\n", strWriter.toString());
      out.println("<p><a href='list'>목록</a></p>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}





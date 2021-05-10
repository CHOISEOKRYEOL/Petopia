package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pms.petopia.domain.Comment;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.CommentService;

@SuppressWarnings("serial")
public class SharingMarketBoardCommentAddHandler extends HttpServlet{
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	CommentService commentService = (CommentService) request.getServletContext().getAttribute("commentService");
	Comment cont = new Comment();
	
	request.setCharacterEncoding("UTF-8");
	cont.setContent(request.getParameter("cont"));
    
	
	  HttpServletRequest httpRequest = request;
	    Member loginUser = (Member) httpRequest.getSession().getAttribute("loginUser");
	    cont.setWriter(loginUser);
	  response.setContentType("text/html;charset=UTF-8");
	  
	  PrintWriter out = response.getWriter();

	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>댓글</title>");

	    try {
	    	commentService.add(cont);

	      out.println("<meta http-equiv='Refresh' content='1; url=list'>");
	      out.println("</head>");
	      out.println("<body>");
	      out.println("<h1>댓글 등록</h1>");
	      out.println("<p>댓글을 등록했습니다.</p>");

	    } catch (Exception e) {
	      StringWriter strWriter = new StringWriter();
	      PrintWriter printWriter = new PrintWriter(strWriter);
	      e.printStackTrace(printWriter);

	      out.println("</head>");
	      out.println("<body>");
	      out.println("<h1>댓글 등록 오류</h1>");
	      out.printf("<pre>%s</pre>\n", strWriter.toString());
	      out.println("<p><a href='list'>목록</a></p>");
	    }

	    out.println("</body>");
	    out.println("</html>");

	}
	
}

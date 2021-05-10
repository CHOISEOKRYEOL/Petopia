package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pms.petopia.domain.Comment;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.CommentService;

@SuppressWarnings("serial")
@WebServlet("/sharingmarketboard/update")
public class SharingMarketBoardCommentUpdateHandler extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		CommentService commentService = (CommentService) request.getServletContext().getAttribute("commentService");
	    response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>나눔장터 게시글 변경</title>");

	    try {
	      request.setCharacterEncoding("UTF-8");
	      int no = Integer.parseInt(request.getParameter("no"));

	      Comment oldCont = commentService.get(no);
	      if (oldCont == null) {
	        throw new Exception("해당 번호의 게시글이 없습니다.");
	      } 

	      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
	      if (oldCont.getWriter().getNo() != loginUser.getNo()) {
	        throw new Exception("변경 권한이 없습니다!");
	      }

	      Comment cont = new Comment();
	      cont.setNo(oldCont.getNo());
	      cont.setContent(request.getParameter("content"));
	      commentService.update(cont);

	      out.println("<meta http-equiv='Refresh' content='1;url=list'>");
	      out.println("</head>");
	      out.println("<body>");
	      out.println("<h1>댓글 변경</h1>");
	      out.println("<p>댓글을 변경하였습니다.</p>");

	    } catch (Exception e) {
	      StringWriter strWriter = new StringWriter();
	      PrintWriter printWriter = new PrintWriter(strWriter);
	      e.printStackTrace(printWriter);

	      out.println("</head>");
	      out.println("<body>");
	      out.println("<h1>나눔장터 게시글 변경 오류</h1>");
	      out.printf("<p>%s</p>\n", e.getMessage());
	      out.printf("<pre>%s</pre>\n", strWriter.toString());
	      out.println("<p><a href='list'>목록</a></p>");
	    }

	    out.println("</body>");
	    out.println("</html>");
	
	
	}
}

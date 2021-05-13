package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.service.SharingMarketBoardService;

@SuppressWarnings("serial")
@WebServlet("/sharingmarketboard/detail")
public class SharingMarketBoardDetailHandler extends HttpServlet{

	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SharingMarketBoardService sharingMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("sharingMarketBoardService");
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>나눔장터 게시글 상세</title>");
	    out.println("</head>");
	    out.println("<smbody>");
	    out.println("<h1>나눔장터 게시글 상세보기</h1>");

	    try {
	    	
	     int no = Integer.parseInt(request.getParameter("no"));
	    	
	     SharingMarketBoard smb = sharingMarketBoardService.get(no);
	     
	      if (smb == null) {
	        out.println("<p>해당 번호의 게시글이 없습니다.</p>");
	        return;
	      }
	      
	      out.println("<form action='update' method='post'>");
	      out.println("<table border='1'>");
	      out.println("<tsmbody>");
	      out.printf("<tr><th>번호</th>"
	          + " <td><input type='text' name='no' value='%d' readonly></td></tr>\n", smb.getNo());
	      
	      out.printf("<tr><th>카테고리</th>"
		          + " <td><input type='text' name='category' value='%s' readonly></td></tr>\n",smb.getCategory().getName());
	      out.println("<br>");
	      out.printf("<tr><th>제목</th>"
	          + " <td><input name='title' type='text' value='%s'></td></tr>\n", smb.getTitle());
	      out.println("<br>");
	      out.printf("<tr><th>내용</th>"
	          + " <td><textarea name='content' rows='10' cols='60'>%s</textarea></td></tr>\n", smb.getContent());
	      out.printf("<tr><th>작성자</th> <td>%s</td></tr>\n", smb.getWriter().getName());
	      out.printf("<tr><th>작성일</th> <td>%s</td></tr>\n", formatter.format(smb.getCreatedDate()));
	      out.printf("<tr><th>조회수</th> <td>%s</td></tr>\n", smb.getViewCount());
	   
	      out.println("</tsmbody>");

	      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
	      
	      if (loginUser != null && smb.getWriter().getNo() == loginUser.getNo()) {
	        out.println("<tfoot>");
	        out.println("<tr><td colspan='2'>");
	        out.println("<input type='submit' value='변경'> "
	            + "<a href='delete? no=" + smb.getNo() + "'>삭제</a> ");
	        out.println("</td></tr>");
	        out.println("</tfoot>");
	      }

	      out.println("</table>");
	      out.println("</form>");


	    } catch (Exception e) {
	      StringWriter strWriter = new StringWriter();
	      PrintWriter printWriter = new PrintWriter(strWriter);
	      e.printStackTrace(printWriter);
	      out.printf("<pre>%s</pre>\n", strWriter.toString());
	    }
	    out.println("<p><a href='list'>목록</a></p>");

	    out.println("</smbody>");
	    out.println("</html>");
		
	}
	
}

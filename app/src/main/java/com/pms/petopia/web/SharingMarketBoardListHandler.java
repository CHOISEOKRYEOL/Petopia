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
@WebServlet("/sharingmarketboard/list")
public class SharingMarketBoardListHandler extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SharingMarketBoardService shareMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("shareMarketBoardService");
		
		response.setContentType("text/html;charset=UTF-8");
	    PrintWriter out = response.getWriter();

	    out.println("<!DOCTYPE html>");
	    out.println("<html>");
	    out.println("<head>");
	    out.println("<title>나눔장터 게시글 목록</title>");
	    out.println("</head>");
	    out.println("<body>");
	    out.println("<h1>나눔 장터 게시글 목록</h1>");

	    out.println("<p><a href='form.html'>새 글</a></p>");
	    
        out.println("<form action='search' method='get'>");
        out.println("<input type='text' name='keyword'> ");
        out.println("<button>검색</button>");
        out.println("</form>");
	    
	    
	    try {
	        List<SharingMarketBoard> smBoards = shareMarketBoardService.list();

	        out.println("<table border='1'>");
	        out.println("<thead>");
	        out.println("<tr>");
	        out.println("<th>번호</th> <th>분류</th> <th>제목</th> <th>작성자</th> <th>작석일</th>");
	        out.println("</tr>");
	        out.println("</thead>");
	        out.println("<tbody>");

	        for (SharingMarketBoard smb : smBoards) {
	          out.printf("<tr>"
	              + " <td>%d</td>"
	              + " <td><a href='detail?no=%1$d'>%s</a></td>"
	              + " <td>%s</td>"
	              + " <td>%s</td>"
	              + " <td>%d</td> </tr>\n", 
	              smb.getNo(),
	              smb.getCategory(),
	              smb.getTitle(), 
	              smb.getWriter().getName(),
	              smb.getCreatedDate());
	        }
	        out.println("</tbody>");
	        out.println("</table>");
	        
	        out.println("<form action='search' method='get'>");
	        out.println("<input type='text' name='keyword'> ");
	        out.println("<button>검색</button>");
	        out.println("</form>");



	      } catch (Exception e) {
	        // 상세 오류 내용을 StringWriter로 출력한다.
	        StringWriter strWriter = new StringWriter();
	        PrintWriter printWriter = new PrintWriter(strWriter);
	        e.printStackTrace(printWriter);

	        // StringWriter 에 들어 있는 출력 내용을 꺼내 클라이언트로 보낸다.
	        out.printf("<pre>%s</pre>\n", strWriter.toString());
	      }

	      out.println("</body>");
	      out.println("</html>");
	}
}

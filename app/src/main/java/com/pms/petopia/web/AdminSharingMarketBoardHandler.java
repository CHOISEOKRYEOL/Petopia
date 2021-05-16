package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.service.SharingMarketBoardService;

@SuppressWarnings("serial")
@WebServlet("/admin/sharingmarketlist")
public class AdminSharingMarketBoardHandler extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    SharingMarketBoardService sharingMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("sharingMarketBoardService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>나눔장터 게시글 목록</title>");
    out.println("</head>");
    out.println("<body>");

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if(loginUser.getRole() != 0) {
      out.println("<h1>접근 권한이 없습니다.</h1>");
      return;
    }

    out.println("<h1>나눔 장터 게시글 목록</h1>");

    out.println("<p><a href='shareform.html'>새 글</a></p>");

    out.println("<form action='search' method='get'>");
    out.println("<input type='text' name='keyword'> ");
    out.println("<button>검색</button>");
    out.println("</form>");


    try {
      List<SharingMarketBoard> smBoards = sharingMarketBoardService.list();

      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>번호</th> <th>분류</th> <th>제목</th> <th>작성자</th> <th>작성일</th>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");

      for (SharingMarketBoard smb : smBoards) {
        out.printf("<tr>"
            + " <td>%d</td>"
            + " <td>%s</td>"
            + " <td><a href='detail?no=%1$d'>%s</a></td>"
            + " <td>%s</td>"
            + " <td>%d</td> </tr>\n", 
            smb.getNo(),
            smb.getCategory().getName(),
            smb.getTitle(),
            smb.getWriter().getName(),
            smb.getCreatedDate());
        out.printf("<a href='sharingmarketsmboard/delete=no?" + smb.getNo() + "'> 삭제</a> ");
      }
      out.println("</tbody>");
      out.println("</table>");

      out.println("<form action='search' method='get'>");
      out.println("<input type='text' name='keyword'> ");
      out.println("<button>검색</button>");
      out.println("</form>");



    } catch (Exception e) {
      throw new ServletException(e);
    }

    out.println("</body>");
    out.println("</html>");
  }
}
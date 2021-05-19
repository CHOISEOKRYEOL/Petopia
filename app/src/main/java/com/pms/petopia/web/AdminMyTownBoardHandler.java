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
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.service.MyTownBoardService;

@SuppressWarnings("serial")
@WebServlet("/admin/mytownlist")

public class AdminMyTownBoardHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MyTownBoardService myTownBoardService = (MyTownBoardService) request.getServletContext().getAttribute("myTownBoardService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    int stateNo = Integer.parseInt(request.getParameter("stateNo"));
    int cityNo = Integer.parseInt(request.getParameter("cityNo"));

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.printf("<title>게시글 목록</title>");
    out.println("</head>");
    out.println("<body>");

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if(loginUser.getRole() != 0) {
      out.println("<h1>접근 권한이 없습니다.</h1>");
      return;
    }

    try {
      List<MyTownBoard> boards = myTownBoardService.list(cityNo,stateNo);
      MyTownBoard board = boards.get(0);
      out.printf("<h1>%s %s</h1>", board.getBigAddress().getName(), board.getSmallAddress().getName());
      out.println("<p><a href='form.html'>새 글</a></p>");
      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>번호</th> <th>제목</th> <th>작성자</th> <th>등록일</th> <th>조회수</th> <th>댓글수</th>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");

      for (MyTownBoard b : boards) {
        out.printf("<tr>"
            + " <td>%d</td>"
            + " <td><a href='detail?no=%1$d'>%s</a></td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%d</td>"
            + " <td>%d</td></tr>\n", 
            b.getNo(), 
            b.getTitle(), 
            b.getWriter().getNick(),
            b.getCreatedDate(),
            b.getViewCount(),
            b.getLikeCount());
        out.printf("<a href='mytown/delete=no?" + b.getNo() + "'> 삭제</a> ");
      }
      out.println("</tbody>");
      out.println("</table>");

      out.println("<form action='search' method='get'>");
      out.println("<input type='text' name ='keyword'>");
      out.println("<button> 검색 </button>");
      out.println("</form>");
    } catch (Exception e) {
      throw new ServletException(e);
    }
    out.println("</body>");
    out.println("</html>");
  }



}







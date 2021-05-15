package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Story;
import com.pms.petopia.service.StoryService;

@SuppressWarnings("serial")
@WebServlet("/story/detail")
public class StoryDetailHandler extends HttpServlet {

  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    StoryService storyService = (StoryService) request.getServletContext().getAttribute("storyService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>스토리 상세</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>스토리 상세보기</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Story s = storyService.get(no);

      if (s == null) {
        out.println("<p>해당 번호의 스토리가 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      out.println("<form action='update' method='post'>");
      out.println("<table border='1'>");
      out.println("<tbody>");
      out.printf("<tr><th>번호</th>"
          + " <td><input type='text' name='no' value='%d' readonly></td></tr>\n", 
          s.getNo());
      out.printf("<tr><th>제목</th>"
          + " <td><input name='title' type='text' value='%s'></td></tr>\n", 
          s.getTitle());
      out.printf("<tr><th>URL</th>"
          + " <td><input name='url' type='url' value='%s'></td></tr>\n", 
          s.getUrl());
      out.printf("<tr><th>사이트</th>"
          + " <td><input name='site' type='text' value='%s'></td></tr>\n", 
          s.getSite());
      out.printf("<tr><th>등록일</th> <td>%s</td></tr>\n", formatter.format(s.getRegisteredDate()));
      out.println("</tbody>");

      out.println("<tfoot>");
      out.println("<tr><td colspan='2'>");
      out.printf("<input type='submit' value='변경'> <a href='delete?no=%d'>삭제</a>", s.getNo());
      out.println("</td></tr>");
      out.println("</tfoot>");

      out.println("</table>");
      out.println("</form>");

    } catch (Exception e) {
      throw new ServletException(e);
    }
    out.println("<p><a href='list'>목록</a></p>");

    out.println("</body>");
    out.println("</html>");
  }
}

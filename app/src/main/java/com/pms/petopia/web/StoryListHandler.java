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
import com.pms.petopia.domain.Story;
import com.pms.petopia.service.StoryService;

@SuppressWarnings("serial")
@WebServlet("/story/list")
public class StoryListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    StoryService storyService = (StoryService) request.getServletContext().getAttribute("storyService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>스토리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>스토리</h1>");

    out.println("<p><a href='add'>새 스토리</a></p>");

    try {
      List<Story> storys = storyService.list(); 

      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>번호</th> <th>제목</th> <th>URL</th> <th>사이트</th> <th>등록일</th>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");

      for (Story s : storys) {
        out.printf("<tr>"
            + " <td>%d</td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%s</td> </tr>\n",
            s.getNo(),
            s.getTitle(),
            s.getUrl(),
            s.getSite(),
            s.getRegisteredDate());
      }
      out.println("</tbody");
      out.println("</table>");

      out.println("<form action='search' method='get'>");
      out.println("<input type='text' name='keyword'> ");
      out.println("<button>검색</button>");
      out.println("</form>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }
}

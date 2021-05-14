package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Story;
import com.pms.petopia.service.StoryService;

@SuppressWarnings("serial")
@WebServlet("/story/add")
public class StoryAddHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<meta charset='UTF-8'>");
    out.println("<title>새 스토리</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>새 스토리</h1>");
    out.println("<form action='add' method='post'>");
    out.println("제목: <input type='text' name='title'><br>");
    out.println("URL: <input type='url' name='url'><br>");
    out.println("사이트: <input type='text' name='site'><br>");

    out.println("<input type='submit' value='등록'>");
    out.println("</form>");
    out.println("<form action='../main'>");
    out.println("<input type='submit' value='취소'>");
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    StoryService storyService = (StoryService) request.getServletContext().getAttribute("storyService");

    Story s = new Story();

    request.setCharacterEncoding("UTF-8");

    s.setTitle(request.getParameter("title"));
    s.setUrl(request.getParameter("url"));
    s.setSite(request.getParameter("site"));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>스토리 등록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>스토리 등록</h1>");

    try {
      storyService.add(s);

      out.println("<p>스토리를 등록했습니다.</p>");
      response.setHeader("Refresh", "1;url=../main");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>스토리 등록 오류</h1>");
      out.printf("<pre>%s</pre>\n", strWriter.toString());
      out.println("<p><a href='list'>목록</a></p>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}

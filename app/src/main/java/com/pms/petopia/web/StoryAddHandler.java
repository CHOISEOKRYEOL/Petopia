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
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    StoryService storyService = (StoryService) request.getServletContext().getAttribute("storyService");

    Story story = new Story();

    request.setCharacterEncoding("UTF-8");

    story.setTitle(request.getParameter("title"));
    story.setUrl(request.getParameter("url"));
    story.setSite(request.getParameter("site"));

    //    HttpServletRequest httpRequest = request;
    //    Member loginUser = (Member) httpRequest.getSession().getAttribute("loginUser");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>스토리 등록</title>");

    try {
      storyService.add(story);

      out.println("<meta http-equiv='Refresh' content='1;url=list'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>스토리 등록</h1>");
      out.println("<p>스토리를 등록했습니다.</p>");

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
package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Story;
import com.pms.petopia.service.StoryService;

@SuppressWarnings("serial")
@WebServlet("/story/update")
public class StoryUpdateHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    StoryService storyService = (StoryService) request.getServletContext().getAttribute("storyService");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Story oldStory = storyService.get(no);
      if (oldStory == null) {
        throw new Exception("해당 번호의 스토리가 없습니다.");
      }

      Story story = new Story();
      story.setNo(oldStory.getNo());
      story.setTitle(request.getParameter("title"));
      story.setUrl(request.getParameter("url"));
      story.setSite(request.getParameter("site"));

      storyService.update(story);

      response.sendRedirect("list");

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

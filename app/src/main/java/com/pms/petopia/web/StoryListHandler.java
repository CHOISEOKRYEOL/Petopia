package com.pms.petopia.web;

import java.io.IOException;
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

    try {
      String keyword = request.getParameter("keyword");
      List<Story> storys = null;
      if (keyword != null && keyword.length() > 0) {
        storys = storyService.search(keyword);
      } else {
        storys = storyService.list();
      }

      request.setAttribute("list", storys);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/story/list.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

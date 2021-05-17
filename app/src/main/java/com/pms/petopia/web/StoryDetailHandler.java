package com.pms.petopia.web;

import java.io.IOException;
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

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Story s = storyService.get(no);
      request.setAttribute("story", s);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/story/detail.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

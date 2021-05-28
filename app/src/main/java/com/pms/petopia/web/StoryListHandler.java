package com.pms.petopia.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Scrap;
import com.pms.petopia.domain.Story;
import com.pms.petopia.service.ScrapService;
import com.pms.petopia.service.StoryService;

@SuppressWarnings("serial")
@WebServlet("/story/list")
public class StoryListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    StoryService storyService = (StoryService) request.getServletContext().getAttribute("storyService");
    ScrapService scrapService = (ScrapService) request.getServletContext().getAttribute("scrapService");


    try {
      String keyword = request.getParameter("keyword");
      List<Story> storys = null;
      if (keyword != null && keyword.length() > 0) {
        storys = storyService.search(keyword);
      } else {
        storys = storyService.list();
      }
      List<Scrap> scrapList = null;
      if ((Member)request.getSession().getAttribute("loginUser") != null) {
        Member loginUser = (Member)request.getSession().getAttribute("loginUser");

        scrapList = scrapService.list(loginUser.getNo());

      }

      request.setAttribute("scrapList", scrapList);
      request.setAttribute("storys", storys);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/story/list.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

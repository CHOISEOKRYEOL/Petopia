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
import com.pms.petopia.domain.Scrap;
import com.pms.petopia.domain.Story;
import com.pms.petopia.service.ScrapService;
import com.pms.petopia.service.StoryService;

@SuppressWarnings("serial")
@WebServlet("/story/scrapcheck")
public class ScrapCheckHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    StoryService storyService = (StoryService) request.getServletContext().getAttribute("storyService");
    ScrapService scrapService = (ScrapService) request.getServletContext().getAttribute("scrapService");

    PrintWriter out = response.getWriter();

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
        System.out.println("여");
        if (scrapList.size() == 0) {
          for (Story story : storys) {
            System.out.println("beforescrap" + story.getNo());
            out.print("beforescrap");
          }
        } else {

          for (Scrap scrap : scrapList) {
            for(Story story : storys) {
              if (scrap.getStory().getNo() != story.getNo() || scrap == null) {
                System.out.println("beforescrap" + story.getNo());
                out.print("beforescrap");
              } else {
                System.out.println("alreadyscrap" + story.getNo());
                out.print("alreadyscrap");
              }
            }
          }

        }
      }

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

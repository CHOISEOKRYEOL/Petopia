package com.pms.petopia.web;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Scrap;
import com.pms.petopia.domain.Story;
import com.pms.petopia.service.ScrapService;
import com.pms.petopia.service.StoryService;

@Controller
public class ScrapCheckHandler {

  StoryService storyService;
  ScrapService scrapService;

  public ScrapCheckHandler(StoryService storyService, ScrapService scrapService) {
    this.storyService = storyService;
    this.scrapService = scrapService;
  }

  @RequestMapping("/story/scrapcheck")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    PrintWriter out = response.getWriter();

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
    return ""; // 체크
  }
}

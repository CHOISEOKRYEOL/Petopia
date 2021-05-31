package com.pms.petopia.web;

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
public class StoryListHandler {

  StoryService storyService;
  ScrapService scrapService;

  public StoryListHandler(StoryService storyService, ScrapService scrapService) {
    this.storyService = storyService;
    this.scrapService = scrapService;
  }

  @RequestMapping("/story/list")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

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

    return "/jsp/story/list.jsp";

  }
}

package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Story;
import com.pms.petopia.service.StoryService;

@Controller
public class StoryDetailHandler {

  StoryService storyService;

  public StoryDetailHandler(StoryService storyService) {
    this.storyService = storyService;
  }

  @RequestMapping("/story/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Story story = storyService.get(no);
    request.setAttribute("story", story);

    return "/jsp/story/detail.jsp";

  }
}

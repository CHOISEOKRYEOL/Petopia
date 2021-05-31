package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Story;
import com.pms.petopia.service.StoryService;

@Controller
public class StoryAddHandler {

  StoryService storyService;

  public StoryAddHandler(StoryService storyService) {
    this.storyService = storyService;
  }

  @RequestMapping("/story/add")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    if(request.getMethod().equals("GET")) {
      return "/jsp/story/form.jsp";
    }

    Story s = new Story();
    s.setTitle(request.getParameter("title"));
    s.setUrl(request.getParameter("url"));
    s.setSite(request.getParameter("site"));

    storyService.add(s);

    return "redirect:list";
  }
}

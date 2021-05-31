package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Story;
import com.pms.petopia.service.StoryService;

@Controller
public class StoryDeleteHandler {

  StoryService storyService;

  public StoryDeleteHandler(StoryService storyService) {
    this.storyService = storyService;
  }

  @RequestMapping("/story/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Story oldStory = storyService.get(no);
    if (oldStory == null) {
      throw new Exception("해당 번호의 스토리가 없습니다.");
    }

    storyService.delete(no);

    return "redirect:list";
  }
}

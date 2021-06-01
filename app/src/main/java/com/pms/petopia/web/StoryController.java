package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Scrap;
import com.pms.petopia.domain.Story;
import com.pms.petopia.service.ScrapService;
import com.pms.petopia.service.StoryService;

@Controller
@RequestMapping("/story")
public class StoryController {

  StoryService storyService;
  ScrapService scrapService;

  public StoryController(StoryService storyService, ScrapService scrapService) {
    this.storyService = storyService;
    this.scrapService = scrapService;
  }

  @RequestMapping(path="form", method = RequestMethod.GET)
  public void form() throws Exception {
  }

  @RequestMapping(path="add", method = RequestMethod.POST)
  public String add(Story s) throws Exception {

    storyService.add(s);
    return "redirect:list";
  }

  @RequestMapping(path="delete", method = RequestMethod.GET)
  public String delete(int no) throws Exception {

    Story oldStory = storyService.get(no);
    if (oldStory == null) {
      throw new Exception("해당 번호의 스토리가 없습니다.");
    }

    storyService.delete(no);

    return "redirect:list";
  }

  @RequestMapping(path="detail", method = RequestMethod.GET)
  public void detail(int no, Model model) throws Exception {
    model.addAttribute("story", storyService.get(no));
  }

  @RequestMapping(path="list", method = RequestMethod.GET)
  public void list(String keyword, Model model, HttpSession session) throws Exception {

    List<Story> storys = null;
    if (keyword != null && keyword.length() > 0) {
      storys = storyService.search(keyword);
    } else {
      storys = storyService.list();
    }

    List<Scrap> scrapList = null;
    if ((Member) session.getAttribute("loginUser") != null) {
      Member loginUser = (Member) session.getAttribute("loginUser");
      scrapList = scrapService.list(loginUser.getNo());
    }

    model.addAttribute("scrapList", scrapList);
    model.addAttribute("storys", storys);
  }

  @RequestMapping(path="update", method = RequestMethod.POST)
  public String update(Story story) throws Exception {

    Story oldStory = storyService.get(story.getNo());
    if (oldStory == null) {
      throw new Exception("해당 번호의 스토리가 없습니다.");
    }

    storyService.update(story);

    return "redirect:list";
  }
}

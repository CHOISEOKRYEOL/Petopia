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
@RequestMapping("/story")
public class StoryController {

  StoryService storyService;
  ScrapService scrapService;

  public StoryController(StoryService storyService) {
    this.storyService = storyService;
  }

  @RequestMapping("add")
  public String add(HttpServletRequest request, HttpServletResponse response)
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

  @RequestMapping("delete")
  public String delete(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Story oldStory = storyService.get(no);
    if (oldStory == null) {
      throw new Exception("해당 번호의 스토리가 없습니다.");
    }

    storyService.delete(no);

    return "redirect:list";
  }

  @RequestMapping("detail")
  public String detail(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Story story = storyService.get(no);
    request.setAttribute("story", story);

    return "/jsp/story/detail.jsp";

  }

  @RequestMapping("list")
  public String list(HttpServletRequest request, HttpServletResponse response)
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

  @RequestMapping("update")
  public String update(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Story oldStory = storyService.get(no);
    if (oldStory == null) {
      throw new Exception("해당 번호의 스토리가 없습니다.");
    }

    Story story = new Story();
    story.setNo(oldStory.getNo());
    story.setTitle(request.getParameter("title"));
    story.setUrl(request.getParameter("url"));
    story.setSite(request.getParameter("site"));

    storyService.update(story);

    return "redirect:list";

  }

}

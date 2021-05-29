package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
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
public class ScrapAddHandler {

  ScrapService scrapService;
  StoryService storyService;

  public ScrapAddHandler(ScrapService scrapService, StoryService storyService) {
    this.scrapService = scrapService;
    this.storyService = storyService;
  }

  @RequestMapping("/story/scrapadd")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int newsNo = Integer.parseInt(request.getParameter("newsNo"));

    PrintWriter out = response.getWriter();
    Scrap scrap = new Scrap();
    int count = 0;
    try {
      Story story = storyService.get(newsNo);
      scrap.setStory(story);
      Member loginUser = (Member)request.getSession().getAttribute("loginUser");
      if(loginUser == null) {
        out.print("login");
      }
      scrap.setMember(loginUser);

      //여기서 로그인 체크
      List<Scrap> scraps = scrapService.list(loginUser.getNo());



      if(scraps.size() == 0) {
        scrapService.add(scrap);
        out.print("success");
      } else {
        for(Scrap s : scraps) {
          if (s.getStory().getNo() != newsNo && s.getMember().getNo() != loginUser.getNo()
              || s.getStory().getNo() == newsNo && s.getMember().getNo() != loginUser.getNo()
              || s.getStory().getNo() != newsNo && s.getMember().getNo() == loginUser.getNo()) {
            count++;
            if(count == scraps.size()) {
              scrapService.add(scrap);
              scrapService.updateScrap(newsNo);
              out.print("success");
            }
          } else {
            out.print("fail");
          }
        }
      }
    }
    return ""; // 체크
  }
}
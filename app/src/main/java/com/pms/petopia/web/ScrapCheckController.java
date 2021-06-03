package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Scrap;
import com.pms.petopia.service.ScrapService;
import com.pms.petopia.service.StoryService;

@Controller
public class ScrapCheckController {

  ScrapService scrapService;
  StoryService storyService;

  public ScrapCheckController(ScrapService scrapService, StoryService storyService) {
    this.scrapService = scrapService;
    this.storyService = storyService;
  }

  @RequestMapping("/story/scrapcheck")
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PrintWriter out = response.getWriter();

    try {

      System.out.println("scrapcheck");

      int newsNo = Integer.parseInt(request.getParameter("no"));

      if ((Member)request.getSession().getAttribute("loginUser") != null) {
        Member loginUser = (Member)request.getSession().getAttribute("loginUser");

        System.out.println(loginUser);
        List<Scrap> scrapList = scrapService.list(loginUser.getNo());
        System.out.println("login 완료");
        if(scrapList == null) {
          System.out.println("스크랩한게 없음");
          System.out.println("0");
        }
        for (Scrap scrap : scrapList) {
          if (scrap.getMember().getNo() == loginUser.getNo() && scrap.getStory().getNo() == newsNo) {
            System.out.println("1");
            out.print("1");
          } else {
            System.out.println("0");
            out.print("0");
          }
        }
      }


    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}
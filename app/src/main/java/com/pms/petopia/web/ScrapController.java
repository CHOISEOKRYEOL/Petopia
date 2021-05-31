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
@RequestMapping("/scrap")
public class ScrapController {

  ScrapService scrapService;
  StoryService storyService;

  public ScrapController(ScrapService scrapService, StoryService storyService) {
    this.scrapService = scrapService;
    this.storyService = storyService;
  }

  @RequestMapping("add")
  public String add(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int newsNo = Integer.parseInt(request.getParameter("newsNo"));

    PrintWriter out = response.getWriter();
    Scrap scrap = new Scrap();
    int count = 0;
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
    return ""; // 체크
  }






  @RequestMapping("check")
  public String check(HttpServletRequest request, HttpServletResponse response)
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
            ScrapService scrapService = (ScrapService) request.getServletContext().getAttribute("scrapService");

            PrintWriter out = response.getWriter();

            try {

              int newsNo = Integer.parseInt(request.getParameter("no"));

              List<Scrap> scrapList = null;
              if ((Member)request.getSession().getAttribute("loginUser") != null) {
                Member loginUser = (Member)request.getSession().getAttribute("loginUser");

                scrapList = scrapService.list(loginUser.getNo());

                for (Scrap scrap : scrapList) {
                  if (scrap.getMember().getNo() == loginUser.getNo() && scrap.getStory().getNo() == newsNo) {
                    out.print("1");
                  } else {
                    out.print("0");
                  }
                }

              }

              return ""; // 체크
            }
          }
        }
      }
    }
  }


  @RequestMapping("delete")
  public String delete(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int scrapNo = Integer.parseInt(request.getParameter("scrapNo"));

    scrapService.delete(scrapNo);

    return "redirect:../mypage/scraplist";

  }


  @RequestMapping("list")
  public String list(HttpServletRequest request, HttpServletResponse response)
      throws Exception {


    Member loginUser = (Member)request.getSession().getAttribute("loginUser");
    List<Scrap> scrapList = scrapService.list(loginUser.getNo());

    String emptyList = null;
    if (scrapList.size() == 0) {
      emptyList = "true";
    }

    request.setAttribute("emptyList", emptyList);
    request.setAttribute("scrapList", scrapList);

    return "/jsp/mypage/scraplist.jsp";
  }


}
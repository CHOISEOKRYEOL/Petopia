package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Scrap;
import com.pms.petopia.service.ScrapService;

@Controller
public class ScrapListHandler {

  ScrapService scrapService;

  public ScrapListHandler(ScrapService scrapService) {
    this.scrapService = scrapService;
  }

  @RequestMapping("/mypage/scraplist")
  public String execute(HttpServletRequest request, HttpServletResponse response)
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

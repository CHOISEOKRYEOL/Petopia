package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.service.ScrapService;

@Controller
public class ScrapDeleteHandler {

  ScrapService scrapService;

  public ScrapDeleteHandler(ScrapService scrapService) {
    this.scrapService = scrapService;
  }

  @RequestMapping("/story/scrapdelete")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int scrapNo = Integer.parseInt(request.getParameter("scrapNo"));

    scrapService.delete(scrapNo);

    return "redirect:../mypage/scraplist";

  }
}

package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyPageHandler {

  @RequestMapping("/mypage/main")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    return "/jsp/mypage/main.jsp";
  }
}
package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.service.MyTownBoardService;

@Controller
@RequestMapping("/mypage")
public class MyPageHandler {

  MyTownBoardService myTownBoardService;

  public MyPageHandler(MyTownBoardService myTownBoardService) {
    this.myTownBoardService = myTownBoardService;
  }

  @RequestMapping("main")
  public String main(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    return "/jsp/mypage/main.jsp";
  }

  @RequestMapping("mytownlist")
  public void mytownlist(HttpSession session, Model model) throws Exception {

    Member loginUser = (Member)session.getAttribute("loginUser");
    List<MyTownBoard> myTownList = myTownBoardService.listMine(loginUser.getNo());

    model.addAttribute("myTownList", myTownList);
  }
}
package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.service.MyTownBoardService;


@Controller
public class MyTownMyListHandler {

  MyTownBoardService myTownBoardService;

  public MyTownMyListHandler(MyTownBoardService myTownBoardService) {
    this.myTownBoardService = myTownBoardService;
  }

  @RequestMapping("/mypage/mytownlist")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {


    //int memberNo = Integer.parseInt(request.getParameter("memberNo"));

    Member loginUser = (Member)request.getSession().getAttribute("loginUser");
    List<MyTownBoard> myTownList = myTownBoardService.listMine(loginUser.getNo());

    String emptyList = null;
    if (myTownList.size() == 0) {
      emptyList = "true";
    }

    request.setAttribute("emptyList", emptyList);
    request.setAttribute("myTownList", myTownList);

    return "/jsp/mypage/mytownlist.jsp";
  }
}

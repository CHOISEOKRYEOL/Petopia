package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.RecommentService;
import com.pms.petopia.service.SmallAddressService;

@Controller
public class MyTownBoardListHandler {

  MyTownBoardService myTownBoardService;
  SmallAddressService smallAddressService;
  RecommentService recommentService;

  public MyTownBoardListHandler(MyTownBoardService myTownBoardService, SmallAddressService smallAddressService, RecommentService recommentService) {
    this.myTownBoardService = myTownBoardService;
    this.smallAddressService = smallAddressService;
    this.recommentService = recommentService;
  }

  @RequestMapping("/mytown/list")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int stateNo = Integer.parseInt(request.getParameter("stateNo"));
    int cityNo = Integer.parseInt(request.getParameter("cityNo"));
    String keyword = request.getParameter("keyword");
    String r = request.getParameter("r");

    List<MyTownBoard> boards = myTownBoardService.list(cityNo, stateNo);
    SmallAddress smallAddress = smallAddressService.get(cityNo);
    List<SmallAddress> smallAddresses = smallAddressService.list();

    if (boards.size() > 0) {

      if (keyword != null && keyword.length() > 0 && r == null) {
        boards = myTownBoardService.search(stateNo, cityNo, keyword);
      }else if(keyword == null && r != null) {
        boards = myTownBoardService.listRecomment(stateNo, cityNo);
      }else {
        boards = myTownBoardService.list(stateNo, cityNo);
      }
    }
    request.setAttribute("boards", boards);
    request.setAttribute("smallAddresses", smallAddresses);
    request.setAttribute("smallAddress", smallAddress);
    request.setAttribute("keyword", keyword);
    request.setAttribute("r", r);
    request.setAttribute("stateNo", stateNo);
    request.setAttribute("cityNo", cityNo);

    return "/jsp/mytown/list.jsp";
  }
}
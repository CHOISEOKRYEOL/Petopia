package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.MyTownBoardComment;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.MyTownBoardCommentService;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.SmallAddressService;

@Controller
public class MyTownBoardDetailHandler {

  MyTownBoardService myTownBoardService;
  SmallAddressService smallAddressService;
  MyTownBoardCommentService myTownBoardCommentService;

  public MyTownBoardDetailHandler(MyTownBoardService myTownBoardService, SmallAddressService smallAddressService, MyTownBoardCommentService myTownBoardCommentService) {
    this.myTownBoardService = myTownBoardService;
    this.smallAddressService = smallAddressService;
    this.myTownBoardCommentService = myTownBoardCommentService;
  }

  @RequestMapping("/mytown/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));
    int stateNo= Integer.parseInt(request.getParameter("stateNo")); //일단 가져왔음 / Good job
    int cityNo = Integer.parseInt(request.getParameter("cityNo"));


    MyTownBoard myTownBoard = myTownBoardService.get(no);
    SmallAddress smallAddress = smallAddressService.get(cityNo);
    List<SmallAddress> smallAddresses = smallAddressService.list();

    List<MyTownBoardComment> comments = myTownBoardCommentService.list(no);
    String commentCount = myTownBoardCommentService.count(no);

    request.setAttribute("myTownBoard", myTownBoard);
    request.setAttribute("smallAddresses", smallAddresses);
    request.setAttribute("smallAddress", smallAddress);
    request.setAttribute("comments", comments);
    request.setAttribute("commentCount", commentCount);

    return "/jsp/mytown/detail.jsp";

  }
}







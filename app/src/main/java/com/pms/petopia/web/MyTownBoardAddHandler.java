package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.SmallAddressService;

@Controller
public class MyTownBoardAddHandler {

  SmallAddressService smallAddressService;
  MyTownBoardService myTownBoardService;

  public MyTownBoardAddHandler(SmallAddressService smallAddressService, MyTownBoardService myTownBoardService) {
    this.smallAddressService = smallAddressService;
    this.myTownBoardService = myTownBoardService;
  }

  @RequestMapping("/mytown/add")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    if(request.getMethod().equals("GET")) {

      int stateNo= Integer.parseInt(request.getParameter("stateNo")); //일단 가져왔음
      int cityNo = Integer.parseInt(request.getParameter("cityNo"));
      SmallAddress smallAddress = smallAddressService.get(cityNo);
      List<SmallAddress> smallAddresses = smallAddressService.list();

      request.setAttribute("smallAddress", smallAddress);
      request.setAttribute("smallAddresses", smallAddresses);

      return "/jsp/mytown/form.jsp";

    }

    MyTownBoard b = new MyTownBoard();

    int no = Integer.parseInt(request.getParameter("cityNo"));
    SmallAddress s = smallAddressService.get(no);
    b.setSmallAddress(s);
    b.setTitle(request.getParameter("title"));
    b.setContent(request.getParameter("content"));
    Member loginUser = (Member)request.getSession().getAttribute("loginUser");
    b.setWriter(loginUser);

    myTownBoardService.add(b);

    return "redirect:list?stateNo=" + s.getBigAddress().getNo() + "&cityNo=" + s.getNo();

  }
}





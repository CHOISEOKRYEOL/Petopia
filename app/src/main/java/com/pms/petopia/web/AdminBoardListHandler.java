package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.SharingMarketBoardService;

@Controller
public class AdminBoardListHandler {

  SharingMarketBoardService sharingMarketBoardService;
  MyTownBoardService myTownBoardService;

  public AdminBoardListHandler(SharingMarketBoardService sharingMarketBoardService, MyTownBoardService myTownBoardService) {
    this.sharingMarketBoardService = sharingMarketBoardService;
    this.myTownBoardService = myTownBoardService;
  }

  @RequestMapping("/admin/boardlist")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    if(loginUser.getRole() == 1) {
      return "/jsp/admin/access_fail.jsp";
      //        response.setHeader("Refresh", "1;url=../main");
    }
    else {
      List<SharingMarketBoard> sList = sharingMarketBoardService.list();
      List<MyTownBoard> mList = myTownBoardService.listAll();

      request.setAttribute("sList", sList);
      request.setAttribute("mList", mList);

      return "/jsp/admin/board_list.jsp";

    }
  }
}

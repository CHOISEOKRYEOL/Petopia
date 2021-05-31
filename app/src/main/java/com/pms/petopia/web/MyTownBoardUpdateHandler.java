package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.BigAddress;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.SmallAddressService;

@Controller
public class MyTownBoardUpdateHandler {

  MyTownBoardService myTownBoardService;
  SmallAddressService smallAddressService;

  public MyTownBoardUpdateHandler(MyTownBoardService myTownBoardService, SmallAddressService smallAddressService) {
    this.myTownBoardService = myTownBoardService;
    this.smallAddressService = smallAddressService;
  }

  @RequestMapping("/mytown/update")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    if(request.getMethod().equals("GET")) {
      int no = Integer.parseInt(request.getParameter("no"));

      List<SmallAddress> smallAddresses = smallAddressService.list();
      MyTownBoard oldBoard = myTownBoardService.get(no);
      if (oldBoard == null) {
        throw new Exception ("해당 번호의 게시글이 없습니다.");
      }
      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
        throw new Exception("변경 권한이 없습니다!");
      }

      request.setAttribute("oldBoard", oldBoard);
      request.setAttribute("smallAddresses", smallAddresses);
      return "/jsp/mytown/update.jsp";
    }

    int no = Integer.parseInt(request.getParameter("no"));


    MyTownBoard oldBoard = myTownBoardService.get(no);
    if (oldBoard == null) {
      throw new Exception ("해당 번호의 게시글이 없습니다.");
    }
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("변경 권한이 없습니다!");
    }

    MyTownBoard board = new MyTownBoard();
    board.setNo(oldBoard.getNo());
    board.setTitle(request.getParameter("title"));
    board.setContent(request.getParameter("content"));
    Integer.parseInt(request.getParameter("stateNo")); // 일단 받아와
    int cityNo = Integer.parseInt(request.getParameter("cityNo"));
    SmallAddress smallAddress = smallAddressService.get(cityNo);
    BigAddress bigAddress = smallAddress.getBigAddress();
    board.setBigAddress(bigAddress);
    board.setSmallAddress(smallAddress);
    myTownBoardService.update(board);

    String webAddress = String.format("detail?stateNo=%d&cityNo=%d&no=%d\n", 
        board.getBigAddress().getNo(), board.getSmallAddress().getNo(), board.getNo());

    return "/jsp/mytown/update.jsp";
    //    response.sendRedirect(webAddress);


  }
}







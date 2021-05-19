package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.BigAddress;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.SmallAddressService;

@SuppressWarnings("serial")
@WebServlet("/mytown/update")
public class MyTownBoardUpdateHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MyTownBoardService myTownBoardService = (MyTownBoardService) request.getServletContext().getAttribute("myTownBoardService");
    SmallAddressService smallAddressService = (SmallAddressService) request.getServletContext().getAttribute("smallAddressService");
    response.setContentType("text/html;charset=UTF-8");

    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>게시글 변경</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>게시글 변경</h1>");

    try {
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

      System.out.println(board.getBigAddress());
      System.out.println(board.getSmallAddress());

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>게시글 변경</h1>");
      out.println("<p>게시글을 변경하였습니다.</p>");
      String webAddress = String.format("detail?stateNo=%d&cityNo=%d&no=%d\n", 
          board.getBigAddress().getNo(), board.getSmallAddress().getNo(), board.getNo());
      response.sendRedirect(webAddress);

    } catch (Exception e) {
      throw new ServletException(e);
    }

    out.println("</body>");
    out.println("</html>");
  }
}







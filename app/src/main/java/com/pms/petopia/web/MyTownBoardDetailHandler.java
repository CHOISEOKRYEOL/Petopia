package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.MyTownBoardComment;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.MyTownBoardCommentService;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.SmallAddressService;

@SuppressWarnings("serial")
@WebServlet("/mytown/detail")
public class MyTownBoardDetailHandler extends HttpServlet {

  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MyTownBoardService myTownBoardService = (MyTownBoardService) request.getServletContext().getAttribute("myTownBoardService");
    SmallAddressService smallAddressService = (SmallAddressService) request.getServletContext().getAttribute("smallAddressService");
    MyTownBoardCommentService myTownBoardCommentService = (MyTownBoardCommentService) request.getServletContext().getAttribute("myTownBoardCommentService");
    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    int no = Integer.parseInt(request.getParameter("no"));
    int stateNo= Integer.parseInt(request.getParameter("stateNo")); //일단 가져왔음
    int cityNo = Integer.parseInt(request.getParameter("cityNo"));

    try {
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
      request.getRequestDispatcher("/jsp/mytown/detail.jsp").include(request, response);
    } catch (Exception e) {
      throw new ServletException(e);
    }

    out.println("</body>");
    out.println("</html>");
  }
}







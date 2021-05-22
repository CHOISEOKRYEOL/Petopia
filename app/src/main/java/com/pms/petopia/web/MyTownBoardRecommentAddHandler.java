package com.pms.petopia.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.Recomment;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.RecommentService;

@SuppressWarnings("serial")
@WebServlet("/mytown/recommentadd")
public class MyTownBoardRecommentAddHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RecommentService recommentService = (RecommentService)request.getServletContext().getAttribute("recommentService");
    MyTownBoardService myTownBoardService = (MyTownBoardService)request.getServletContext().getAttribute("myTownBoardService");

    response.setContentType("text/html;charset=UTF-8");
    request.setCharacterEncoding("UTF-8");

    Recomment recomment = new Recomment();
    try {
      int boardNo = Integer.parseInt(request.getParameter("no"));
      MyTownBoard myTownBoard = myTownBoardService.get(boardNo);
      recomment.setMyTownBoard(myTownBoard);
      Member loginUser = (Member)request.getSession().getAttribute("loginUser");
      recomment.setRecommender(loginUser);
      int count = 0;
      String result = "fail";
      List<Recomment> recomments = recommentService.list();
      if (recomments.size() == 0) {
        recommentService.add(recomment);
        myTownBoardService.updateRecommentCount(boardNo);
        result = "success";

      } else{

        for(Recomment reco : recomments) {
          if (reco.getRecommender().getNo() != loginUser.getNo() && reco.getMyTownBoard().getNo() != boardNo
              || reco.getRecommender().getNo() == loginUser.getNo() && reco.getMyTownBoard().getNo() != boardNo
              || reco.getRecommender().getNo() != loginUser.getNo() && reco.getMyTownBoard().getNo() == boardNo) {

            System.out.println(reco.getRecommender().getNo());
            System.out.println(loginUser.getNo());
            System.out.println(reco.getMyTownBoard().getNo());
            System.out.println(boardNo);
            //System.out.println("-----> 추천할 수 있어!");
            count++;
            if (count == recomments.size()) {
              //System.out.println("**********************");
              System.out.println(reco.getRecommender().getNo());
              System.out.println(loginUser.getNo());
              System.out.println(reco.getMyTownBoard().getNo());
              System.out.println(boardNo);
              recommentService.add(recomment);
              myTownBoardService.updateRecommentCount(boardNo);
              result = "success";
              break;
            }

          }else {
            System.out.println(reco.getRecommender().getNo());
            System.out.println(loginUser.getNo());
            System.out.println(reco.getMyTownBoard().getNo());
            System.out.println(boardNo);
            System.out.println("==> 2. 추천은 안돼!");
            break;
          }
        }
      }
      request.setAttribute("result", result);

      request.getRequestDispatcher("/jsp/mytown/recommentadd.jsp").include(request, response);

      String webAddress= String.format("2;url=../mytown/detail?stateNo=%d&cityNo=%d&no=%d\n", 
          myTownBoard.getBigAddress().getNo(), myTownBoard.getSmallAddress().getNo(), boardNo);
      response.setHeader("Refresh",webAddress);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}


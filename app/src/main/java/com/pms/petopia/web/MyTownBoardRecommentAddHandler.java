package com.pms.petopia.web;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.Recomment;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.RecommentService;


@Controller
public class MyTownBoardRecommentAddHandler {

  MyTownBoardService myTownBoardService;
  RecommentService recommentService;

  public MyTownBoardRecommentAddHandler(MyTownBoardService myTownBoardService, RecommentService recommentService) {
    this.myTownBoardService = myTownBoardService;
    this.recommentService = recommentService;
  }

  @RequestMapping("/mytown/recommentadd")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    PrintWriter out = response.getWriter();

    Recomment recomment = new Recomment();
    int boardNo = Integer.parseInt(request.getParameter("no"));
    MyTownBoard myTownBoard = myTownBoardService.get(boardNo);
    recomment.setMyTownBoard(myTownBoard);

    Member loginUser = (Member)request.getSession().getAttribute("loginUser");
    recomment.setRecommender(loginUser);

    int count = 0;
    List<Recomment> recomments = recommentService.list();

    if (recomments.size() == 0) {
      recommentService.add(recomment);
      myTownBoardService.updateRecommentCount(boardNo);
      out.print("success");

    } else {

      for(Recomment reco : recomments) {
        if (reco.getRecommender().getNo() != loginUser.getNo() && reco.getMyTownBoard().getNo() != boardNo
            || reco.getRecommender().getNo() == loginUser.getNo() && reco.getMyTownBoard().getNo() != boardNo
            || reco.getRecommender().getNo() != loginUser.getNo() && reco.getMyTownBoard().getNo() == boardNo) {

          count++;
          if (count == recomments.size()) {
            recommentService.add(recomment);
            myTownBoardService.updateRecommentCount(boardNo);
            out.print("success");
            break;
          }

        }else {
          out.print("fail");
        }
      }
    }
    return "";
  }
}


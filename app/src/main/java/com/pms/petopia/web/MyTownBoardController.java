package com.pms.petopia.web;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.BigAddress;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.MyTownBoardComment;
import com.pms.petopia.domain.Recomment;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.MyTownBoardCommentService;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.RecommentService;
import com.pms.petopia.service.SmallAddressService;

@Controller
@RequestMapping("/mytown")
public class MyTownBoardController {

  SmallAddressService smallAddressService;
  MyTownBoardService myTownBoardService;
  MyTownBoardCommentService myTownBoardCommentService;
  RecommentService recommentService;

  public MyTownBoardController(SmallAddressService smallAddressService, 
      MyTownBoardService myTownBoardService, 
      MyTownBoardCommentService myTownBoardCommentService, 
      RecommentService recommentService) {
    this.smallAddressService = smallAddressService;
    this.myTownBoardService = myTownBoardService;
    this.myTownBoardCommentService = myTownBoardCommentService;
    this.recommentService = recommentService;
  }

  @RequestMapping("form")
  public String add(HttpServletRequest request, HttpServletResponse response)
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

  @RequestMapping("detail")
  public String detail(HttpServletRequest request, HttpServletResponse response)
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

  @RequestMapping("delete")
  public String delete(HttpServletRequest request, HttpServletResponse response)
      throws Exception {


    int no = Integer.parseInt(request.getParameter("no"));

    MyTownBoard oldBoard = myTownBoardService.get(no);
    if (oldBoard == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("삭제 권한이 없습니다!");
    }

    if (myTownBoardCommentService.count(no).equals("0")) {
      myTownBoardService.delete(no);
    } else {
      myTownBoardService.deleteAll(no); // 댓글까지 지우기 
    }

    String webAddress = String.format("list?stateNo=%d&cityNo=%d", 
        oldBoard.getBigAddress().getNo(), oldBoard.getSmallAddress().getNo());

    return "/jsp/mytown/delete.jsp";

    //      response.setHeader("Refresh", "3;url=" + webAddress);

  }

  @RequestMapping("updateComment")
  public String updateComment(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));


    MyTownBoardComment oldBoardComment = myTownBoardCommentService.get(no);
    if (oldBoardComment == null) {
      throw new Exception ("해당 번호의 댓글이 없습니다.");
    }
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (oldBoardComment.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("변경 권한이 없습니다!");
    }

    MyTownBoardComment comment = new MyTownBoardComment();
    comment.setNo(oldBoardComment.getNo());
    comment.setContent(request.getParameter("content"));

    myTownBoardCommentService.update(comment);
    MyTownBoard board = myTownBoardService.get(oldBoardComment.getMyTownBoard().getNo());

    String webAddress = String.format("../mytown/detail?stateNo=%d&cityNo=%d&no=%d", 
        board.getBigAddress().getNo(), board.getSmallAddress().getNo(), board.getNo());

    return "redirect:webAddress";
    //      response.sendRedirect(webAddress);


  }

  @RequestMapping("listComment")
  public String listComment(HttpServletRequest request, HttpServletResponse response)
      throws Exception {


    MyTownBoardComment c = new MyTownBoardComment();
    int boardNo = Integer.parseInt(request.getParameter("boardNo"));
    MyTownBoard t = myTownBoardService.get(boardNo);
    c.setMyTownBoard(t);
    Member loginUser = (Member)request.getSession().getAttribute("loginUser");
    c.setWriter(loginUser);
    c.setContent(request.getParameter("content"));

    myTownBoardCommentService.add(c);
    String webAdress= String.format("../mytown/detail?stateNo=%d&cityNo=%d&no=%d\n", 
        t.getBigAddress().getNo(), t.getSmallAddress().getNo(), boardNo);

    return "redirect:webAdress";
    //    response.sendRedirect(webAdress);

  }

  @RequestMapping("deleteComment")
  public String deleteComment(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    MyTownBoardComment oldBoardComment = myTownBoardCommentService.get(no);
    if (oldBoardComment == null) {
      throw new Exception("해당 번호의 댓글이 없습니다.");
    }

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (oldBoardComment.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("삭제 권한이 없습니다!");
    }

    myTownBoardCommentService.delete(no);
    int oldBoardNo = oldBoardComment.getMyTownBoard().getNo();
    MyTownBoard oldBoard = myTownBoardService.get(oldBoardNo);

    String webAdress= String.format("../mytown/detail?stateNo=%d&cityNo=%d&no=%d", 
        oldBoard.getBigAddress().getNo(), oldBoard.getSmallAddress().getNo(), oldBoard.getNo());

    return "redirect:"+ webAdress;
    //    response.sendRedirect(webAdress);

  }

  @RequestMapping("addComment")
  public String addComment(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    MyTownBoardComment c = new MyTownBoardComment();
    int boardNo = Integer.parseInt(request.getParameter("boardNo"));
    MyTownBoard t = myTownBoardService.get(boardNo);
    c.setMyTownBoard(t);
    Member loginUser = (Member)request.getSession().getAttribute("loginUser");
    c.setWriter(loginUser);
    c.setContent(request.getParameter("content"));

    myTownBoardCommentService.add(c);
    String webAddress= String.format("../mytown/detail?stateNo=%d&cityNo=%d&no=%d\n", 
        t.getBigAddress().getNo(), t.getSmallAddress().getNo(), boardNo);

    return "redirect:" + webAddress;
    //      response.sendRedirect(webAdress);

  }


  @RequestMapping("list")
  public String list(HttpServletRequest request, HttpServletResponse response)
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

  @RequestMapping("main")
  public String main(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<SmallAddress> smallAddresses = smallAddressService.list();

    request.setAttribute("smallAddresses", smallAddresses);

    return "/jsp/mytown/main.jsp";

  }

  @RequestMapping("recommentAdd")
  public String recommentAdd(HttpServletRequest request, HttpServletResponse response)
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
            System.out.println("success");
            out.print("success");
            break;
          }

        }else {
          System.out.println("fail");
          out.print("fail");
        }
      }
    }
    return "";
  }


  @RequestMapping("update")
  public String update(HttpServletRequest request, HttpServletResponse response)
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

  @RequestMapping("/mypage/mytownlist")
  public String myPage(HttpServletRequest request, HttpServletResponse response)
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





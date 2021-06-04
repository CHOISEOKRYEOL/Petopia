package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.BigAddress;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.MyTownBoardComment;
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

  @GetMapping("form")
  public void form(int stateNo, int cityNo, Model model) throws Exception {

    SmallAddress smallAddress = smallAddressService.get(cityNo);
    System.out.println(smallAddress);
    List<SmallAddress> smallAddresses = smallAddressService.list();

    model.addAttribute("smallAddress", smallAddress);
    model.addAttribute("smallAddresses", smallAddresses);
  }

  @PostMapping("add")
  public String add(int cityNo, MyTownBoard b, HttpSession session)
      throws Exception {

    SmallAddress s = smallAddressService.get(cityNo);
    b.setSmallAddress(s);
    Member loginUser = (Member)session.getAttribute("loginUser");
    b.setWriter(loginUser);

    myTownBoardService.add(b);
    return "redirect:list?stateNo=" + s.getBigAddress().getNo() + "&cityNo=" + s.getNo();
  }

  @GetMapping("detail")
  public void detail(int no, int stateNo, int cityNo, Model model)
      throws Exception {

    MyTownBoard myTownBoard = myTownBoardService.get(no);
    SmallAddress smallAddress = smallAddressService.get(cityNo);
    List<SmallAddress> smallAddresses = smallAddressService.list();

    List<MyTownBoardComment> comments = myTownBoardCommentService.list(no);
    String commentCount = myTownBoardCommentService.count(no);

    model.addAttribute("myTownBoard", myTownBoard);
    model.addAttribute("smallAddresses", smallAddresses);
    model.addAttribute("smallAddress", smallAddress);
    model.addAttribute("comments", comments);
    model.addAttribute("commentCount", commentCount);
  }

  @GetMapping("deleteByAdmin")
  public String deleteByAdmin(int no) throws Exception {

    myTownBoardService.delete(no);

    return "redirect:../admin/mytown_board_list";
  }

  @GetMapping("delete")
  public String delete(int no, HttpSession session)
      throws Exception {

    MyTownBoard oldBoard = myTownBoardService.get(no);
    if (oldBoard == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    Member loginUser = (Member) session.getAttribute("loginUser");
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

    return "redirect:" + webAddress;

    //      response.setHeader("Refresh", "3;url=" + webAddress);

  }

  @PostMapping("updateComment")
  public String updateComment(MyTownBoardComment comment, HttpSession session)
      throws Exception {

    MyTownBoardComment oldBoardComment = myTownBoardCommentService.get(comment.getNo());
    if (oldBoardComment == null) {
      throw new Exception ("해당 번호의 댓글이 없습니다.");
    }
    Member loginUser = (Member) session.getAttribute("loginUser");
    if (oldBoardComment.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("변경 권한이 없습니다!");
    }
    //MyTownBoardComment comment = new MyTownBoardComment();
    //comment.setNo(oldBoardComment.getNo());

    myTownBoardCommentService.update(comment);
    MyTownBoard board = myTownBoardService.get(oldBoardComment.getMyTownBoard().getNo());

    String webAddress = String.format("../mytown/detail?stateNo=%d&cityNo=%d&no=%d", 
        board.getBigAddress().getNo(), board.getSmallAddress().getNo(), board.getNo());

    return "redirect:" + webAddress;


  }

  @GetMapping("deleteComment")
  public String deleteComment(int no, HttpSession session) throws Exception {

    MyTownBoardComment oldBoardComment = myTownBoardCommentService.get(no);
    if (oldBoardComment == null) {
      throw new Exception("해당 번호의 댓글이 없습니다.");
    }

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (oldBoardComment.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("삭제 권한이 없습니다!");
    }
    System.out.println("delete");
    myTownBoardCommentService.delete(no);

    int oldBoardNo = oldBoardComment.getMyTownBoard().getNo();
    MyTownBoard oldBoard = myTownBoardService.get(oldBoardNo);

    String webAdress= String.format("../mytown/detail?stateNo=%d&cityNo=%d&no=%d", 
        oldBoard.getBigAddress().getNo(), oldBoard.getSmallAddress().getNo(), oldBoard.getNo());

    return "redirect:"+ webAdress;
    //    response.sendRedirect(webAdress);

  }

  @RequestMapping("addComment")
  public String addComment(MyTownBoardComment c, int boardNo, HttpSession session)
      throws Exception {

    MyTownBoard t = myTownBoardService.get(boardNo);
    c.setMyTownBoard(t);
    Member loginUser = (Member)session.getAttribute("loginUser");
    c.setWriter(loginUser);

    myTownBoardCommentService.add(c);
    String webAddress= String.format("../mytown/detail?stateNo=%d&cityNo=%d&no=%d\n", 
        t.getBigAddress().getNo(), t.getSmallAddress().getNo(), boardNo);

    return "redirect:" + webAddress;
    //      response.sendRedirect(webAdress);

  }


  @GetMapping("list")
  public void list(int stateNo, int cityNo, String keyword, String r, Model model)
      throws Exception {

    List<MyTownBoard> boards = myTownBoardService.list(stateNo, cityNo);
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
    model.addAttribute("boards", boards);
    model.addAttribute("smallAddresses", smallAddresses);
    model.addAttribute("smallAddress", smallAddress);
    model.addAttribute("keyword", keyword);
    model.addAttribute("r", r);
    model.addAttribute("stateNo", stateNo);
    model.addAttribute("cityNo", cityNo);
  }

  @RequestMapping("/main")
  public void main(Model model) throws Exception {

    List<SmallAddress> smallAddresses = smallAddressService.list();

    model.addAttribute("smallAddresses", smallAddresses);
  }

  //  @GetMapping("recommentAdd")
  //  public String recommentAdd(Recomment recomment, int no, HttpSession session, Model model)
  //      throws Exception {
  //
  //    MyTownBoard t = myTownBoardService.get(no);
  //    recomment.setMyTownBoard(t);
  //
  //    Member loginUser = (Member)session.getAttribute("loginUser");
  //    recomment.setRecommender(loginUser);
  //
  //    int count = 0;
  //    List<Recomment> recomments = recommentService.list();
  //
  //    if (recomments.size() == 0) {
  //      recommentService.add(recomment);
  //      myTownBoardService.updateRecommentCount(no);
  //      model.addAttribute("result", "success");
  //
  //    } else {
  //
  //      for(Recomment reco : recomments) {
  //        if (reco.getRecommender().getNo() != loginUser.getNo() && reco.getMyTownBoard().getNo() != no
  //            || reco.getRecommender().getNo() == loginUser.getNo() && reco.getMyTownBoard().getNo() != no
  //            || reco.getRecommender().getNo() != loginUser.getNo() && reco.getMyTownBoard().getNo() == no) {
  //
  //          count++;
  //          if (count == recomments.size()) {
  //            recommentService.add(recomment);
  //            myTownBoardService.updateRecommentCount(no);
  //            System.out.println("success");
  //            model.addAttribute("result", "success");
  //            break;
  //          }
  //
  //        }else {
  //          System.out.println("fail");
  //          model.addAttribute("result", "fail");
  //        }
  //      }
  //    }
  //    String webAddress= String.format("../mytown/detail?stateNo=%d&cityNo=%d&no=%d\n", 
  //        t.getBigAddress().getNo(), t.getSmallAddress().getNo(), no);
  //
  //    return "redirect:" + webAddress;
  //  }



  @GetMapping("update")
  public void update(int no, HttpSession session, Model model) throws Exception {

    List<SmallAddress> smallAddresses = smallAddressService.list();
    MyTownBoard oldBoard = myTownBoardService.get(no);
    if (oldBoard == null) {
      throw new Exception ("해당 번호의 게시글이 없습니다.");
    }
    Member loginUser = (Member) session.getAttribute("loginUser");
    if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("변경 권한이 없습니다!");
    }

    BigAddress bigAddress = oldBoard.getBigAddress();
    SmallAddress smallAddress = oldBoard.getSmallAddress();

    model.addAttribute("smallAddress", smallAddress);
    model.addAttribute("bigAddress", bigAddress);
    model.addAttribute("oldBoard", oldBoard);
    model.addAttribute("smallAddresses", smallAddresses);
  }



  @PostMapping("update")
  public String update(int no, int cityNo, MyTownBoard board, HttpSession session)
      throws Exception {

    MyTownBoard oldBoard = myTownBoardService.get(board.getNo());
    if (oldBoard == null) {
      throw new Exception ("해당 번호의 게시글이 없습니다.");
    }
    Member loginUser = (Member) session.getAttribute("loginUser");
    if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("변경 권한이 없습니다!");
    }

    SmallAddress smallAddress = smallAddressService.get(cityNo);
    BigAddress bigAddress = smallAddress.getBigAddress();
    board.setBigAddress(bigAddress);
    board.setSmallAddress(smallAddress);
    myTownBoardService.update(board);

    String webAddress = String.format("detail?stateNo=%d&cityNo=%d&no=%d\n", 
        board.getBigAddress().getNo(), board.getSmallAddress().getNo(), board.getNo());

    return "redirect:" + webAddress;
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

  @GetMapping("city")
  public void city() throws Exception {
  }




}





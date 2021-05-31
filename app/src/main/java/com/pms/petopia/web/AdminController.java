package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.domain.Qna;
import com.pms.petopia.domain.Review;
import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.MemberService;
import com.pms.petopia.service.MyTownBoardService;
import com.pms.petopia.service.QnaService;
import com.pms.petopia.service.ReviewService;
import com.pms.petopia.service.SharingMarketBoardService;
import com.pms.petopia.service.SmallAddressService;

@Controller
@RequestMapping("/admin")
public class AdminController {

  SharingMarketBoardService sharingMarketBoardService;
  MyTownBoardService myTownBoardService;
  HospitalService hospitalService;
  SmallAddressService smallAddressService;
  MemberService memberService;
  QnaService qnaService;
  ReviewService reviewService;

  public AdminController(SharingMarketBoardService sharingMarketBoardService, 
      MyTownBoardService myTownBoardService, 
      HospitalService hospitalService, 
      SmallAddressService smallAddressService, 
      MemberService memberService, 
      QnaService qnaService, 
      ReviewService reviewService) {
    this.sharingMarketBoardService = sharingMarketBoardService;
    this.myTownBoardService = myTownBoardService;
    this.hospitalService = hospitalService;
    this.smallAddressService = smallAddressService;
    this.memberService = memberService;
    this.qnaService = qnaService;
    this.reviewService = reviewService;
  }

  @RequestMapping("boardlist")
  public String boardList(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    if(loginUser.getRole() == 1) {
      return "/jsp/admin/access_fail.jsp";
    }
    else {
      List<SharingMarketBoard> sList = sharingMarketBoardService.list();
      List<MyTownBoard> mList = myTownBoardService.listAll();

      request.setAttribute("sList", sList);
      request.setAttribute("mList", mList);

      return "/jsp/admin/board_list.jsp";

    }
  }



  @RequestMapping("hospitallist")
  public String hosList(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<Hospital> hospitals = hospitalService.list();
    List<SmallAddress> area = smallAddressService.list();

    request.setAttribute("list", hospitals);
    request.setAttribute("area", area);

    return "/jsp/admin/hospital_list.jsp";

  }

  @RequestMapping("memberlist")
  public String memberList(HttpServletRequest request, HttpServletResponse response)
      throws Exception {


    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if(loginUser.getRole() == 1) {

      return "/jsp/admin/access_fail.jsp";

    }
    else {
      List<Member> list = null;

      String item = request.getParameter("item");
      String keyword = request.getParameter("keyword");

      if (item != null && keyword != null && keyword.length() > 0) {
        list = memberService.search(item, keyword);
      }
      else {
        list = memberService.list();
      }

      request.setAttribute("list", list);
      return "/jsp/admin/member_list.jsp";

    }
  }

  @RequestMapping("answer")
  public String answerQna(HttpServletRequest request, HttpServletResponse response) throws Exception {

    Qna qna = new Qna();
    qna.setNo(Integer.parseInt(request.getParameter("no")));
    qna.setAnswer(request.getParameter("answer"));
    qna.setState(1);
    qnaService.answer(qna);

    return "redirect:qnalist";
  }


  @RequestMapping("qnadetail")
  public String qnaDetail(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Qna q = qnaService.get(no);
    request.setAttribute("qna", q);

    return "/jsp/admin/qna_detail.jsp";

  }

  @RequestMapping("qnalist")
  public String qnaList(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if(loginUser.getRole() == 1) {
      return "/jsp/admin/access_fail.jsp";
      //      response.setHeader("Refresh", "1;url=../main");
    }
    else {
      List<Qna> list = qnaService.list();

      request.setAttribute("list", list);

      return "/jsp/admin/qna_list.jsp";
    }
  }

  @RequestMapping("reviewlist")
  public String reviewList(HttpServletRequest request, HttpServletResponse response)
      throws Exception {


    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if(loginUser.getRole() == 1) {

      return "/jsp/admin/access_fail.jsp";
    }
    else {
      List<Review> list = null;

      String item = request.getParameter("item");
      String keyword = request.getParameter("keyword");

      if(item != null && keyword != null && keyword.length() > 0) {
        list = reviewService.search(item, keyword);
      }
      else {
        list = reviewService.listAll();
      }

      request.setAttribute("list", list);

      return "/jsp/admin/review_list.jsp";
    }
  }
}

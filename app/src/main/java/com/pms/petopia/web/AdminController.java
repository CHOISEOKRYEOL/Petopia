package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  @GetMapping("sharing_board_list")
  public String sharingBoardList(HttpSession session, Model model)
      throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");

    if(loginUser.getRole() == 1) {
      return "access_fail";
    }
    else {
      List<SharingMarketBoard> sList = sharingMarketBoardService.list();

      model.addAttribute("sList", sList);

      return "admin/sharing_board_list";

    }
  }

  @GetMapping("mytown_board_list")
  public String myTownBoardList(HttpSession session, Model model)
      throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");

    if(loginUser.getRole() == 1) {
      return "access_fail";
    }
    else {
      List<MyTownBoard> mList = myTownBoardService.listAll();

      model.addAttribute("mList", mList);

      return "admin/mytown_board_list";

    }
  }


  @GetMapping("hospital_list")
  public void hosList(Model model)
      throws Exception {

    List<Hospital> hospitals = hospitalService.list();
    List<SmallAddress> area = smallAddressService.list();

    model.addAttribute("list", hospitals);
    model.addAttribute("area", area);

  }

  @GetMapping("member_list")
  public String memberList(String item, String keyword, HttpSession session, Model model)
      throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");
    if(loginUser.getRole() == 1) {

      return "admin/access_fail";

    }
    else {
      List<Member> list = null;

      if (item != null && keyword != null && keyword.length() > 0) {
        list = memberService.search(item, keyword);
      }
      else {
        list = memberService.list();
      }


      model.addAttribute("list", list);
      return "admin/member_list";

    }
  }

  @PostMapping("answer")
  public String answerQna(Qna qna) throws Exception {

    qna.setState(1);
    qnaService.answer(qna);

    return "redirect:qnalist";
  }


  @GetMapping("qna_detail")
  public void qnaDetail(int no, Model model)
      throws Exception {

    Qna q = qnaService.get(no);
    model.addAttribute("qna", q);

  }

  @GetMapping("qnalist")
  public String qnaList(HttpSession session, Model model)
      throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");
    if(loginUser.getRole() == 1) {
      return "admin/access_fail";
    }
    else {
      List<Qna> list = qnaService.list();

      model.addAttribute("list", list);

      return "admin/qna_list";
    }
  }

  @GetMapping("review_list")
  public String reviewList(String item, String keyword, HttpSession session, Model model)
      throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");
    if(loginUser.getRole() == 1) {

      return "admin/access_fail";
    }
    else {
      List<Review> list = null;

      if(item != null && keyword != null && keyword.length() > 0) {
        list = reviewService.search(item, keyword);
      }
      else {
        list = reviewService.listAll();
      }

      model.addAttribute("list", list);

      return "admin/review_list";
    }
  }

  @RequestMapping("main")
  public String reviewList(HttpSession session)throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");
    if(loginUser.getRole() == 1) {
      return "admin/access_fail";
    }
    return "admin/main";
  }
}

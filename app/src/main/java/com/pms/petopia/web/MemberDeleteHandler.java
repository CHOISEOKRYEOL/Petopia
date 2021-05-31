package com.pms.petopia.web;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.BookmarkService;
import com.pms.petopia.service.MemberService;
import com.pms.petopia.service.QnaService;
import com.pms.petopia.service.ReviewService;

@Controller
public class MemberDeleteHandler {

  MemberService memberService;
  BookmarkService bookmarkService;
  ReviewService reviewService;
  QnaService qnaService;

  public MemberDeleteHandler(MemberService memberService, BookmarkService bookmarkService, ReviewService reviewService, QnaService qnaService) {
    this.memberService = memberService;
    this.bookmarkService = bookmarkService;
    this.reviewService = reviewService;
    this.qnaService = qnaService;
  }

  @RequestMapping("/member/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    Member m = new Member();
    if(loginUser.getRole() == 0) {
      m.setNo(Integer.parseInt(request.getParameter("no")));
    }
    else {
      m.setNo(loginUser.getNo());
    }
    m.setEmail(UUID.randomUUID().toString());
    m.setName(UUID.randomUUID().toString());
    m.setPassword(UUID.randomUUID().toString());
    m.setTel(UUID.randomUUID().toString());
    m.setNick(UUID.randomUUID().toString());
    m.setState(1);

    if(loginUser.getRole() == 0) {
      reviewService.deleteAll(m.getNo());
      bookmarkService.deleteAll(m.getNo());
      qnaService.deleteAll(m.getNo());
    }
    else {
      reviewService.deleteAll(loginUser.getNo());
      bookmarkService.deleteAll(loginUser.getNo());
      qnaService.deleteAll(loginUser.getNo());
    }

    memberService.delete(m);

    if(loginUser.getRole() == 0) {
      return "redirect:../admin/memberlist";
    }
    else {
      request.getSession().invalidate();
      return "/jsp/member/delete.jsp";
    }

  }
}







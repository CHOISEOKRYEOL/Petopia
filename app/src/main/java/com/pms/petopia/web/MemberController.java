package com.pms.petopia.web;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.BookmarkService;
import com.pms.petopia.service.MemberService;
import com.pms.petopia.service.QnaService;
import com.pms.petopia.service.ReviewService;

@Controller
@RequestMapping("/member")
public class MemberController {

  MemberService memberService;
  BookmarkService bookmarkService;
  ReviewService reviewService;
  QnaService qnaService;

  public MemberController(MemberService memberService, 
      BookmarkService bookmarkService, 
      ReviewService reviewService, 
      QnaService qnaService) {
    this.memberService = memberService;
    this.bookmarkService = bookmarkService;
    this.reviewService = reviewService;
    this.qnaService = qnaService;
  }

  @GetMapping("member_form")
  public void form()
      throws Exception {}

  @PostMapping("add")
  public String add(Member m, Model model) throws Exception {

    memberService.add(m);
    model.addAttribute("member", m);

    return "member/add_success";
  }

  @RequestMapping("delete")
  public String delete(HttpServletRequest request, HttpSession session)
      throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");

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
      return "member/delete";
    }

  }

  @RequestMapping("detail")
  public String detail(HttpSession session, Model model)
      throws ServletException, IOException {

    Member loginUser = (Member) session.getAttribute("loginUser");

    model.addAttribute("member", loginUser);

    return "member/detail";

  }

  @GetMapping("findKey_form")
  public void findKeyForm() throws Exception {

  }

  @PostMapping("findkey")
  public String findKey(String name, String nick, Model model)
      throws Exception {

    Member m = memberService.getIdEmail(name, nick);

    model.addAttribute("member", m);

    return "member/find_id_email";

  }

  @PostMapping("update")
  public String update(HttpServletRequest request, HttpSession session, Model model)
      throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");

    Member m = new Member();
    m.setNo(loginUser.getNo());
    m.setId(loginUser.getId());
    m.setNick(request.getParameter("nick"));
    m.setPassword(request.getParameter("password"));
    m.setTel(request.getParameter("tel"));

    memberService.update(m);
    model.addAttribute("member", m);

    return "member/update";

  }


  private String randomKey() {

    int min = 97;
    int max = 122;
    int length = 10;
    Random random = new Random();
    String randomString = random.ints(min, max + 1)
        .limit(length)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();

    return randomString;
  }

}







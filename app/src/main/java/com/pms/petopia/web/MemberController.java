package com.pms.petopia.web;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;
import javax.servlet.ServletException;
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

  @RequestMapping("add")
  public String form(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    if(request.getMethod().equals("GET")) {
      return "/jsp/member/member_form.jsp";
    }
    else {
      Member m = new Member();
      m.setName(request.getParameter("name"));
      m.setId(request.getParameter("id"));
      m.setNick(request.getParameter("nick"));
      m.setEmail(request.getParameter("email"));
      m.setPassword(request.getParameter("password"));
      m.setTel(request.getParameter("tel"));

      memberService.add(m);
      request.setAttribute("member", m);

      return "/jsp/member/add_success.jsp";
    }
  }

  @RequestMapping("delete")
  public String delete(HttpServletRequest request, HttpServletResponse response)
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

  @RequestMapping("detail")
  public String detail(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    request.setAttribute("member", loginUser);

    return "/jsp/member/detail.jsp";

  }

  @RequestMapping("findKey")
  public String findKey(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    if(request.getMethod().equals("GET")) {
      return "/jsp/member/findKey_form.jsp";
    }

    String name = request.getParameter("name");
    String nick = request.getParameter("nick");


    Member m = memberService.getIdEmail(name, nick);

    request.setAttribute("member", m);

    return "/jsp/member/find_id_email.jsp";

  }

  @RequestMapping("update")
  public String update(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    Member m = new Member();
    m.setNo(loginUser.getNo());
    m.setId(loginUser.getId());
    m.setNick(request.getParameter("nick"));
    m.setPassword(request.getParameter("password"));
    m.setTel(request.getParameter("tel"));

    memberService.update(m);
    request.setAttribute("member", m);

    return "/jsp/member/update.jsp";

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







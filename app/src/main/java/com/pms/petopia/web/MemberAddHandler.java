package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

@Controller
public class MemberAddHandler {

  MemberService memberService;

  public MemberAddHandler(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/add")
  public String execute(HttpServletRequest request, HttpServletResponse response)
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
}







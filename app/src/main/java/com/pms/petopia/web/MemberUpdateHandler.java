package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

@Controller
public class MemberUpdateHandler {

  MemberService memberService;

  public MemberUpdateHandler(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/update")
  public String execute(HttpServletRequest request, HttpServletResponse response)
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
    //      response.setHeader("Refresh", "1;url=../main");

  }
}







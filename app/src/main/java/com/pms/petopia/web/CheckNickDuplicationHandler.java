package com.pms.petopia.web;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

public class CheckNickDuplicationHandler {

  MemberService memberService;

  public CheckNickDuplicationHandler(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/checknick")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String nick = request.getParameter("nick");


    Member m = memberService.getNick(nick);

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    if(m != null) {
      out.print("1");
    }
    else {
      out.print("0");
    }

    return "";

  }
}

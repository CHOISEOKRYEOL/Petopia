package com.pms.petopia.web;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

@Controller
public class CheckEmailDuplicationHandler {

  MemberService memberService;

  public CheckEmailDuplicationHandler(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/checkemail")
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String email = request.getParameter("email");

    Member m = memberService.getEmail(email);

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    if(m != null) {
      out.print("1");
    }
    else {
      out.print("0");
    }

  }
}

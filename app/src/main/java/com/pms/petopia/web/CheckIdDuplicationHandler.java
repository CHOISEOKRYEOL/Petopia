package com.pms.petopia.web;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;


@Controller
public class CheckIdDuplicationHandler {

  MemberService memberService;

  public CheckIdDuplicationHandler(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/checkid")
  public void execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String id = request.getParameter("id");

    Member m = memberService.getId(id);

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

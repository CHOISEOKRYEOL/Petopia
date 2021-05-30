package com.pms.petopia.web;

import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.service.MemberService;

@Controller
public class CheckNumberHandler {

  MemberService memberService;

  public CheckNumberHandler(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/checknumber")
  public void execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

    Random r  = new Random();
    String authenticationNumber = "";
    for(int i = 0; i < 6; i++) {
      String randomNumber = Integer.toString(r.nextInt(10));
      authenticationNumber += randomNumber;
    }

    String phoneNumber = request.getParameter("tel");

    System.out.println("수신자 번호 : " + phoneNumber);
    System.out.println("인증번호 : " + authenticationNumber);


    memberService.certifyNumber(phoneNumber, authenticationNumber);

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.write(authenticationNumber);

  }
}

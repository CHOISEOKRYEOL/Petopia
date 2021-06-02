package com.pms.petopia.web;

import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;


@Controller
@RequestMapping("/member")
public class ValidatorController {

  MemberService memberService;

  public ValidatorController(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("checkid")
  public void checkId(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String id = request.getParameter("id");

    Member m = memberService.getId(id);

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    if(m != null) {
      out.write("1");
    }
    else {
      out.write("0");
    }
  }

  @RequestMapping("checkemail")
  public void checkMail(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String email = request.getParameter("email");

    Member m = memberService.getEmail(email);

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    if(m != null) {
      out.write("1");
    }
    else {
      out.write("0");
    }
  }

  @RequestMapping("checknick")
  public void checkNick(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String nick = request.getParameter("nick");

    Member m = memberService.getNick(nick);

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    if(m != null) {
      out.write("1");
    }
    else {
      out.write("0");
    }
  }

  @RequestMapping("checktel")
  public void checkTel(HttpServletRequest request, HttpServletResponse response) throws Exception {

    String id = request.getParameter("id");
    String tel = request.getParameter("tel");

    Member m = memberService.getIdTel(id, tel);

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    if(m != null) {
      out.write("1");
    }
    else {
      out.write("0");
    }
  }

  @RequestMapping("checknumber")
  public void checkNumber(HttpServletRequest request, HttpServletResponse response) throws Exception {

    Random r  = new Random();
    String authenticationNumber = "";
    for(int i = 0; i < 6; i++) {
      String randomNumber = Integer.toString(r.nextInt(10));
      authenticationNumber += randomNumber;
    }

    String phoneNumber = request.getParameter("tel");

    memberService.certifyNumberForRegister(phoneNumber, authenticationNumber);

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.write(authenticationNumber);
  }

  @RequestMapping("checknumber2")
  public void checkNumber2(HttpServletRequest request, HttpServletResponse response) throws Exception {

    Random r  = new Random();
    String authenticationNumber = "";
    for(int i = 0; i < 6; i++) {
      String randomNumber = Integer.toString(r.nextInt(10));
      authenticationNumber += randomNumber;
    }

    String phoneNumber = request.getParameter("tel");

    memberService.certifyNumberForPassword(phoneNumber, authenticationNumber);

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.write(authenticationNumber);
  }

  @RequestMapping("checkpassword")
  public void checkPassword(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int min = 97;
    int max = 122;
    int length = 10;
    Random random = new Random();
    String newPassword = random.ints(min, max + 1)
        .limit(length)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();

    String phoneNumber = request.getParameter("tel");
    String id = request.getParameter("id");

    memberService.setNewPassword(id, phoneNumber, newPassword);

  }

}

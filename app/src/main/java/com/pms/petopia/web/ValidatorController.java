package com.pms.petopia.web;

import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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

  @GetMapping("checkid")
  public void checkId(String id, HttpServletResponse response)
      throws Exception {

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

  @GetMapping("checkemail")
  public void checkMail(String email, HttpServletResponse response)
      throws Exception {

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

  @GetMapping("checknick")
  public void checkNick(String nick, HttpServletResponse response)
      throws Exception {

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

  @GetMapping("checktel")
  public void checkTel(String tel, HttpServletResponse response) throws Exception {

    Member m = memberService.getTel(tel);

    System.out.println(m);

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    if(m != null) {
      out.write("1");
    }
    else {
      out.write("0");
    }
  }

  @PostMapping("checkidtel")
  public void checkIdTel(String id, String tel, HttpServletResponse response) throws Exception {

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

  @GetMapping("checknumber")
  public void checkNumber(String tel, HttpServletResponse response) throws Exception {

    Random r  = new Random();
    String authenticationNumber = "";
    for(int i = 0; i < 6; i++) {
      String randomNumber = Integer.toString(r.nextInt(10));
      authenticationNumber += randomNumber;
    }

    memberService.certifyNumberForRegister(tel, authenticationNumber);

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.write(authenticationNumber);
  }

  @GetMapping("checknumber2")
  public void checkNumber2(String tel, HttpServletResponse response) throws Exception {

    Random r  = new Random();
    String authenticationNumber = "";
    for(int i = 0; i < 6; i++) {
      String randomNumber = Integer.toString(r.nextInt(10));
      authenticationNumber += randomNumber;
    }

    memberService.certifyNumberForPassword(tel, authenticationNumber);

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.write(authenticationNumber);
  }

  @RequestMapping("checkpassword")
  public void checkPassword(String id, String tel) throws Exception {

    int min = 97;
    int max = 122;
    int length = 10;
    Random random = new Random();
    String newPassword = random.ints(min, max + 1)
        .limit(length)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();

    memberService.setNewPassword(id, tel, newPassword);

  }

}

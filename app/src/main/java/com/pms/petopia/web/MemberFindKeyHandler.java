package com.pms.petopia.web;

import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

@Controller
public class MemberFindKeyHandler {

  MemberService memberService;

  public MemberFindKeyHandler(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/member/findKey")
  public String execute(HttpServletRequest request, HttpServletResponse response)
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

package com.pms.petopia.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

@Controller
public class AuthController {

  MemberService memberService;

  public AuthController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("login_form")
  public void execute()
      throws Exception {
  }

  @PostMapping("login")
  public String login(String id, String password, String saveIdOrEmail, HttpServletResponse response, HttpSession session)
      throws Exception {

    boolean check = isEmail(id);
    Member member = null;

    if(saveIdOrEmail != null) {
      Cookie cookie = new Cookie("id", id);
      cookie.setMaxAge(60 * 60 * 24);
      response.addCookie(cookie);
    }
    else {
      Cookie cookie = new Cookie("id", "");
      cookie.setMaxAge(0);
      response.addCookie(cookie);
    }

    if(check) {
      member = memberService.getEmail(id, password);
    }
    else {
      member = memberService.getId(id, password);
    }

    if (member == null) {
      session.invalidate();
      return "/login_form";
    }
    else {
      session.setAttribute("loginUser", member);
      return "../main";
    }
  }

  @RequestMapping("/logout")
  public String logout(HttpSession session)
      throws Exception {
    session.invalidate();
    return "redirect:login_form";

  }

  private boolean isEmail(String id) { 
    boolean check = false; 
    String regex = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$"; 
    Pattern p = Pattern.compile(regex); 
    Matcher email = p.matcher(id);
    if(email.matches()) { 
      check = true; 
    } 
    return check; 
  }

}

package com.pms.petopia.web;

import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

@Controller
public class AuthController {

  MemberService memberService;

  public AuthController(MemberService memberService) {
    this.memberService = memberService;
  }

  @GetMapping("/login")
  public String form()
      throws Exception {

    return "/jsp/login_form.jsp";
  }
  @PostMapping("/login")
  public void login(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String id = request.getParameter("id");
    boolean check = isEmail(id);
    String password = request.getParameter("password");
    Member member = null;

    if(request.getParameter("saveIdOrEmail") != null) {
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

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();


    if (member == null) {
      request.getSession().invalidate();
      out.write("0");
    }
    else {
      request.getSession().setAttribute("loginUser", member);
      out.write("1");
    }
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

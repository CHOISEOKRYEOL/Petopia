package com.pms.petopia.web;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

@Controller
public class LoginHandler {

  MemberService memberService;

  public LoginHandler(MemberService memberService) {
    this.memberService = memberService;
  }

  @RequestMapping("/login")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    if(request.getMethod().equals("GET")) {
      String id = "";

      Cookie[] cookies = request.getCookies();

      if(cookies != null) {
        for(Cookie c : cookies) {
          if(c.getName().equals("id")) {
            id = c.getValue();
            break;
          }
        }
      }

      request.setAttribute("id", id);
      return "/jsp/login_form.jsp";
    }

    else {
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

      if (member == null) {
        request.getSession().invalidate();
        return "/jsp/login_fail.jsp";
        //      response.setHeader("Refresh", "1;url=login");
      }
      else {
        request.getSession().setAttribute("loginUser", member);
        return "redirect:main";
      }
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

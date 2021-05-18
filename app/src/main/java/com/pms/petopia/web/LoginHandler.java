package com.pms.petopia.web;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/login")
public class LoginHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

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
    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("/jsp/login_form.jsp").include(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

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

    try {
      if(check) {
        member = memberService.getEmail(id, password);
      }
      else {
        member = memberService.getId(id, password);
      }

      response.setContentType("text/html;charset=UTF-8");

      if (member == null) {
        request.getSession().invalidate();
        request.getRequestDispatcher("/jsp/login_fail.jsp").include(request, response);
        response.setHeader("Refresh", "1;url=login");
      }
      else {
        System.out.println(member);
        request.getSession().setAttribute("loginUser", member);
        response.sendRedirect("main");
      }
    } catch (Exception e) {
      throw new ServletException(e);
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

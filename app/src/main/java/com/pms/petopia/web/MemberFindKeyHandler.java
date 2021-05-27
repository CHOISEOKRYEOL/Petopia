package com.pms.petopia.web;

import java.io.IOException;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/findKey")
public class MemberFindKeyHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("/jsp/member/findKey_form.jsp").include(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    String name = request.getParameter("name");
    String nick = request.getParameter("nick");

    try {

      Member m = memberService.getIdEmail(name, nick);

      request.setAttribute("member", m);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/member/find_id_email.jsp").include(request, response);

    }
    catch (Exception e) {
      throw new ServletException(e);
    }

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

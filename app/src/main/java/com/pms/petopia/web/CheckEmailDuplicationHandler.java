package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/checkemail")
public class CheckEmailDuplicationHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    String email = request.getParameter("email");

    try {

      Member m = memberService.getEmail(email);

      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();

      System.out.printf("입력 Email : %s\n", email);

      if(m != null) {
        out.print("1");
      }
      else {
        out.print("0");
      }

    }
    catch (Exception e) {
      throw new ServletException(e);
    }

  }
}

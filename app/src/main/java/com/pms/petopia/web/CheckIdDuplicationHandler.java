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
@WebServlet("/member/checkid")
public class CheckIdDuplicationHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    String id = request.getParameter("id");

    try {

      Member m = memberService.getId(id);

      response.setContentType("text/plain;charset=UTF-8");
      PrintWriter out = response.getWriter();

      System.out.printf("입력 ID : %s\n", id);

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

package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

@SuppressWarnings("serial")
@WebServlet("/member/add")
public class MemberAddHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("/jsp/member/member_form.jsp").include(request, response);

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    MemberService memberService = (MemberService) request.getServletContext().getAttribute("memberService");

    Member m = new Member();
    m.setName(request.getParameter("name"));
    m.setId(request.getParameter("id"));
    m.setNick(request.getParameter("nick"));
    m.setEmail(request.getParameter("email"));
    m.setPassword(request.getParameter("password"));
    String checkPassword = request.getParameter("checkPassword");
    m.setTel(request.getParameter("tel"));

    // 자바 스크립트 적용 전 테스트 코드
    if(!m.getPassword().equals(checkPassword)) {
      throw new ServletException("비밀번호가 일치하지 않습니다.");
    }

    if(m.getName().length() == 0 || m.getId().length() == 0 || m.getNick().length() == 0
        || m.getEmail().length() == 0 || m.getPassword().length() == 0 || m.getTel().length() == 0) {
      throw new ServletException("빈 칸 없이 입력하세요.");
    }

    response.setContentType("text/html;charset=UTF-8");

    try {
      memberService.add(m);
      request.setAttribute("member", m);
      request.getRequestDispatcher("/jsp/member/add_success.jsp").include(request, response);
      response.setHeader("Refresh", "1;url=../main");

    } catch (Exception e) {
      throw new ServletException(e);
    }

  }
}







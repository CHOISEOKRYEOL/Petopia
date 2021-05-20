package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;

@SuppressWarnings("serial")
@WebServlet("/main")
public class MainHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>회원 가입</title>");
    out.println("</head>");
    out.println("<body>");
    if(loginUser == null) {
      out.println("<h1>비회원 화면</h1>");
      out.println("<p><a href='member/add'>가입</a></p>");
      out.println("<p><a href='login'>로그인</a></p>");
      out.println("<p><a href='hospital/list'>병원 찾기</a></p>");
      out.println("<p><a href='story/list'>스토리</a></p>");
      out.println("<p><a href='sharingmarketboard/list'>나눔 장터</a></p>");
      out.println("<p><a href='mytown/main'>우리 동네</a></p>");
      out.println("<p><a href='review/list'>리뷰 목록</a></p>");
      out.println("<p><a href='qna/list'>Q&A 목록</a></p>");
    }
    else {
      out.println("<h1>회원 화면</h1>");
      out.println("<p><form action='member/detail' method='get'></p>");
      out.println("<input name='detail' type='submit' value='내 계정 관리'></form>");
      out.println("<p><form action='logout' method='post'></p>");
      out.println("<input name='logout' type='submit' value='로그아웃'></form>");
      out.println("<p><a href='pet/add'>마이펫 등록</a></p>");
      out.println("<p><a href='pet/list'>마이펫 리스트</a></p>");
      out.println("<p><a href='record/record.html'>진찰기록</a></p>");
      out.println("<p><a href='hospital/form.html'>병원 찾기</a></p>");
      out.println("<p><a href='pet/record.html'>진찰기록</a></p>");
      out.println("<p><a href='hospital/add'>병원 찾기</a></p>");
      out.println("<p><a href='story/add'>스토리</a></p>");
      out.println("<p><a href='sharingmarketboard/list'>나눔 장터</a></p>");
      out.println("<p><a href='mytown/main'>우리 동네</a></p>");
      out.println("<p><a href='review/add'>리뷰 작성</a></p>");
      out.println("<p><a href='review/list'>리뷰 목록</a></p>");
      out.println("<p><a href='qna/add'>Q&A 작성</a></p>");
      out.println("<p><a href='qna/list'>Q&A 목록</a></p>");
      out.println("<p><a href='admin/memberlist'>ADMIN 회원 리스트</a></p>");
    }
    out.println("</body>");
    out.println("</html>");
  }
}

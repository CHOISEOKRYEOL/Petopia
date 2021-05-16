package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Qna;
import com.pms.petopia.service.QnaService;

@SuppressWarnings("serial")
@WebServlet("/qna/add")
public class QnaAddHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    request.getRequestDispatcher("/jsp/qna/qna_form.jsp").include(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    QnaService qnaService = (QnaService) request.getServletContext().getAttribute("qnaService");


    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    if(loginUser == null) {
      throw new ServletException("로그인 후 이용하세요.");
    }

    Qna qna = new Qna();
    qna.setTitle(request.getParameter("title"));
    qna.setContent(request.getParameter("content"));
    qna.setWriter(loginUser);

    try {
      qnaService.add(qna);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/qna/qna_add_success.jsp").include(request, response);
      response.setHeader("Refresh", "1;url=list");
    }
    catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.QnaService;

@SuppressWarnings("serial")
@WebServlet("/qna/delete")
public class QnaDeleteHandler extends HttpServlet {


  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    QnaService qnaService = (QnaService) request.getServletContext().getAttribute("qnaService");
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    if(loginUser == null) {
      throw new ServletException("로그인 후 이용하세요.");
    }

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      qnaService.delete(no);

      response.setHeader("Refresh", "1;url=list");
    }
    catch (Exception e) {
      throw new ServletException(e);

    }
  }
}

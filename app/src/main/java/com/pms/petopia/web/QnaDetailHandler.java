package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Qna;
import com.pms.petopia.service.QnaService;

@SuppressWarnings("serial")
@WebServlet("/qna/detail")
public class QnaDetailHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    QnaService qnaService = (QnaService) request.getServletContext().getAttribute("qnaService");

    int no = Integer.parseInt(request.getParameter("no"));

    try {
      Qna q = qnaService.get(no);
      request.setAttribute("qna", q);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/qna/detail.jsp").include(request, response);

    }
    catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

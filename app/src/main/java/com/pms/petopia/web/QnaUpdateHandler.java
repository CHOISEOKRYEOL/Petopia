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
@WebServlet("/qna/update")
public class QnaUpdateHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    QnaService qnaService = (QnaService) request.getServletContext().getAttribute("qnaService");

    int no = Integer.parseInt(request.getParameter("no"));
    try {
      Qna q = qnaService.get(no);
      request.setAttribute("qna", q);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/qna/modifying_form.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    QnaService qnaService = (QnaService) request.getServletContext().getAttribute("qnaService");

    Qna qna = new Qna();
    qna.setNo(Integer.parseInt(request.getParameter("no")));
    qna.setTitle(request.getParameter("title"));
    qna.setContent(request.getParameter("content"));
    try {
      qnaService.update(qna);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/admin/qna_update.jsp").include(request, response);
      response.setHeader("Refresh", "1;url=list");
    }
    catch (Exception e) {
      throw new ServletException(e);

    }
  }
}

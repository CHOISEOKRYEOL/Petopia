package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
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

    QnaService qnaService = (QnaService) request.getServletContext().getAttribute("quaService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    int no = Integer.parseInt(request.getParameter("no"));

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Q&A 상세보기</title>");
    out.println("</head>");
    out.println("<body>");

    try {
      Qna q = qnaService.findByNo(no);
      out.println("<h1>Q&A 상세보기</h1>");
      out.println("<table border = '1'>");
      out.println("<tbody>");
      out.println("<form action='update' method='post'>");
      out.printf("<tr><th>제목</th><td><input type='text' values='%s'></td></tr>\n", q.getTitle());
      out.printf("<tr><th>내용</th><td><textarea name='content' rows='10' cols='60' values='%s'></td></tr>\n", q.getContent());
      out.println("<input type='submit' value='수정'></form>");
      out.println("<a href='delete'>삭제</a>"); 
    }
    catch (Exception e) {
      throw new ServletException(e);
    }
    out.println("</body>");
    out.println("</html>");
  }
}

package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Qna;
import com.pms.petopia.service.QnaService;

@SuppressWarnings("serial")
@WebServlet("/qna/detail")
public class QnaDetailHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    QnaService qnaService = (QnaService) request.getServletContext().getAttribute("quaService");
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");


    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Q&A 상세보기</title>");
    out.println("</head>");
    out.println("<body>");

    try {
      Qna q = qnaService.findByNo(loginUser.getNo());
      out.println("<h1>Q&A 상세보기</h1>");
      out.println("<form action='update' method='post'>");
      out.println("<table border = '1'>");
      out.println("<tbody>");
      if(loginUser.getNo() == q.getWriter().getNo()) {
        out.println("제목 : <input type='text' name='title'><br>");
        out.println("내용 : <textarea name='content' rows='10' cols='60'></textarea><br>");
        out.println("<input type='submit' value='수정'>");
      }
      else {
        out.printf("<tr><th>제목</th><td><input type='text' values='%s' readonly></td></tr>\n", q.getTitle());
        out.printf("<tr><th>내용</th><td><textarea name='content' rows='10' cols='60' values='%s' readonly></td></tr>\n", q.getContent());
      }
    }
    catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }
    out.println("</body>");
    out.println("</html>");
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

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>Q&A 등록</title>");
    out.println("</head>");
    out.println("<body>");

    try {
      qnaService.add(qna);

      out.println("<h1>Q&A 등록</h1>");

      response.setHeader("Refresh", "1;url=../main");
    }
    catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

    }
    out.println("</body>");
    out.println("</html>");
  }
}

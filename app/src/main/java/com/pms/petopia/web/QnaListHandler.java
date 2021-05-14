package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Qna;
import com.pms.petopia.service.QnaService;

@SuppressWarnings("serial")
@WebServlet("/qna/list")
public class QnaListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    QnaService qnaService = (QnaService) request.getServletContext().getAttribute("qnaService");

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>내 Q&A 목록</title>");
    out.println("</head>");
    out.println("<body>");

    out.printf("<h1>%s의 Q&A 목록</h1>\n", loginUser.getNick());
    try {
      List<Qna> list = qnaService.list();

      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>번호</th> <th>제목</th> <th>작성자</th> <th>등록일</th> ");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");

      for(Qna q : list) {
        if(q.getWriter().getNo() == loginUser.getNo()) {
          out.printf("<tr><td>%d</td>"
              + "<td><a href='detail?no=%1$d'>%s</a></td>"
              + "<td>%s</td>"
              + "<td>%s</td></tr>\n", 
              q.getNo(), q.getTitle(), q.getWriter().getName(), q.getCreatedDate());
        }
      }
      out.println("</tbody>");
      out.println("</table>");

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

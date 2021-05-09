package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.SimpleDateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.domain.Record;
import com.pms.petopia.service.RecordService;

@SuppressWarnings("serial")
@WebServlet("/record/detail")
public class RecordDetailHandler extends HttpServlet {

  Pet pet;

  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RecordService recordService = (RecordService) request.getServletContext().getAttribute("recordService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    int no = Integer.parseInt(request.getParameter("no"));

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>마이펫 상세</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>마이펫 상세보기</h1>");

    try {
      Record r = recordService.get(no);
      if (r == null) {
        out.println("<p>해당 번호의 펫이 없습니다.</p>");
        return;
      }

      out.println("<form action='update' method='post'>");
      out.println("<table border='1'>");
      out.println("<tbody>");
      out.printf("<tr><th>이름</th>"
          + " <td><input type='text' name='no' value='%d' readonly></td></tr>\n", pet.getName());
      out.printf("<tr><th>나이</th>"
          + " <td><input name='title' type='text' value='%s'></td></tr>\n", pet.getAge());
      out.printf("<tr><th>생년월일</th>"
          + " <td><textarea name='content' rows='10' cols='60'>%s</textarea></td></tr>\n", pet.getBirthDay());
      out.printf("<tr><th>성별</th> <td>%s</td></tr>\n", pet.isGender());
      out.printf("<tr><th>사진</th> <td>%s</td></tr>\n", pet.getPhoto());
      out.println("</tbody>");

      //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      if (loginUser != null && b.getWriter().getNo() == loginUser.getNo()) {
      //        out.println("<tfoot>");
      //        out.println("<tr><td colspan='2'>");
      //        out.println("<input type='submit' value='변경'> "
      //            + "<a href='delete?no=" + b.getNo() + "'>삭제</a> ");
      //        out.println("</td></tr>");
      //        out.println("</tfoot>");
      //      }

      out.println("</table>");
      out.println("</form>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }
    out.println("<p><a href='list'>목록</a></p>");

    out.println("</body>");
    out.println("</html>");
  }
}






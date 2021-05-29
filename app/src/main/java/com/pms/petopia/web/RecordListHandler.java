package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Record;
import com.pms.petopia.service.RecordService;


@Controller
public class RecordListHandler {

  RecordService recordService;

  public RecordListHandler(RecordService recordService) {
    this.recordService = recordService;
  }

  @RequestMapping("/record/list")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>진료 목록</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>진료 목록</h1>");

    out.println("<p><a href='form.html'>새 글</a></p>");

    List<Record> records = recordService.list();

    out.println("<table border='1'>");
    out.println("<thead>");
    out.println("<tr>");
    out.println("<th>번호</th> <th>상태</th> <th>기록</th>");
    out.println("</tr>");
    out.println("</thead>");
    out.println("<tbody>");

    for (Record r : records) {
      out.printf("<tr>"
          + " <td>%d</td>"
          + " <td><a href='detail?no=%1$d'>%s</a></td>"
          + " <td>%d</td>"
          + " <td>%s</td>"
          + " </tr>\n", 
          r.getState(), 
          r.getRecord());
    }
    out.println("</tbody>");
    out.println("</table>");


    out.println("</body>");
    out.println("</html>");
    return "" // 체크
  }
}







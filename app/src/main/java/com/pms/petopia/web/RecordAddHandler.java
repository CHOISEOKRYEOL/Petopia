package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Record;
import com.pms.petopia.service.RecordService;

@SuppressWarnings("serial")
@WebServlet("/record/add")
public class RecordAddHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    RecordService recordService = (RecordService) request.getServletContext().getAttribute("RecordService");

    Record r = new Record();

    // 클라이언트가 POST 요청으로 보낸 데이터가 UTF-8임을 알려준다.
    request.setCharacterEncoding("UTF-8");

    r.setState(Integer.parseInt(request.getParameter("state")));
    r.setRecord(request.getParameter("record"));

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>진료기록 등록</title>");

    try {
      recordService.add(r);

      out.println("<meta http-equiv='Refresh' content='1;url=../main'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>진료기록 등록</h1>");
      out.println("<p>진료기록을 등록했습니다.</p>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>진료 기록 등록 오류</h1>");
      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }

}

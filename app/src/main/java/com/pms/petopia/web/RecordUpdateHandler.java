package com.pms.petopia.web;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Record;
import com.pms.petopia.service.RecordService;


@Controller
public class RecordUpdateHandler {

  RecordService recordService;

  public RecordUpdateHandler(RecordService recordService) {
    this.recordService = recordService;
  }

  @RequestMapping("/record/update")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>진료기록 변경</title>");

    request.setCharacterEncoding("UTF-8");
    int no = Integer.parseInt(request.getParameter("no"));

    Record record = new Record();
    record.setState(record.getState());
    record.setRecord(request.getParameter("record"));

    recordService.update(record);

    out.println("<meta http-equiv='Refresh' content='1;url=list'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>마이펫 변경</h1>");
    out.println("<p>마이펫을 변경하였습니다.</p>");


    out.println("</body>");
    out.println("</html>");

    return ""; // 체크
  }
}







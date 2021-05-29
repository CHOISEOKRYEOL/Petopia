package com.pms.petopia.web;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Record;
import com.pms.petopia.service.RecordService;

@Controller
public class RecordDetailHandler {

  RecordService recordService;

  public RecordDetailHandler(RecordService recordService) {
    this.recordService = recordService;
  }

  @RequestMapping("/record/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

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

    Record r = recordService.get(no);
    if (r == null) {
      out.println("<p>해당 번호의 펫이 없습니다.</p>");
    }

    out.println("<form action='update' method='post'>");
    out.println("<table border='1'>");
    out.println("<tbody>");
    out.printf("<tr><th>상태</th>"
        + " <td><input type='text' name='state' value='%d'></td></tr>\n", r.getState());
    out.printf("<tr><th>기록</th>"
        + " <td><input type='text'name='history' value='%s'></td></tr>\n", r.getRecord());
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

    out.println("<p><a href='list'>목록</a></p>");

    out.println("</body>");
    out.println("</html>");

    return ""; // 체크
  }
}







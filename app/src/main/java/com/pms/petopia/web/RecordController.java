package com.pms.petopia.web;

import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.domain.Record;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.PetService;
import com.pms.petopia.service.RecordService;

@Controller
@RequestMapping("/record")
public class RecordController {

  RecordService recordService;
  HospitalService hospitalService;
  PetService petService;

  public RecordController(RecordService recordService, HospitalService hospitalService, PetService petService) {
    this.recordService = recordService;
    this.hospitalService = hospitalService;
    this.petService = petService;
  }  

  @RequestMapping("add")
  public String add(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    if(request.getMethod().equals("GET")) {

      return "/jsp/record/form.jsp";
    }
    Record r = new Record();
    r.setRecord(request.getParameter("record"));

    Pet petNo = (Pet) request.getSession().getAttribute("petNo");
    r.setPetNo(petNo);

    Hospital hospital = (Hospital) request.getSession().getAttribute("hospital");
    r.setHospitalNo(hospital);

    recordService.add(r);

    return "../main";
    //            response.setHeader("Refresh", "1;url=../main");
  }

  @RequestMapping("delete")
  public String delete(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    response.setContentType("text/plain;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("[진료기록 삭제]");

    int no = Integer.parseInt(request.getParameter("no"));

    if (recordService.delete(no) == 0) {
      out.println("해당 번호의 펫이 없습니다.");
    } else {
      out.println("펫을 삭제하였습니다.");
    }

    return ""; // 체크
  }

  @RequestMapping("detail")
  public String detail(HttpServletRequest request, HttpServletResponse response)
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

  @RequestMapping("list")
  public String list(HttpServletRequest request, HttpServletResponse response)
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
    return ""; // 체크
  }

  @RequestMapping("update")
  public String update(HttpServletRequest request, HttpServletResponse response)
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

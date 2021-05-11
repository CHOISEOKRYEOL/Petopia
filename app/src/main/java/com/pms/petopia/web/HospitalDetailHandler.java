package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.service.HospitalService;

@SuppressWarnings("serial")
@WebServlet("/hospital/detail")
public class HospitalDetailHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HospitalService hospitalService = (HospitalService) request.getServletContext().getAttribute("hospitalService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>병원 상세</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>병원 상세보기</h1>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Hospital hospital = hospitalService.get(no);
      if (hospital == null) {
        out.println("<p>해당 번호의 스토리가 없습니다.</p>");
        out.println("</body>");
        out.println("</html>");
        return;
      }

      out.println("<form action='update' method='post'>");
      out.printf("번호: <input type='text' name='no' value='%d' readonly><br>\n", hospital.getNo());
      out.printf("병원이름: <input type='text' name='name' value='%s'><br>\n", hospital.getName());
      out.printf("전화번호: <input type='tel' name='tel' value='%s'><br>\n", hospital.getTel());
      out.printf("주소: <input type='text' name='address' value='%s'><br>\n", hospital.getAddress());
      out.printf("진료시간: <input type='text' name='time' value='%s'><br>\n", hospital.getBusinessHour());
      out.printf("주차여부: <input type='checkbox' name='parking' value='%d'><br>\n", hospital.getParking());
      out.printf("수의사: <input type='number' name='vet' value='%d'><br>\n", hospital.getVeterinarian());

      out.println("<input type='submit' value='변경'> ");
      out.printf("<a href='delete?no=%d'>삭제</a>\n", hospital.getNo());
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

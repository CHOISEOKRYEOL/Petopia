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
@WebServlet("/hospital/update")
public class HospitalUpdateHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HospitalService hospitalService = (HospitalService) request.getServletContext().getAttribute("hospitalService");

    request.setCharacterEncoding("UTF-8");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>병원 변경</title>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      Hospital oldHospital = hospitalService.get(no);

      if (oldHospital == null) {
        throw new Exception("해당 번호의 병원이 없습니다.");
      }

      //      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      //      if (oldHospital.getWriter().getNo() != loginUser.getNo()) {
      //        throw new Exception("변경 권한이 없습니다!");
      //      }

      Hospital hospital = new Hospital();
      hospital.setNo(oldHospital.getNo());
      hospital.setName(request.getParameter("name"));
      hospital.setTel(request.getParameter("tel"));
      hospital.setAddress(request.getParameter("address"));
      hospital.setBusinessHour(request.getParameter("time"));
      hospital.setParking(Integer.valueOf(request.getParameter("parking")));
      hospital.setVeterinarian(Integer.valueOf(request.getParameter("vet")));

      hospitalService.update(hospital);

      out.println("<meta http-equiv='Refresh' content='1;url=list'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>병원 변경</h1>");
      out.println("<p>병원을 변경했습니다.</p>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>병원 변경 오류</h1>");
      out.printf("<p>%s</p>\n", e.getMessage());
      out.printf("<pre>%s</pre>\n", strWriter.toString());
      out.println("<p><a href='list'>목록</a></p>");
    }

    out.println("</body>");
    out.println("</html>");
  }
}

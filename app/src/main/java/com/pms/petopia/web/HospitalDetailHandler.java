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
    //    BigAddressService bigAddressService = (BigAddressService) request.getServletContext().getAttribute("bigAddressService");
    //    SmallAddressService smallAddressService = (SmallAddressService) request.getServletContext().getAttribute("smallAddressService");

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
      out.printf("번호 <input type='text' name='no' value='%d' readonly><br>\n", hospital.getNo());
      out.printf("병원이름 <input type='text' name='name' value='%s'><br>\n", hospital.getName());
      out.printf("전화번호 <input type='tel' name='tel' value='%s'><br>\n", hospital.getTel());
      //      try {
      //        BigAddress bigAddress = bigAddressService.get(no);
      //        if (bigAddress.getNo() == 1) {
      //          out.println("기본주소 <select name='gno'><option value=''>분류</option><option value='1' selected>서울특별시</option></select>\n");
      //        } else {
      //          out.println("기본주소 <select name='gno'><option value=''>분류</option><option value='1'>서울특별시</option></select>\n");
      //        }
      //        SmallAddress smallAddress = smallAddressService.get(no);
      //        if (smallAddress.getNo() == 1) {
      //          out.println("<select name='cno'><option value=''>분류</option><option value='1' selected>강남구</option></select><br>\n");
      //        } else {
      //          out.println("<select name='cno'><option value=''>분류</option><option value='1'>강남구</option></select><br>\n");
      //        }
      //      } catch (Exception e) {
      //        throw new ServletException(e);
      //      }
      out.println("기본주소 <select name='gno'><option value=''>분류</option>"
          + "<option value='1'>서울특별시</option>\n"
          + "<option value='2'>경기도</option>\n"
          + "<option value='3'>인천광역시</option></select>");
      out.println("<select name='cno'><option value=''>분류</option>"
          + "<optgroup label='서울특별시'>"
          + "<option value='1'>강남구</option></optgroup>\n"
          + "<optgroup label='경기도'>"
          + "<option value='2'>김포시</option></optgroup>\n"
          + "<optgroup label='인천광역시'>"
          + "<option value='3'>중구</option></optgroup></select><br>");

      out.printf("상세주소 <input type='text' name='address' value='%s'><br>\n", hospital.getAddress());
      out.printf("진료시간 <input type='text' name='time' value='%s'><br>\n", hospital.getBusinessHour());

      if (hospital.getParking() == 1) {
        out.println("주차여부 <input type='radio' name='parking' value='1' checked>Yes"
            + "<input type='radio' name='parking' value='0'>No<br>\n");
      } else if (hospital.getParking() == 0) {
        out.println("주차여부 <input type='radio' name='parking' value='1'>Yes"
            + "<input type='radio' name='parking' value='0' checked>No<br>\n");
      }
      out.printf("수의사 <input type='number' name='vet' value='%d'><br>\n", hospital.getVeterinarian());

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

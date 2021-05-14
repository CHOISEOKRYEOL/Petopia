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
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.service.HospitalService;

@SuppressWarnings("serial")
@WebServlet("/hospital/list")
public class HospitalListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    HospitalService hospitalService = (HospitalService) request.getServletContext().getAttribute("hospitalService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>병원 찾기</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>병원 찾기</h1>");

    out.println("<p><a href='form.html'>새 병원</a></p>");

    try {
      List<Hospital> hospitals = hospitalService.list(); 

      out.println("<table border='1'>");
      out.println("<thead>");
      out.println("<tr>");
      out.println("<th>번호</th> <th>이름</th> <th>전화</th> <th>기본주소</th> <th>상세주소</th> <th>진료시간</th> <th>평점</th>");
      out.println("</tr>");
      out.println("</thead>");
      out.println("<tbody>");

      for (Hospital h : hospitals) {
        out.printf("<tr>"
            + " <td>%d</td>"
            + " <td><a href='detail?no=%1$d'>%s</a></td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%s</td>"
            + " <td>%02d시 ~ %02d시</td>"
            + " <td>%d</td> </tr>\n",
            h.getNo(),
            h.getName(),
            h.getTel(),
            h.getSmallAddress().getName(),
            h.getAddress(),
            h.getStartTime(),
            h.getEndTime(),
            h.getRate());
      }
      out.println("</tbody");
      out.println("</table>");

      out.println("<form action='search' method='get'>");
      out.println("<select name='gno'><option value=''>분류</option>"
          + "<option value='1'>서울특별시</option>\\n"
          + "<option value='2'>경기도</option>\n"
          + "<option value='3'>인천광역시</option></select>");
      out.println("<select name='cno'><option value=''>분류</option>"
          + "<optgroup label='서울특별시'>"
          + "<option value='1'>강남구</option></optgroup>\n"
          + "<optgroup label='경기도'>"
          + "<option value='2'>김포시</option></optgroup>\n"
          + "<optgroup label='인천광역시'>"
          + "<option value='3'>중구</option></optgroup>\n"
          + "</select>");
      out.println("<button>검색</button>");
      out.println("</form>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }

    out.println("</body>");
    out.println("</html>");
  }
}

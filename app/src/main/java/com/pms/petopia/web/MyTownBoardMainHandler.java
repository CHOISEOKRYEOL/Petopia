package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/mytown/main")
public class MyTownBoardMainHandler extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    response.setContentType("text/html;charset=UTF-8");

    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>우리동네</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>우리동네 찾기</h1>");

    try {
      out.println("<form action='list' method='get'>");
      out.println("광역시/도 : ");
      out.println("<select name='stateNo'>");
      out.println("<option value='1' selected>서울특별시</option>");
      out.println("<option value='2'>경기도</option>");
      out.println("<option value='3'>인천광역시</option>");
      out.println("</select>");

      out.println("시/군/구 : ");
      out.println("<select name='cityNo'>");
      out.println("<option value='1' selected>강남구</option>");
      out.println("<option value='2'>서초구</option>");
      out.println("<option value='3'>종로구</option>");
      out.println("<option value='4'>중구</option>");
      out.println("<option value='5'>성북구</option>");
      out.println("<option value='5'>성남시</option>");
      out.println("<option value='6'>안양시</option>");
      out.println("<option value='7'>광명시</option>");
      out.println("<option value='8'>안산시</option>");
      out.println("<option value='9'>시흥시</option>");
      out.println("<option value='10'>서구</option>");
      out.println("<option value='11'>동구</option>");
      out.println("<option value='12'>중구</option>");
      out.println("<option value='13'>남구</option>");
      out.println("<option value='15'>부평구</option>");
      out.println("<option value='16'>계양구</option>");
      out.println("<option value='17'>연수구</option>");
      out.println("</select>");

      //      out.println("<select name ='stateNo'>\n");
      //      for (SmallAddress s : smallAddress) {
      //        out.printf("<option value='%d'>%s</option>\n", s.getBigAddress().getNo(), s.getBigAddress().getName());
      //      }
      //      out.println("</select>\n");
      //
      //      out.println("시/군/구 : ");
      //      out.println("<select name='cityNo'>\n");
      //      for (SmallAddress s : smallAddress) {
      //        out.printf("<option value='%d'>%s</option>\n", s.getNo(), s.getName());
      //      }
      //      out.println("</select>\n");

      out.println("<input type='submit' value='찾기'>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }
    out.println("</form");
    out.println("</body>");
    out.println("</html>");
  }
}

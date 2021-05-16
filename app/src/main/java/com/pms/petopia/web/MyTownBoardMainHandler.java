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
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.SmallAddressService;

@SuppressWarnings("serial")
@WebServlet("/mytown/main")
public class MyTownBoardMainHandler extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {


    SmallAddressService smallAddressService = (SmallAddressService) request.getServletContext().getAttribute("smallAddressService");

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
      List<SmallAddress> smallAddress = smallAddressService.list();
      out.println("광역시/도 : ");
      out.println("<select name ='stateNo'>\n");
      for (SmallAddress s : smallAddress) {
        out.printf("<option value='%d'>%s</option>\n", s.getBigAddress().getNo(), s.getBigAddress().getName());
      }
      out.println("</select>\n");

      out.println("시/군/구 : ");
      out.println("<select name='cityNo'>\n");
      for (SmallAddress s : smallAddress) {
        out.printf("<option value='%d'>%s</option>\n", s.getNo(), s.getName());
      }
      out.println("</select>\n");

      out.println("<input type='submit' value='찾기'>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.printf("<pre>%s</pre>\n", strWriter.toString());
    }
    out.println("</form>");
    out.println("</body>");
    out.println("</html>");
  }
}

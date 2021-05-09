package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.service.PetService;

@SuppressWarnings("serial")
@WebServlet("/pet/update")
public class PetUpdateHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    PetService petMemberService = (PetService) request.getServletContext().getAttribute("PetMemberService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>마이펫 변경</title>");

    try {
      request.setCharacterEncoding("UTF-8");
      //      int no = Integer.parseInt(request.getParameter("no"));

      Pet pet = new Pet();
      pet.setNo(pet.getNo());
      pet.setName(request.getParameter("name"));

      petMemberService.update(pet);

      out.println("<meta http-equiv='Refresh' content='1;url=list'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<h1>마이펫 변경</h1>");
      out.println("<p>마이펫을 변경하였습니다.</p>");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);

      out.println("</head>");
      out.println("<body>");
      out.println("<h1>마이펫 변경 오류</h1>");
      out.printf("<p>%s</p>\n", e.getMessage());
      out.printf("<pre>%s</pre>\n", strWriter.toString());
      out.println("<p><a href='list'>목록</a></p>");
    }

    out.println("</body>");
    out.println("</html>");

  }
}







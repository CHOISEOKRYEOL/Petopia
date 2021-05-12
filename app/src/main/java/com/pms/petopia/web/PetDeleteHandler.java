package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.service.PetService;

@SuppressWarnings("serial")
@WebServlet("/pet/delete")
public class PetDeleteHandler extends HttpServlet {

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PetService petMemberService = (PetService) request.getServletContext().getAttribute("PetMemberService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("[나의 펫 삭제]");

    try {
      int no = Integer.parseInt(request.getParameter("no"));

      if (petMemberService.delete(no) == 0) {
        out.println("해당 번호의 펫이 없습니다.");
      } else {
        out.println("펫을 삭제하였습니다.");
      }
    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.println(strWriter.toString());
    }
  }

}

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

    PetService petService = (PetService) request.getServletContext().getAttribute("petService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>마이펫 삭제</title>");
    out.println("</head>");
    out.println("<body>");

    try {
      int no = Integer.parseInt(request.getParameter("no"));
      petService.delete(no);
      out.println("<h1>마이펫 삭제 완료</h1>");

      response.setHeader("Refresh", "1;url=../main");

    } catch (Exception e) {
      StringWriter strWriter = new StringWriter();
      PrintWriter printWriter = new PrintWriter(strWriter);
      e.printStackTrace(printWriter);
      out.println(strWriter.toString());
    }
  }

}

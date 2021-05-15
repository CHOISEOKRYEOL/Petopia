package com.pms.petopia.web;

import java.io.IOException;
import java.io.PrintWriter;
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
    PetService petService = (PetService) request.getServletContext().getAttribute("petService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>마이펫 변경</title>");
    out.println("</head>");
    out.println("<body>");
    out.println("<h1>마이펫 변경</h1>");

    Pet p = new Pet();
    p.setNo(Integer.parseInt(request.getParameter("no")));
    p.setName(request.getParameter("name"));
    p.setPhoto(request.getParameter("photo"));
    try {

      petService.update(p);

      out.println("<p>마이펫을 변경하였습니다.</p>");
      response.setHeader("Refresh", "1;url=list");

    } catch (Exception e) {
      throw new ServletException(e);
    }

    out.println("</body>");
    out.println("</html>");

  }
}







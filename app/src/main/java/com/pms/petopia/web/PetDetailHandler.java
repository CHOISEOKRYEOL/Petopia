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
@WebServlet("/pet/detail")
public class PetDetailHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PetService petService = (PetService) request.getServletContext().getAttribute("petService");

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();

    int no = Integer.parseInt(request.getParameter("no"));

    try {

      Pet pet = petService.get(no);
      request.setAttribute("pet",pet);
      request.getSession().setAttribute("petInfo", pet);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/pet/detail.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}







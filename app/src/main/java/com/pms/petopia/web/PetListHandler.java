package com.pms.petopia.web;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.service.PetService;

@SuppressWarnings("serial")
@WebServlet("/pet/list")
public class PetListHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // 클라이언트가 /board/list 를 요청하면 톰캣 서버가 이 메서드를 호출한다. 

    PetService petService = (PetService) request.getServletContext().getAttribute("petService");

    try {

      String keyword = request.getParameter("keyword");
      List<Pet> boards = null;
      if (keyword != null && keyword.length() > 0) {
        boards = petService.search(keyword);
      } else {
        boards = petService.list();
      }

      List<Pet> pets = petService.list();

      //      HttpSession session = request.getSession();
      //      session.setAttribute("petNo", request.getParameter("petNo"));

      request.setAttribute("list", pets);
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/pet/list.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }

  }
}







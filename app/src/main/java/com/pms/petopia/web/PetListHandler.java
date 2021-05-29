package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
<<<<<<< HEAD
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
=======
>>>>>>> d845db09d0d03e1454ec3adeb83c7eadf992e9f3
import com.pms.petopia.domain.Pet;
import com.pms.petopia.service.PetService;

@Controller
public class PetListHandler {

  PetService petService;

  public PetListHandler(PetService petService) {
    this.petService = petService;
  }

  @RequestMapping("/pet/list")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {


<<<<<<< HEAD
    String keyword = request.getParameter("keyword");
    List<Pet> pets = null;
    if (keyword != null && keyword.length() > 0) {
      pets = petService.search(keyword);
    } else {
      pets = petService.list();
    }
=======
      //      HttpSession session = request.getSession();
      //      session.setAttribute("petNo", request.getParameter("petNo"));
>>>>>>> d845db09d0d03e1454ec3adeb83c7eadf992e9f3

    HttpSession session = request.getSession();
    session.setAttribute("petNo", request.getParameter("petNo"));

    request.setAttribute("list", pets);
    return "/jsp/pet/list.jsp";

  }
}







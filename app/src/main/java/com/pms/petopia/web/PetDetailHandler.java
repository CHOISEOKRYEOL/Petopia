package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.service.PetService;

@Controller
public class PetDetailHandler {

  PetService petService;

  public PetDetailHandler(PetService petService) {
    this.petService = petService;
  }

  @RequestMapping("/pet/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));


    Pet pet = petService.get(no);
    request.setAttribute("pet",pet);
    //      request.getSession().setAttribute("petInfo", pet);

    return "/jsp/pet/detail.jsp";

  }
}







package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.service.PetService;

@Controller
public class PetDeleteHandler {

  PetService petService;

  public PetDeleteHandler(PetService petService) {
    this.petService = petService;
  }

  @RequestMapping("/pet/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));
    petService.delete(no);

    return "/jsp/pet/delete.jsp";
    //    response.setHeader("Refresh", "1;url=list");

  }
}

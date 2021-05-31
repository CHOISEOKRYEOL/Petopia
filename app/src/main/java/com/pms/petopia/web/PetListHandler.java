package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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


    String keyword = request.getParameter("keyword");
    List<Pet> pets = null;
    if (keyword != null && keyword.length() > 0) {
      pets = petService.search(keyword);
    } else {
      pets = petService.list();
    }

    HttpSession session = request.getSession();
    session.setAttribute("petNo", request.getParameter("petNo"));

    //    int leader = Integer.parseInt(request.getParameter("leader"));
    //    if(leader == 1 ) {
    //      
    //    }

    request.setAttribute("list", pets);
    return "/jsp/pet/list.jsp";

  }
}







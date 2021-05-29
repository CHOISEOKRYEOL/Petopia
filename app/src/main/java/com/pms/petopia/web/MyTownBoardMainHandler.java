package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.SmallAddressService;

@Controller
public class MyTownBoardMainHandler {

  SmallAddressService smallAddressService;

  public MyTownBoardMainHandler(SmallAddressService smallAddressService) {
    this.smallAddressService = smallAddressService;
  }

  @RequestMapping("/mytown/main")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    List<SmallAddress> smallAddresses = smallAddressService.list();

    request.setAttribute("smallAddresses", smallAddresses);

    return "/jsp/mytown/main.jsp";

  }
}

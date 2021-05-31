package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Bookmark;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.BookmarkService;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.SmallAddressService;

@Controller
public class HospitalListHandler {

  HospitalService hospitalService;
  BookmarkService bookmarkService;
  SmallAddressService smallAddressService;

  public HospitalListHandler(HospitalService hospitalService, BookmarkService bookmarkService, SmallAddressService smallAddressService) {
    this.hospitalService = hospitalService;
    this.bookmarkService = bookmarkService;
    this.smallAddressService = smallAddressService;
  }

  @RequestMapping("/hospital/list")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    String gno = request.getParameter("gno");
    String cno = request.getParameter("cno");

    List<Hospital> hospitals = hospitalService.list();
    List<SmallAddress> area = smallAddressService.list();
    if(loginUser != null) {
      List<Bookmark> book = bookmarkService.get(loginUser.getNo());
      request.setAttribute("book", book);
    }

    if (gno != null && cno != null) {
      int cityNo = Integer.parseInt(cno);
      String cityName = smallAddressService.get(cityNo).getName();
      String stateName = smallAddressService.get(cityNo).getBigAddress().getName();
      request.setAttribute("stateName", stateName);
      request.setAttribute("cityName", cityName);
      //이름으로 넘길까? 그래야 검색하지 

    }

    request.setAttribute("list", hospitals);
    request.setAttribute("area", area);

    return "/jsp/hospital/list.jsp";

  }
}

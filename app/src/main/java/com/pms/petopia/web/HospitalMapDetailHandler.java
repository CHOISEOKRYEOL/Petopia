package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.BookmarkService;
import com.pms.petopia.service.HospitalService;

@Controller
public class HospitalMapDetailHandler {

  HospitalService hospitalService;
  BookmarkService bookmarkService;

  public HospitalMapDetailHandler(HospitalService hospitalService, BookmarkService bookmarkService) {
    this.hospitalService = hospitalService;
    this.bookmarkService = bookmarkService;
  }

  @RequestMapping("/hospital/detail")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    String address = request.getParameter("a");
    String hname = request.getParameter("h");

    Hospital hospital = hospitalService.get(hname);
    //Bookmark bookmark = bookmarkService.get(loginUser.getNo(), hospital.getNo());

    //request.setAttribute("bookmark", bookmark);
    request.setAttribute("hospital", hospital);

    System.out.println("gggg");
    if(address != null) {
      request.setAttribute("hname", hname);
    }
    request.setAttribute("address", address);

    return "/jsp/hospital/detail.jsp";

  }
}

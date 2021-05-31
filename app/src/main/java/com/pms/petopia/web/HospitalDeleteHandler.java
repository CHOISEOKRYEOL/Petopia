package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.service.BookmarkService;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.ReviewService;

@Controller
public class HospitalDeleteHandler {

  HospitalService hospitalService;
  ReviewService reviewService;
  BookmarkService bookmarkService;

  public HospitalDeleteHandler(HospitalService hospitalService, ReviewService reviewService, BookmarkService bookmarkService) {
    this.hospitalService = hospitalService;
    this.reviewService = reviewService;
    this.bookmarkService = bookmarkService;
  }

  @RequestMapping("/hospital/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    reviewService.deleteByAdmin(no);
    bookmarkService.deleteByAdmin(no);
    hospitalService.delete(no);

    return "../admin/hospitallist";

  }
}

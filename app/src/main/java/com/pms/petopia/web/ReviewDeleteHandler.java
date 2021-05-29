package com.pms.petopia.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Review;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.ReviewService;

@Controller
public class ReviewDeleteHandler {

  ReviewService reviewService;
  HospitalService hospitalService;

  public ReviewDeleteHandler(ReviewService reviewService, HospitalService hospitalService) {
    this.reviewService = reviewService;
    this.hospitalService = hospitalService;
  }

  @RequestMapping("/review/delete")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    int no = Integer.parseInt(request.getParameter("no"));
    int hno = Integer.parseInt(request.getParameter("hno"));

    Review r = reviewService.get(no);

    float deletingRating = (r.getCleanlinessRating() + r.getServiceRating() + r.getCostRating()) / 3.0F;

    Hospital h = hospitalService.getRating(hno);

    float accumulatedRating = h.getAccumulatedRating();

    reviewService.delete(no);

    String temp = reviewService.countReview(h.getNo());
    int count = Integer.parseInt(temp);

    float newAccumulatedRating = accumulatedRating - deletingRating;
    float finalRating = newAccumulatedRating / (count * 1.0F);

    hospitalService.initAccumulatedRating(hno);

    h.setAccumulatedRating(newAccumulatedRating);
    hospitalService.setAccumulatedRating(h);

    if(count != 0) {
      h.setRating(finalRating);
    }
    else {
      h.setRating(0);
      hospitalService.initAccumulatedRating(hno);
    }

    hospitalService.rate(h);

    if(loginUser.getRole() == 1) {
      return "redirect:../hospital/detail?no=" + hno;
    }
    else {
      return "redirect:../admin/reviewlist";
    }
  }
}






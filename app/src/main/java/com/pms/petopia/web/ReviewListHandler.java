package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Review;
import com.pms.petopia.service.ReviewService;

@Controller
public class ReviewListHandler{

  ReviewService reviewService;

  public ReviewListHandler(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @RequestMapping("/review/list")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Hospital h = new Hospital();

    h.setNo(Integer.parseInt(request.getParameter("no")));

    List<Review> list = reviewService.list(h.getNo());
    request.setAttribute("hospital", h);
    request.setAttribute("list", list);

    return "/jsp/review/list.jsp";

  }
}







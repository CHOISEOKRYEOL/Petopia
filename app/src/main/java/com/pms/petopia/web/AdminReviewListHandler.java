package com.pms.petopia.web;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Review;
import com.pms.petopia.service.ReviewService;

@Controller
public class AdminReviewListHandler {

  ReviewService reviewService;

  public AdminReviewListHandler(ReviewService reviewService) {
    this.reviewService = reviewService;
  }

  @RequestMapping("/admin/reviewlist")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {


    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if(loginUser.getRole() == 1) {

      return "/jsp/admin/access_fail.jsp";
    }
    else {
      List<Review> list = null;

      String item = request.getParameter("item");
      String keyword = request.getParameter("keyword");

      if(item != null && keyword != null && keyword.length() > 0) {
        list = reviewService.search(item, keyword);
      }
      else {
        list = reviewService.listAll();
      }

      request.setAttribute("list", list);

      return "/jsp/admin/review_list.jsp";
    }
  }
}

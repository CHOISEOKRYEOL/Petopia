package com.pms.petopia.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Review;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.ReviewService;

@SuppressWarnings("serial")
@WebServlet("/review/delete")
public class ReviewDeleteHandler extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    ReviewService reviewService = (ReviewService) request.getServletContext().getAttribute("reviewService");
    HospitalService hospitalService = (HospitalService) request.getServletContext().getAttribute("hospitalService");
    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    int no = Integer.parseInt(request.getParameter("no"));
    int hno = Integer.parseInt(request.getParameter("hno"));

    try {

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
        response.sendRedirect("../hospital/detail?no=" + hno);
      }
      else {
        response.sendRedirect("../admin/reviewlist");
      }
    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}







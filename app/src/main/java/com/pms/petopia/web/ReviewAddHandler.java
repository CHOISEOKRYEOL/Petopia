package com.pms.petopia.web;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Review;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.ReviewService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
public class ReviewAddHandler {

  ReviewService reviewService;
  HospitalService hospitalService;

  public ReviewAddHandler(ReviewService reviewService, HospitalService hospitalService) {
    this.reviewService = reviewService;
    this.hospitalService = hospitalService;
  }


  @RequestMapping("/review/add")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");

    if(request.getMethod().equals("GET")) {

      int num = Integer.parseInt(request.getParameter("num"));
      request.setAttribute("num", num);
      return "/jsp/review/review_form.jsp";
    }

    Review r = new Review();

    r.setServiceRating(Integer.parseInt(request.getParameter("star-input")));
    r.setCleanlinessRating(Integer.parseInt(request.getParameter("second-star-input")));
    r.setCostRating(Integer.parseInt(request.getParameter("third-star-input")));
    r.setComment(request.getParameter("comment"));

    System.out.println(r);

    Part photoPart = request.getPart("photo");

    if(photoPart.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      photoPart.write(uploadDir + "/" + filename);
      r.setPhoto(filename);


      Thumbnails.of(uploadDir + "/" + filename)
      .size(100, 100)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_100x100";
        }
      });
    }

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    r.setWriter(loginUser);

    Hospital h = new Hospital();
    h.setNo(Integer.parseInt(request.getParameter("num")));
    r.setHospital(h);

    reviewService.add(r);

    String temp = reviewService.countReview(h.getNo());
    int count = Integer.parseInt(temp);

    float average = (r.getServiceRating() + r.getCleanlinessRating() + r.getCostRating()) / 3.0F;
    h.setAccumulatedRating(average);
    hospitalService.setAccumulatedRating(h);

    Hospital rating = hospitalService.getRating(h.getNo());
    float finalRating = 0;
    if(count > 1) {
      float original = rating.getAccumulatedRating();
      finalRating = original / (count * 1.0F);
    }
    else {
      finalRating = average * 1.0F;
    }
    rating.setRating(finalRating);

    hospitalService.rate(rating);

    return "redirect:../hospital/detail?no=" + h.getNo();

  }
}







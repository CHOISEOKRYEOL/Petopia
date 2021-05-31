package com.pms.petopia.web;

import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/review")
public class ReviewController {

  ReviewService reviewService;
  HospitalService hospitalService;

  public ReviewController(ReviewService reviewService, HospitalService hospitalService) {
    this.reviewService = reviewService;
    this.hospitalService = hospitalService;
  }

  @GetMapping("review_form")
  public void form(HttpServletRequest request, Model model) throws Exception {

    int num = Integer.parseInt(request.getParameter("num"));
    model.addAttribute("num", num);
  }

  @PostMapping("add")
  public String add(HttpServletRequest request, HttpSession session)
      throws Exception {

    String uploadDir = request.getServletContext().getRealPath("/upload");

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

    Member loginUser = (Member) session.getAttribute("loginUser");
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


  @RequestMapping("delete")
  public String delete(HttpServletRequest request, HttpSession session)
      throws Exception {
    Member loginUser = (Member) session.getAttribute("loginUser");

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

  @GetMapping("list")
  public void list(HttpServletRequest request, Model model)
      throws Exception {

    Hospital h = new Hospital();

    h.setNo(Integer.parseInt(request.getParameter("no")));
    List<Review> list = reviewService.list(h.getNo());
    model.addAttribute("hospital", h);
    model.addAttribute("list", list);

  }










}







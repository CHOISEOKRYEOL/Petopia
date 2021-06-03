package com.pms.petopia.web;

import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Bookmark;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.BookmarkService;
import com.pms.petopia.service.HospitalService;
import com.pms.petopia.service.ReviewService;
import com.pms.petopia.service.SmallAddressService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("hospital")
public class HospitalController {

  ServletContext sc;
  HospitalService hospitalService;
  ReviewService reviewService;
  BookmarkService bookmarkService;
  SmallAddressService smallAddressService;

  public HospitalController(HospitalService hospitalService, 
      ReviewService reviewService, 
      BookmarkService bookmarkService, 
      SmallAddressService smallAddressService,
      ServletContext sc) {
    this.hospitalService = hospitalService;
    this.reviewService = reviewService;
    this.bookmarkService = bookmarkService;
    this.smallAddressService = smallAddressService;
    this.sc = sc;
  }

  @GetMapping("form")
  public void form() throws Exception {
  }

  @PostMapping("add")
  public String add(int cityNo, Hospital hospital, Part photoFile) throws Exception {
    String uploadDir = sc.getRealPath("/upload");

    if(photoFile.getSize() > 0) {
      // 파일을 선택해서 업로드 했다면,
      String filename = UUID.randomUUID().toString();
      photoFile.write(uploadDir + "/" + filename);
      hospital.setPhoto(filename);

      // 썸네일 이미지 생성
      Thumbnails.of(uploadDir + "/" + filename)
      .size(300, 300)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_300x300";
        }
      });
    }

    SmallAddress smallAddress = smallAddressService.get(cityNo);
    hospital.setSmallAddress(smallAddress);

    hospitalService.add(hospital);
    return "redirect:list";
  }

  @RequestMapping("delete")
  public String delete(int no) throws Exception {
    reviewService.deleteByAdmin(no);
    bookmarkService.deleteByAdmin(no);
    hospitalService.delete(no);

    return "../admin/hospitallist";
  }

  @GetMapping("detail")
  public String detail(int no, Model model, HttpSession session) throws Exception {

    Hospital hospital = hospitalService.get(no);


    Member loginUser = (Member) session.getAttribute("loginUser");

    Bookmark bookmark = bookmarkService.get(loginUser.getNo(), hospital.getNo());

    model.addAttribute("hospital", hospital);
    model.addAttribute("bookmark", bookmark);

    return "hospital/detail";
  }

  @GetMapping("list")
  public void list(Model model, HttpSession session)
      throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");

    List<Hospital> hospitals = hospitalService.list();
    List<SmallAddress> area = smallAddressService.list();

    if(loginUser != null) {
      List<Bookmark> book = bookmarkService.get(loginUser.getNo());
      model.addAttribute("book", book);
    }

    model.addAttribute("hospitals", hospitals);
    model.addAttribute("area", area);

  }

  /*@RequestMapping("/hospital/detail")
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
   */
  @RequestMapping("update")
  public String update(int cityNo, Hospital hospital, Part photoFile) throws Exception {
    String uploadDir = sc.getRealPath("/upload");

    if(photoFile.getSize() > 0) {
      // 파일을 선택해서 업로드 했다면,
      String filename = UUID.randomUUID().toString();
      photoFile.write(uploadDir + "/" + filename);
      hospital.setPhoto(filename);

      // 썸네일 이미지 생성
      Thumbnails.of(uploadDir + "/" + filename)
      .size(300, 300)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_300x300";
        }
      });
    }

    SmallAddress smallAddress = smallAddressService.get(cityNo);
    hospital.setSmallAddress(smallAddress);

    hospitalService.update(hospital);

    return "redirect:list";
  }
}

package com.pms.petopia.web;

import java.util.List;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
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

  HospitalService hospitalService;
  ReviewService reviewService;
  BookmarkService bookmarkService;
  SmallAddressService smallAddressService;

  public HospitalController(HospitalService hospitalService, 
      ReviewService reviewService, 
      BookmarkService bookmarkService, 
      SmallAddressService smallAddressService) {
    this.hospitalService = hospitalService;
    this.reviewService = reviewService;
    this.bookmarkService = bookmarkService;
    this.smallAddressService = smallAddressService;
  }

  @RequestMapping("add")
  public String form(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    if(request.getMethod().equals("GET")) {
      return "/jsp/hospital/form.jsp";
    }

    Hospital hospital = new Hospital();
    hospital.setName(request.getParameter("name"));
    hospital.setTel(request.getParameter("tel"));
    hospital.setAddress(request.getParameter("address"));
    hospital.setStartTime(Integer.valueOf(request.getParameter("startTime")));
    hospital.setEndTime(Integer.valueOf(request.getParameter("endTime")));
    hospital.setParking(Integer.valueOf(request.getParameter("parking")));
    hospital.setVeterinarian(Integer.valueOf(request.getParameter("vet")));

    Part photoPart = request.getPart("photo");

    String filename = UUID.randomUUID().toString();
    String saveFilePath = request.getServletContext().getRealPath("/upload/" + filename);

    photoPart.write(saveFilePath);

    if (photoPart.getSize() > 0) {
      // 파일을 선택해서 업로드 했다면,
      String filename = UUID.randomUUID().toString();
      photoPart.write(this.uploadDir + "/" + filename);
      hospital.setPhoto(filename);

      // 썸네일 이미지 생성
      Thumbnails.of(this.uploadDir + "/" + filename)
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

    SmallAddress smallAddress = new SmallAddress();
    smallAddress.setNo(Integer.parseInt(request.getParameter("cno")));
    hospital.setSmallAddress(smallAddress);

    hospitalService.add(hospital);

    return "redirect:list";

  }

  @RequestMapping("delete")
  public String delete(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    reviewService.deleteByAdmin(no);
    bookmarkService.deleteByAdmin(no);
    hospitalService.delete(no);

    return "../admin/hospitallist";

  }

  @RequestMapping("detail")
  public String detail(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");

    int no = Integer.parseInt(request.getParameter("no"));

    Hospital hospital = hospitalService.get(no);

    Bookmark bookmark = bookmarkService.get(loginUser.getNo(), hospital.getNo());

    request.setAttribute("bookmark", bookmark);
    request.setAttribute("hospital", hospital);

    return "/jsp/hospital/detail.jsp";
  }

  @RequestMapping("list")
  public String list(HttpServletRequest request, HttpServletResponse response)
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

  //@RequestMapping("/hospital/detail")
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

  @RequestMapping("update")
  public String update(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));

    Hospital oldHospital = hospitalService.get(no);
    if (oldHospital == null) {
      throw new Exception("해당 번호의 병원이 없습니다.");
    }

    Hospital hospital = new Hospital();
    hospital.setNo(oldHospital.getNo());
    hospital.setName(request.getParameter("name"));
    hospital.setTel(request.getParameter("tel"));
    hospital.setAddress(request.getParameter("address"));
    hospital.setStartTime(Integer.valueOf(request.getParameter("startTime")));
    hospital.setEndTime(Integer.valueOf(request.getParameter("endTime")));
    hospital.setParking(Integer.valueOf(request.getParameter("parking")));
    hospital.setVeterinarian(Integer.valueOf(request.getParameter("vet")));

    Part photoPart = request.getPart("photo");
    if (photoPart.getSize() > 0) {
      String filename = UUID.randomUUID().toString();
      photoPart.write(this.uploadDir + "/" + filename);
      hospital.setPhoto(filename);

      // 썸네일 이미지 생성
      Thumbnails.of(this.uploadDir + "/" + filename)
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

    SmallAddress smallAddress = new SmallAddress();
    smallAddress.setNo(Integer.parseInt(request.getParameter("cno")));
    hospital.setSmallAddress(smallAddress);

    hospitalService.update(hospital);

    return "redirect:list";

  }

}

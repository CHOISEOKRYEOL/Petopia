package com.pms.petopia.web;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.HospitalService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
public class HospitalAddHandler {

  HospitalService hospitalService;

  public HospitalAddHandler(HospitalService hospitalService) {
    this.hospitalService = hospitalService;
  }


  @RequestMapping("/hospital/add")
  public String execute(HttpServletRequest request, HttpServletResponse response)
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

    //    if (photoPart.getSize() > 0) {
    //      // 파일을 선택해서 업로드 했다면,
    //      String filename = UUID.randomUUID().toString();
    //      photoPart.write(this.uploadDir + "/" + filename);
    //      hospital.setPhoto(filename);
    //
    //      // 썸네일 이미지 생성
    //      Thumbnails.of(this.uploadDir + "/" + filename)
    //      .size(300, 300)
    //      .outputFormat("jpg")
    //      .crop(Positions.CENTER)
    //      .toFiles(new Rename() {
    //        @Override
    //        public String apply(String name, ThumbnailParameter param) {
    //          return name + "_300x300";
    //        }
    //      });
    //    }

    SmallAddress smallAddress = new SmallAddress();
    smallAddress.setNo(Integer.parseInt(request.getParameter("cno")));
    hospital.setSmallAddress(smallAddress);

    hospitalService.add(hospital);

    return "redirect:list";

  }

  private void generatePhotoThumbnail(String saveFilePath) {
    try {
      Thumbnails.of(saveFilePath)
      .size(30, 30)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_30x30";
        }
      });

      Thumbnails.of(saveFilePath)
      .size(120, 120)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_300x300";
        }
      });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

}

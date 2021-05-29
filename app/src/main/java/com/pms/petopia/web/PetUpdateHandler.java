package com.pms.petopia.web;

import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.service.PetService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
public class PetUpdateHandler {

  PetService petService;

  public PetUpdateHandler(PetService petService) {
    this.petService = petService;
  }


  @RequestMapping("/pet/update")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Pet p = new Pet();
    p.setNo(Integer.parseInt(request.getParameter("no")));
    p.setName(request.getParameter("name"));

    Part photoPart = request.getPart("photo");
    if (photoPart.getSize() > 0) {
      // 파일을 선택해서 업로드 했다면,
      String filename = UUID.randomUUID().toString();
      photoPart.write(this.uploadDir + "/" + filename);
      p.setPhoto(filename);

      // 썸네일 이미지 생성
      Thumbnails.of(this.uploadDir + "/" + filename)
      .size(30, 30)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_30x30";
        }
      });

      Thumbnails.of(this.uploadDir + "/" + filename)
      .size(80, 80)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_80x80";
        }
      });
    }

    petService.update(p);
    request.setAttribute("pet", p);

    return "/jsp/pet/update.jsp";
    //      response.setHeader("Refresh", "1;url=list");

  }
}







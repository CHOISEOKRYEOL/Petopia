package com.pms.petopia.web;

import java.sql.Date;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.domain.Type;
import com.pms.petopia.service.PetService;

@Controller
public class PetAddHandler {

  PetService petService;

  public PetAddHandler(PetService petService) {
    this.petService = petService;
  }

  @RequestMapping("/pet/add")
  public String execute(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    if(request.getMethod().equals("GET")) {
      return "/jsp/pet/form.jsp";
    }

    Pet p = new Pet();
    p.setName(request.getParameter("name"));
    p.setAge(Integer.parseInt(request.getParameter("age")));
    p.setBirthDay(Date.valueOf(request.getParameter(("birthDay"))));
    p.setGender(Integer.parseInt(request.getParameter("gender")));

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    p.setOwner(loginUser);

    Type t = new Type();
    t.setNo(Integer.parseInt(request.getParameter("type")));
    p.setType(t);

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

    petService.add(p);

    return "list";
    // 체크
    //    response.setHeader("Refresh", "1;url=list");


  }
}
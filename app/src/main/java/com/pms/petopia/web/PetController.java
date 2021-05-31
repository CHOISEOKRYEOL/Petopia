package com.pms.petopia.web;

import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.domain.Species;
import com.pms.petopia.domain.Type;
import com.pms.petopia.service.PetService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/pet")
public class PetController {

  ServletContext sc;
  PetService petService;

  public PetController(PetService petService, ServletContext sc, Species s, Type t) {
    this.petService = petService;
    this.sc = sc;
  }

  @GetMapping("form")
  public void form() throws Exception {
  }

  @PostMapping("add")
  public String add(Pet p, Part photoFile)
      throws Exception {

    String uploadDir = sc.getRealPath("/upload");


    if (photoFile.getSize() > 0) {
      // 파일을 선택해서 업로드 했다면,
      String filename = UUID.randomUUID().toString();
      photoFile.write(uploadDir + "/" + filename);
      p.setPhoto(filename);

      // 썸네일 이미지 생성
      Thumbnails.of(uploadDir + "/" + filename)
      .size(30, 30)
      .outputFormat("jpg")
      .crop(Positions.CENTER)
      .toFiles(new Rename() {
        @Override
        public String apply(String name, ThumbnailParameter param) {
          return name + "_30x30";
        }
      });

      Thumbnails.of(uploadDir + "/" + filename)
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

  @GetMapping("delete")
  public String delete(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));
    petService.delete(no);

    return "/jsp/pet/delete.jsp";
    //    response.setHeader("Refresh", "1;url=list");

  }


  @RequestMapping("detail")
  public String detail(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));


    Pet pet = petService.get(no);
    request.setAttribute("pet",pet);
    //      request.getSession().setAttribute("petInfo", pet);

    return "/jsp/pet/detail.jsp";

  }

  @RequestMapping("list")
  public String list(HttpServletRequest request, HttpServletResponse response)
      throws Exception {


    String keyword = request.getParameter("keyword");
    List<Pet> pets = null;
    if (keyword != null && keyword.length() > 0) {
      pets = petService.search(keyword);
    } else {
      pets = petService.list();
    }

    HttpSession session = request.getSession();
    session.setAttribute("petNo", request.getParameter("petNo"));

    //    int leader = Integer.parseInt(request.getParameter("leader"));
    //    if(leader == 1 ) {
    //      
    //    }

    request.setAttribute("list", pets);
    return "/jsp/pet/list.jsp";

  }


  @RequestMapping("update")
  public String update(HttpServletRequest request, HttpServletResponse response)
      throws Exception {

    Pet p = new Pet();
    p.setNo(Integer.parseInt(request.getParameter("no")));
    p.setName(request.getParameter("name"));

    Part photoPart = request.getPart("photo");
    //    if (photoPart.getSize() > 0) {
    //      // 파일을 선택해서 업로드 했다면,
    //      String filename = UUID.randomUUID().toString();
    //      photoPart.write(this.uploadDir + "/" + filename);
    //      p.setPhoto(filename);
    //
    //      // 썸네일 이미지 생성
    //      Thumbnails.of(this.uploadDir + "/" + filename)
    //      .size(30, 30)
    //      .outputFormat("jpg")
    //      .crop(Positions.CENTER)
    //      .toFiles(new Rename() {
    //        @Override
    //        public String apply(String name, ThumbnailParameter param) {
    //          return name + "_30x30";
    //        }
    //      });
    //
    //      Thumbnails.of(this.uploadDir + "/" + filename)
    //      .size(80, 80)
    //      .outputFormat("jpg")
    //      .crop(Positions.CENTER)
    //      .toFiles(new Rename() {
    //        @Override
    //        public String apply(String name, ThumbnailParameter param) {
    //          return name + "_80x80";
    //        }
    //      });
    //    }

    petService.update(p);
    request.setAttribute("pet", p);

    return "/jsp/pet/update.jsp";
    //      response.setHeader("Refresh", "1;url=list");

  }










}
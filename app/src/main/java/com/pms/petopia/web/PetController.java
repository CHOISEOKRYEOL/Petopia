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
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.service.MemberService;
import com.pms.petopia.service.PetService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/pet/")
public class PetController {

  ServletContext sc;
  PetService petService;
  MemberService memberService;

  public PetController(PetService petService, ServletContext sc, MemberService memberService) {
    this.petService = petService;
    this.sc = sc;
    this.memberService = memberService;
  }

  @GetMapping("form")
  public void form() throws Exception {
  }

  @PostMapping("add")
  public String add(Pet p, Part photoFile,  HttpSession session) throws Exception {

    Member loginUser = (Member) session.getAttribute("loginUser");
    p.setOwner(loginUser);

    //    ArrayList<Member> memberList = new ArrayList<>();
    //    if (memberNos != null) {
    //      for (int memberNo : memberNos) {
    //        Member m = new Member();
    //        m.setNo(memberNo);
    //        memberList.add(m);
    //      }
    //    }
    //    p.setMembers(memberList);

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
    return "redirect:list";
  }

  @GetMapping("delete")
  public String delete(int no) throws Exception {

    Pet p = petService.get(no);

    petService.delete(no);

    if (p == null) {
      throw new Exception("해당 번호의 펫이 없습니다.");
    }

    return "redirect:list";

  }

  @GetMapping("detail")
  public void detail(int no, Model model) throws Exception {

    Pet p = petService.get(no);
    model.addAttribute("pet",p);

  }

  @GetMapping("list")
  public void list(String keyword, Model model, HttpSession session) throws Exception {

    List<Pet> pets = petService.list();

    model.addAttribute("list", pets);
  }

  @PostMapping("update")
  public String update(Pet p, Part photoFile) throws Exception {

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

    petService.update(p);

    return "redirect:list";

  }
}
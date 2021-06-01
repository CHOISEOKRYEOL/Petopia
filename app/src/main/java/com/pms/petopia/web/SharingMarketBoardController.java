package com.pms.petopia.web;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.domain.SharingMarketBoardPhoto;
import com.pms.petopia.service.SharingMarketBoardCategoryService;
import com.pms.petopia.service.SharingMarketBoardCommentService;
import com.pms.petopia.service.SharingMarketBoardPhotoService;
import com.pms.petopia.service.SharingMarketBoardService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@Controller
@RequestMapping("/sharingmarketboard/")
public class SharingMarketBoardController {

  SharingMarketBoardCategoryService sharingMarketBoardCategoryService;
  SharingMarketBoardService sharingMarketBoardService;
  SharingMarketBoardPhotoService sharingMarketBoardPhotoService;
  SharingMarketBoardCommentService sharingMarketBoardCommentService;
  ServletContext sc;

  public SharingMarketBoardController(SharingMarketBoardCategoryService sharingMarketBoardCategoryService, SharingMarketBoardService sharingMarketBoardService,
      SharingMarketBoardPhotoService sharingMarketBoardPhotoService,  SharingMarketBoardCommentService sharingMarketBoardCommentService,
      ServletContext sc) {
    this.sharingMarketBoardCategoryService = sharingMarketBoardCategoryService;
    this.sharingMarketBoardService = sharingMarketBoardService;
    this.sharingMarketBoardPhotoService = sharingMarketBoardPhotoService;
    this.sharingMarketBoardCommentService = sharingMarketBoardCommentService;
    this.sc = sc;

  }

  @GetMapping("form")
  public String form(Model model) throws Exception {
    model.addAttribute("catList", sharingMarketBoardCategoryService.list());
    return "/sharingmarketboard/form";
  }

  @PostMapping("add")
  public String add(HttpServletRequest request, HttpSession session) throws Exception {

    String uploadDir = sc.getRealPath("/upload");
    SharingMarketBoard smb = new SharingMarketBoard();
    int cat = Integer.parseInt(request.getParameter("category"));
    smb.setCategory(sharingMarketBoardCategoryService.get(cat));
    smb.setTitle(request.getParameter("title"));
    smb.setContent(request.getParameter("content"));

    List<SharingMarketBoardPhoto> phots = new ArrayList<>();

    Member loginUser = (Member)session.getAttribute("loginUser");
    smb.setWriter(loginUser);

    sharingMarketBoardService.add(smb); 
    Collection<Part> photoParts = request.getParts();
    for (Part p : photoParts) {
      if(!p.getName().equals("photo")) {
        continue;
      }

      if (p.getSize() > 0) {  
        // 파일을 선택해서 업로드 했다면,
        String filename = UUID.randomUUID().toString();
        p.write(uploadDir + "/" + filename);
        SharingMarketBoardPhoto phot = new SharingMarketBoardPhoto();
        phot.setPhoto(filename);
        System.out.println(phot.getPhoto());
        phots.add(phot);

        if(phots != null) {
          phot.setSharingmarketboard(smb);
          sharingMarketBoardPhotoService.add(phot);
        }

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
    }
    return "redirect:list";
  }

  @GetMapping("update")
  public String update(int no, Model model) throws Exception {

    model.addAttribute("smb", sharingMarketBoardService.get(no));
    model.addAttribute("catList", sharingMarketBoardCategoryService.list());
    return "/sharingmarketboard/update";
  }

  @PostMapping("update")
  public String update(HttpServletRequest request, HttpSession session) throws Exception {

    String uploadDir = sc.getRealPath("/upload");
    int no = Integer.parseInt(request.getParameter("no"));
    SharingMarketBoard oldBoard = sharingMarketBoardService.get(no);
    if (oldBoard == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    } 

    Member loginUser = (Member) session.getAttribute("loginUser");
    if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("변경 권한이 없습니다!");
    }
    SharingMarketBoard smbBoard = new SharingMarketBoard();
    smbBoard.setNo(oldBoard.getNo());
    int categoryNo = Integer.parseInt(request.getParameter("category"));
    smbBoard.setCategory(sharingMarketBoardCategoryService.get(categoryNo));
    smbBoard.setTitle(request.getParameter("title"));
    smbBoard.setContent(request.getParameter("content"));

    sharingMarketBoardService.update(smbBoard);
    List<SharingMarketBoardPhoto> phots = new ArrayList<>();
    Collection<Part> photoParts = request.getParts();
    for (Part p : photoParts) {
      if(!p.getName().equals("photo")) {
        continue;
      }

      if (p.getSize() > 0) {  
        // 파일을 선택해서 업로드 했다면,
        String filename = UUID.randomUUID().toString();
        p.write(uploadDir + "/" + filename);
        SharingMarketBoardPhoto phot = new SharingMarketBoardPhoto();
        phot.setPhoto(filename);
        System.out.println(phot.getPhoto());
        phots.add(phot);

        if(phots != null) {
          phot.setSharingmarketboard(smbBoard);
          sharingMarketBoardPhotoService.add(phot);
        }

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
    }

    String webAdress= String.format("../sharingmarketboard/detail?no=%d",oldBoard.getNo());
    return "redirect:" + webAdress;

  }

  @RequestMapping("delete")
  public String delete(HttpServletRequest request, HttpServletResponse response) throws Exception {

    int no = Integer.parseInt(request.getParameter("no"));
    SharingMarketBoard oldBoard = sharingMarketBoardService.get(no);
    if (oldBoard == null) {
      throw new Exception("해당 번호의 게시글이 없습니다.");
    }

    Member loginUser = (Member) request.getSession().getAttribute("loginUser");
    if (oldBoard.getWriter().getNo() != loginUser.getNo()) {
      throw new Exception("삭제 권한이 없습니다!");
    }


    if (sharingMarketBoardCommentService.count(no).equals("0")) {
      sharingMarketBoardService.delete(no);
      sharingMarketBoardPhotoService.delete(no);
    } else {
      sharingMarketBoardService.deleteAll(no);
      sharingMarketBoardPhotoService.delete(no);
    }

    return "redirect:list";

  }

  @GetMapping("detail")
  public void detail(int no, Model model) throws Exception {

    model.addAttribute("smb", sharingMarketBoardService.get(no));
    model.addAttribute("catList", sharingMarketBoardCategoryService.list());
    model.addAttribute("comtList", sharingMarketBoardCommentService.get(no));
    model.addAttribute("photList", sharingMarketBoardPhotoService.list(no));

    //    return"/sharingmarketboard/detail";
  }

  @GetMapping("list")
  public String list(HttpServletRequest request, Model model) throws Exception {

    //    String item = request.getParameter("item");
    //    String keyword = request.getParameter("keyword");
    String category = request.getParameter("category");

    int categoryNo = 0;
    if (category != null) {
      categoryNo = Integer.parseInt(category);
    }
    List<SharingMarketBoardPhoto> photoList = new ArrayList<>();
    List<SharingMarketBoard> smBoards = null;
    if (categoryNo == 0) {
      smBoards = sharingMarketBoardService.list();

    } else {
      smBoards = sharingMarketBoardService.getCategory(categoryNo);
    }

    for(SharingMarketBoard smb : smBoards) {
      SharingMarketBoardPhoto phot = new SharingMarketBoardPhoto();
      phot= sharingMarketBoardPhotoService.listMin(smb.getNo());
      photoList.add(phot);
    }


    model.addAttribute("photList", photoList);
    model.addAttribute("category", category);
    model.addAttribute("catList", sharingMarketBoardCategoryService.list());
    model.addAttribute("smBoards", smBoards);

    return "/sharingmarketboard/list";

  }



}




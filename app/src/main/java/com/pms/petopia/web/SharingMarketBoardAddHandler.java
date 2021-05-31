package com.pms.petopia.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import com.pms.petopia.domain.Member;
import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.domain.SharingMarketBoardPhoto;
import com.pms.petopia.service.SharingMarketBoardCategoryService;
import com.pms.petopia.service.SharingMarketBoardPhotoService;
import com.pms.petopia.service.SharingMarketBoardService;
import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/sharingmarketboard/add")
public class SharingMarketBoardAddHandler extends HttpServlet {

  private String uploadDir;

  @Override
  public void init() throws ServletException {
    this.uploadDir = this.getServletContext().getRealPath("/upload");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    SharingMarketBoardCategoryService sharingMarketBoardCategoryService = (SharingMarketBoardCategoryService) request.getServletContext().getAttribute("sharingMarketBoardCategoryService");

    try {
      request.setAttribute("catList", sharingMarketBoardCategoryService.list());
      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/sharingmarketboard/form.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    SharingMarketBoardService sharingMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("sharingMarketBoardService");
    SharingMarketBoardCategoryService sharingMarketBoardCategoryService = (SharingMarketBoardCategoryService) request.getServletContext().getAttribute("sharingMarketBoardCategoryService");
    SharingMarketBoardPhotoService sharingMarketBoardPhotoService = (SharingMarketBoardPhotoService) request.getServletContext().getAttribute("sharingMarketBoardPhotoService");

    SharingMarketBoard smb = new SharingMarketBoard();
    List<SharingMarketBoardPhoto> phots = new ArrayList<>();

    try {

      int cat = Integer.parseInt(request.getParameter("category"));
      smb.setCategory(sharingMarketBoardCategoryService.get(cat));
      smb.setTitle(request.getParameter("title"));
      smb.setContent(request.getParameter("content"));

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
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
          p.write(this.uploadDir + "/" + filename);
          SharingMarketBoardPhoto phot = new SharingMarketBoardPhoto();
          phot.setPhoto(filename);
          System.out.println(phot.getPhoto());
          phots.add(phot);

          if(phots != null) {
            phot.setSharingmarketboard(smb);
            sharingMarketBoardPhotoService.add(phot);
          }

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
      }
      response.sendRedirect("../sharingmarketboard/detail?no="+smb.getNo());
    }catch (Exception e) {
      throw new ServletException(e);
    }


  }
}




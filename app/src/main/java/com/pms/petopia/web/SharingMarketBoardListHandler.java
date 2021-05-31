package com.pms.petopia.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.domain.SharingMarketBoardPhoto;
import com.pms.petopia.service.SharingMarketBoardCategoryService;
import com.pms.petopia.service.SharingMarketBoardPhotoService;
import com.pms.petopia.service.SharingMarketBoardService;

@SuppressWarnings("serial")
@WebServlet("/sharingmarketboard/list")
public class SharingMarketBoardListHandler extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    SharingMarketBoardService sharingMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("sharingMarketBoardService");
    SharingMarketBoardCategoryService sharingMarketBoardCategoryService = (SharingMarketBoardCategoryService) request.getServletContext().getAttribute("sharingMarketBoardCategoryService");
    SharingMarketBoardPhotoService sharingMarketBoardPhotoService = (SharingMarketBoardPhotoService) request.getServletContext().getAttribute("sharingMarketBoardPhotoService");

    try {
      String item = request.getParameter("item");
      String keyword = request.getParameter("keyword");
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
        //        System.out.println(photoList);
      }


      request.setAttribute("photList", photoList);
      request.setAttribute("categoryNo", categoryNo);
      request.setAttribute("catList", sharingMarketBoardCategoryService.list());
      //      request.setAttribute("photList", sharingMarketBoardPhotoService.listAll());
      request.setAttribute("smBoards", smBoards);

      response.setContentType("text/html;charset=UTF-8");
      request.getRequestDispatcher("/jsp/sharingmarketboard/list.jsp").include(request, response);

    } catch (Exception e) {
      throw new ServletException(e);
    }
  }
}

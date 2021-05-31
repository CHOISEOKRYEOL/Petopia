package com.pms.petopia.web;

import java.io.IOException;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.domain.SharingMarketBoardPhoto;
import com.pms.petopia.service.SharingMarketBoardPhotoService;
import com.pms.petopia.service.SharingMarketBoardService;

import net.coobird.thumbnailator.ThumbnailParameter;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.name.Rename;

@SuppressWarnings("serial")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10)
@WebServlet("/sharingmarketboardphoto/add")
public class SharingMarketBoardPhotoAddHandler extends HttpServlet {
	
	  private String uploadDir;

	  @Override
	  public void init() throws ServletException {
	    this.uploadDir = this.getServletContext().getRealPath("/upload");
	  }

	  @Override
	  protected void doGet(HttpServletRequest request, HttpServletResponse response)
	      throws ServletException, IOException {
		    response.setContentType("text/html;charset=UTF-8");
		    request.getRequestDispatcher("/jsp/sharingmarketboard/form.jsp").include(request, response);
	  }
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SharingMarketBoardPhotoService sharingMarketBoardPhotoService = (SharingMarketBoardPhotoService) request.getServletContext().getAttribute("sharingMarketBoardPhotoService");
		SharingMarketBoardService sharingMarketBoardService = (SharingMarketBoardService) request.getServletContext().getAttribute("sharingMarketBoardService");
		
		try {
			
			SharingMarketBoardPhoto phot = new SharingMarketBoardPhoto();
			int boardNo = Integer.parseInt(request.getParameter("no"));
		    SharingMarketBoard oldBoard = sharingMarketBoardService.get(boardNo);
			phot.setSharingmarketboard(oldBoard);
			
			Collection<Part> photoParts = request.getParts();
			for (Part p : photoParts) {
				if(!p.getName().equals("photo")) {
					continue;
				}
				
				 if (p.getSize() > 0) {
				        // 파일을 선택해서 업로드 했다면,
				        String filename = UUID.randomUUID().toString();
				        p.write(this.uploadDir + "/" + filename);
				        phot.setPhoto(filename);

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
				 
				 sharingMarketBoardPhotoService.add(phot);
			      response.sendRedirect("../sharingmarketboard/detail?no="+oldBoard.getNo());
			    
			}
		      }catch (Exception e) {
			throw new ServletException(e);
		    }

}
}





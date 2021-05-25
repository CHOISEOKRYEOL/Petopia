package com.pms.petopia.service;

import java.util.List;

import com.pms.petopia.domain.SharingMarketBoardPhoto;

public interface SharingMarketBoardPhotoService {
	
	  int add(SharingMarketBoardPhoto phot) throws Exception;
	
	  int update(SharingMarketBoardPhoto phot) throws Exception;

	  List<SharingMarketBoardPhoto> list(int boardNo) throws Exception;

	  int delete(int no) throws Exception;

	  SharingMarketBoardPhoto get(int no) throws Exception;

}

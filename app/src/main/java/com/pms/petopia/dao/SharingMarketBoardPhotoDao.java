package com.pms.petopia.dao;

import java.util.List;

import com.pms.petopia.domain.SharingMarketBoardPhoto;

public interface SharingMarketBoardPhotoDao {
	
	  int insert(SharingMarketBoardPhoto phot) throws Exception;
		
	  int update(SharingMarketBoardPhoto phot) throws Exception;

	  List<SharingMarketBoardPhoto> findAll(int boardNo) throws Exception;

	  int delete(int no) throws Exception;

	  SharingMarketBoardPhoto findByNo(int no) throws Exception;
	  
}

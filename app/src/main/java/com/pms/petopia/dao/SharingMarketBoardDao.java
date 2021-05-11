package com.pms.petopia.dao;

import java.util.List;

import com.pms.petopia.domain.SharingMarketBoard;

public interface SharingMarketBoardDao {
	
	  int insert(SharingMarketBoard sharingMarketBoard) throws Exception;
	
	  List<SharingMarketBoard> findByKeyword(String keyword) throws Exception;

	  SharingMarketBoard findByNo(int no) throws Exception;

	  int update(SharingMarketBoard sharingMarketBoard) throws Exception;

	  int updateViewCount(int no) throws Exception;

	  int delete(int no) throws Exception;
	  
	  List<SharingMarketBoard> findAll() throws Exception;
  
}

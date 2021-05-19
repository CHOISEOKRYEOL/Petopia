package com.pms.petopia.dao;

import java.util.List;
import java.util.Map;

import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.domain.SharingMarketBoardCategory;

public interface SharingMarketBoardDao {
	
	  int insert(SharingMarketBoard sharingMarketBoard) throws Exception;
	
	  List<SharingMarketBoard> findByKeyword(Map<String,Object> params) throws Exception;
	  
	  List<SharingMarketBoard> findAll() throws Exception;

	  SharingMarketBoard findByNo(int no) throws Exception;
	  
	  List<SharingMarketBoard> findCategory(int categoryNo) throws Exception;

	  int update(SharingMarketBoard sharingMarketBoard) throws Exception;

	  int updateViewCount(int no) throws Exception;

	  int delete(int no) throws Exception;
  
}

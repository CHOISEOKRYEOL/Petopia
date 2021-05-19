package com.pms.petopia.dao;

import java.util.List;

import com.pms.petopia.domain.SharingMarketBoardCategory;

public interface SharingMarketBoardCategoryDao {
	
	  SharingMarketBoardCategory findByNo(int no) throws Exception;
	  List<SharingMarketBoardCategory> findAll() throws Exception;
	  int insert(SharingMarketBoardCategory c) throws Exception;
  
}

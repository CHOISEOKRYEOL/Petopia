package com.pms.petopia.dao;

import java.util.List;

import com.pms.petopia.domain.SharingMarketBoard;

public interface SharingMarketBoardCategoryDao {
	
	  SharingMarketBoard findByNo(int no) throws Exception;
	  List<SharingMarketBoard> findAll() throws Exception;
  
}

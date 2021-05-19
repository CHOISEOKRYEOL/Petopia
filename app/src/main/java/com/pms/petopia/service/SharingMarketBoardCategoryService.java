package com.pms.petopia.service;

import java.util.List;

import com.pms.petopia.domain.SharingMarketBoardCategory;

public interface SharingMarketBoardCategoryService {

	List<SharingMarketBoardCategory> list() throws Exception;
	SharingMarketBoardCategory get(int no) throws Exception;
	int add(SharingMarketBoardCategory c)throws Exception;
}

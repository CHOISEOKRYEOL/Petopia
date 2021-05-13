package com.pms.petopia.service;

import java.util.List;

import com.pms.petopia.domain.SharingMarketBoard;

public interface SharingMarketBoardCategoryService {

	List<SharingMarketBoard> list() throws Exception;
	SharingMarketBoard get(int no) throws Exception;
}

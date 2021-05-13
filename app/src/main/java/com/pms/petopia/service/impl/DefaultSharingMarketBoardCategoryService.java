package com.pms.petopia.service.impl;

import java.util.List;

import com.pms.petopia.dao.SharingMarketBoardCategoryDao;
import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.service.SharingMarketBoardCategoryService;

public class DefaultSharingMarketBoardCategoryService implements SharingMarketBoardCategoryService{

	SharingMarketBoardCategoryDao sharingMarketBoardCategoryDao;
	
	@Override
	public SharingMarketBoard get(int no) throws Exception {
		SharingMarketBoard smBoard = sharingMarketBoardCategoryDao.findByNo(no);
	    if (smBoard != null) {
	    	sharingMarketBoardCategoryDao.findByNo(no);
	    }
	    return smBoard; 
	}

	@Override
	public List<SharingMarketBoard> list() throws Exception {
		return sharingMarketBoardCategoryDao.findAll();
	}
	


}

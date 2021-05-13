package com.pms.petopia.service.impl;

import java.util.HashMap;
import java.util.List;

import com.pms.petopia.dao.SharingMarketBoardDao;
import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.service.SharingMarketBoardService;

public class DefaultSharingMarketBoardService implements SharingMarketBoardService{

	SharingMarketBoardDao sharingMarketBoardDao;
	
	public DefaultSharingMarketBoardService(SharingMarketBoardDao sharingMarketBoardDao) {
		this.sharingMarketBoardDao = sharingMarketBoardDao;
	}

	@Override
	public int add(SharingMarketBoard sharingMarketBoard) throws Exception {
		return sharingMarketBoardDao.insert(sharingMarketBoard);
	}

	@Override
	public List<SharingMarketBoard> list() throws Exception {
		return sharingMarketBoardDao.findAll();
	}

	@Override
	public SharingMarketBoard get(int no) throws Exception {
		SharingMarketBoard smBoard = sharingMarketBoardDao.findByNo(no);
	    if (smBoard != null) {
	    	sharingMarketBoardDao.updateViewCount(no);
	    }
	    return smBoard; 
	}

	@Override
	public int update(SharingMarketBoard sharingMarketBoard) throws Exception {
		return sharingMarketBoardDao.update(sharingMarketBoard);
	}

	@Override
	public int delete(int no) throws Exception {
		return sharingMarketBoardDao.delete(no);
	}

	@Override
	public List<SharingMarketBoard> search(String keyword) throws Exception {
		return sharingMarketBoardDao.findByKeyword(keyword);
	}
	
//	@Override
//	public List<SharingMarketBoard> list(int no, String category) throws Exception {
//	    HashMap<String,Object> params = new HashMap<>();
//	    params.put("ono", no);
//	    params.put("cat_name", category);
//		return sharingMarketBoardDao.findbyCategory(params);
//	}


}

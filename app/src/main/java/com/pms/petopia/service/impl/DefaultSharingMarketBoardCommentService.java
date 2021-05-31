package com.pms.petopia.service.impl;

import java.util.List;

import com.pms.petopia.dao.SharingMarketBoardCommentDao;
import com.pms.petopia.domain.SharingMarketBoard;
import com.pms.petopia.domain.SharingMarketBoardComment;
import com.pms.petopia.service.SharingMarketBoardCommentService;

public class DefaultSharingMarketBoardCommentService implements SharingMarketBoardCommentService{

	SharingMarketBoardCommentDao sharingMarketBoardCommentDao;
	
	public DefaultSharingMarketBoardCommentService (SharingMarketBoardCommentDao sharingMarketBoardCommentDao) {
		this.sharingMarketBoardCommentDao = sharingMarketBoardCommentDao;
		}

	@Override
	public int add(SharingMarketBoardComment comt) throws Exception {
		return sharingMarketBoardCommentDao.insert(comt);
	}

	@Override
	public List<SharingMarketBoardComment> list() throws Exception {
		return sharingMarketBoardCommentDao.findAll();
	}

	@Override
	public List<SharingMarketBoardComment> get(int no) throws Exception {
		return sharingMarketBoardCommentDao.findByNo(no);
	}

	@Override
	public int update(SharingMarketBoardComment comt) throws Exception {
		return sharingMarketBoardCommentDao.update(comt);
	}

	@Override
	public int delete(int no) throws Exception {
		return sharingMarketBoardCommentDao.delete(no);
	}
	
	@Override
	public SharingMarketBoardComment getNo(int no) throws Exception {
		return sharingMarketBoardCommentDao.findBySrno(no);
	}
	
	@Override
	public String count(int smBoardNo) throws Exception {
		return sharingMarketBoardCommentDao.comtCount(smBoardNo);
	}
	
	
}

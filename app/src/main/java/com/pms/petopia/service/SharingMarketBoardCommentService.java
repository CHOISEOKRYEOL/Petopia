package com.pms.petopia.service;

import java.util.List;

import com.pms.petopia.domain.SharingMarketBoardComment;

public interface SharingMarketBoardCommentService {
	
	int add(SharingMarketBoardComment comt) throws Exception;
	
	List<SharingMarketBoardComment> list() throws Exception;
	
	List<SharingMarketBoardComment> get(int no) throws Exception;
	
	int update(SharingMarketBoardComment comt) throws Exception;
	
	int delete(int no) throws Exception;
	
	SharingMarketBoardComment getNo(int no) throws Exception;
}

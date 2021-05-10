package com.pms.petopia.service;

import java.util.List;

import com.pms.petopia.domain.Comment;

public interface CommentService {
	
	int add(Comment comt) throws Exception;
	
	List<Comment> list() throws Exception;
	
	Comment get(int no) throws Exception;
	
	int update(Comment comt) throws Exception;
	
	int delete(int no) throws Exception;
	

}

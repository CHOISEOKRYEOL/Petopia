package com.pms.petopia.service.impl;

import java.util.List;

import com.pms.petopia.dao.CommentDao;
import com.pms.petopia.domain.Comment;
import com.pms.petopia.service.CommentService;

public class DefaultCommentService implements CommentService{

	CommentDao commentDao;
	
	public DefaultCommentService (CommentDao commentDao) {
		this.commentDao = commentDao;
		}

	@Override
	public int add(Comment comt) throws Exception {
		return commentDao.insert(comt);
	}

	@Override
	public List<Comment> list() throws Exception {
		return commentDao.list();
	}

	@Override
	public Comment get(int no) throws Exception {
		return commentDao.findByNo(no);
	}

	@Override
	public int update(Comment comt) throws Exception {
		return commentDao.update(comt);
	}

	@Override
	public int delete(int no) throws Exception {
		return commentDao.delete(no);
	}
	
	
	
	
}

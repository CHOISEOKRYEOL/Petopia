package com.pms.petopia.dao;

import java.util.List;
import com.pms.petopia.domain.Comment;

public interface MyTownBoardCommentDao {

  int insert(Comment comt) throws Exception;

  int update(Comment comt) throws Exception;

  List<Comment> list(int myTownBoardNo) throws Exception;

  int delete(int no) throws Exception;

  Comment findByNo(int no) throws Exception;
}

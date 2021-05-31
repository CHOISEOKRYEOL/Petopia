package com.pms.petopia.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.pms.petopia.dao.MyTownBoardCommentDao;
import com.pms.petopia.domain.MyTownBoardComment;
import com.pms.petopia.service.MyTownBoardCommentService;
@Service
public class DefaultMyTownBoardCommentService implements MyTownBoardCommentService{

  MyTownBoardCommentDao myTownBoardCommentDao;

  public DefaultMyTownBoardCommentService (MyTownBoardCommentDao myTownBoardCommentDao) {
    this.myTownBoardCommentDao = myTownBoardCommentDao;
  }

  @Override
  public int add(MyTownBoardComment comt) throws Exception {
    return myTownBoardCommentDao.insert(comt);
  }

  @Override
  public List<MyTownBoardComment> list(int myTownBoardNo) throws Exception {
    return myTownBoardCommentDao.findByBoardNo(myTownBoardNo);
  }

  @Override
  public MyTownBoardComment get(int myTownBoardCommentNo) throws Exception {
    return myTownBoardCommentDao.findByNo(myTownBoardCommentNo);
  }

  @Override
  public int update(MyTownBoardComment comt) throws Exception {
    return myTownBoardCommentDao.update(comt);
  }

  @Override
  public int delete(int no) throws Exception {
    return myTownBoardCommentDao.delete(no);
  }

  @Override
  public String count(int myTownBoardNo) throws Exception {
    return myTownBoardCommentDao.countComment(myTownBoardNo);
  }



}

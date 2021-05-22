package com.pms.petopia.dao;
import java.util.List;
import com.pms.petopia.domain.MyTownBoardComment;

public interface MyTownBoardCommentDao {

  int insert(MyTownBoardComment comt) throws Exception;

  int update(MyTownBoardComment comt) throws Exception;

  List<MyTownBoardComment> findByBoardNo(int myTownBoardNo) throws Exception;

  MyTownBoardComment findByNo(int myTownBoardCommentNo) throws Exception;

  int delete(int no) throws Exception;

  String countComment(int myTownBoardNo) throws Exception;
}

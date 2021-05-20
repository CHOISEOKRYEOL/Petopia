package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.MyTownBoardComment;

public interface MyTownBoardCommentService {

  int add(MyTownBoardComment comt) throws Exception;

  List<MyTownBoardComment> list(int myTownBoardNo) throws Exception;

  MyTownBoardComment get(int myTownBoardCommentNo) throws Exception;

  int update(MyTownBoardComment comt) throws Exception;

  int delete(int no) throws Exception;

  String count(int myTownBoardNo) throws Exception;

}

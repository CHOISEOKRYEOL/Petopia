package com.pms.petopia.dao;

import java.util.List;
import com.pms.petopia.domain.MyTownBoard;

// BoardDao 의 규칙 정의
public interface MyTownBoardDao {

  int insert(MyTownBoard board) throws Exception;

  List<MyTownBoard> findByArea(int cityNo, int stateNo) throws Exception;

  List<MyTownBoard> findByKeyword(String keyword) throws Exception;

  MyTownBoard findByNo(int no) throws Exception;

  int update(MyTownBoard board) throws Exception;

  int updateViewCount(int no) throws Exception;

  int delete(int no) throws Exception;

}













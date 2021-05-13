package com.pms.petopia.dao;

import java.util.List;
import java.util.Map;
import com.pms.petopia.domain.MyTownBoard;

// BoardDao 의 규칙 정의
public interface MyTownBoardDao {

  int insert(MyTownBoard board) throws Exception;

  List<MyTownBoard> findByArea(Map<String,Object> params) throws Exception;

  List<MyTownBoard> findByKeyword(Map<String,Object> params) throws Exception;

  MyTownBoard findByNo(int no) throws Exception;

  int update(MyTownBoard board) throws Exception;

  int updateViewCount(int no) throws Exception;

  int delete(int no) throws Exception;

}













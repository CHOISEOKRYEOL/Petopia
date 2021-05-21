package com.pms.petopia.dao;

import java.util.List;
import com.pms.petopia.domain.Recomment;

public interface RecommentDao {

  int insert(Recomment recomment) throws Exception;

  List<Recomment> findAll() throws Exception;

  int delete(int no) throws Exception;

  String countReco(int myTownBoardNo) throws Exception;

}













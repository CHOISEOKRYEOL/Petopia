package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.Recomment;

public interface RecommentService {

  int add(Recomment recomment) throws Exception;

  List<Recomment> list() throws Exception;

  String count(int myTownBoardNo) throws Exception;

  int delete(int no) throws Exception;

}








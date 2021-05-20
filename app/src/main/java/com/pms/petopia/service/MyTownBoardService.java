package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.MyTownBoard;

public interface MyTownBoardService {

  int add(MyTownBoard board) throws Exception;

  List<MyTownBoard> listAll() throws Exception;

  List<MyTownBoard> list(int stateNo, int cityNo) throws Exception;

  MyTownBoard get(int no) throws Exception;

  int update(MyTownBoard board) throws Exception;

  int delete(int no) throws Exception;

  int deleteAll(int no) throws Exception;

  List<MyTownBoard> search(int stateNo, int cityNo, String keyword) throws Exception;
}








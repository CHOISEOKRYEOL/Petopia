package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.MyTownBoard;

public interface MyTownBoardService {

  int add(MyTownBoard board) throws Exception;

  List<MyTownBoard> list(int cityNo, int stateNo) throws Exception;

  MyTownBoard get(int no) throws Exception;

  int update(MyTownBoard board) throws Exception;

  int delete(int no) throws Exception;

  List<MyTownBoard> search(String keyword) throws Exception;
}








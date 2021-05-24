package com.pms.petopia.dao;

import java.util.List;
import com.pms.petopia.domain.Scrap;

public interface ScrapDao {

  int insert(Scrap scrap) throws Exception;

  List<Scrap> findByUser(int memberNo) throws Exception;

  Scrap findByNo(int scrapNo) throws Exception;

  String countScrap(int memberNo) throws Exception;

  int delete(int no) throws Exception;

  int updateScrap(int no) throws Exception;

}













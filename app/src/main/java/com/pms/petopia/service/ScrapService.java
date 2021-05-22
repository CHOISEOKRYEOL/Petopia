package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.Scrap;

public interface ScrapService {

  int add(Scrap scrap) throws Exception;

  List<Scrap> list(int memberNo) throws Exception;

  Scrap get(int scrapNo) throws Exception;

  String count(int memberNo) throws Exception;

  int delete(int no) throws Exception;

}








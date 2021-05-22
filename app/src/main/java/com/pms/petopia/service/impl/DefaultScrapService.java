package com.pms.petopia.service.impl;

import java.util.List;
import com.pms.petopia.dao.ScrapDao;
import com.pms.petopia.domain.Scrap;
import com.pms.petopia.service.ScrapService;

public class DefaultScrapService implements ScrapService {

  ScrapDao scrapDao; 

  public DefaultScrapService(ScrapDao scrapDao) {
    this.scrapDao = scrapDao;
  }

  @Override
  public int add(Scrap scrap) throws Exception {
    return scrapDao.insert(scrap);
  }

  @Override
  public List<Scrap> list() throws Exception {
    return scrapDao.findAll();
  }

  @Override
  public int delete(int no) throws Exception {
    return scrapDao.delete(no);
  }

  @Override
  public String count(int memberNo) throws Exception {
    return scrapDao.countScrap(memberNo);
  }
}








package com.pms.petopia.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.pms.petopia.dao.ScrapDao;
import com.pms.petopia.domain.Scrap;
import com.pms.petopia.service.ScrapService;
@Service
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
  public int updateScrap(int newsNo) throws Exception {
    return scrapDao.updateScrap(newsNo);
  }

  @Override
  public List<Scrap> list(int memberNo) throws Exception {
    return scrapDao.findByUser(memberNo);
  }

  @Override
  public Scrap get(int scrapNo) throws Exception {
    return scrapDao.findByNo(scrapNo);
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








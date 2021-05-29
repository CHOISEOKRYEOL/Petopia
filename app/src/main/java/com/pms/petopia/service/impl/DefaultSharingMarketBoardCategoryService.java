package com.pms.petopia.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.pms.petopia.dao.SharingMarketBoardCategoryDao;
import com.pms.petopia.domain.SharingMarketBoardCategory;
import com.pms.petopia.service.SharingMarketBoardCategoryService;
@Service
public class DefaultSharingMarketBoardCategoryService implements SharingMarketBoardCategoryService{

  SharingMarketBoardCategoryDao sharingMarketBoardCategoryDao;

  public DefaultSharingMarketBoardCategoryService(SharingMarketBoardCategoryDao sharingMarketBoardCategoryDao) {
    this.sharingMarketBoardCategoryDao = sharingMarketBoardCategoryDao;
  }

  @Override
  public SharingMarketBoardCategory get(int no) throws Exception {
    return sharingMarketBoardCategoryDao.findByNo(no); 
  }

  @Override
  public List<SharingMarketBoardCategory> list() throws Exception {
    return sharingMarketBoardCategoryDao.findAll();
  }

  @Override
  public int add(SharingMarketBoardCategory c) throws Exception {
    return sharingMarketBoardCategoryDao.insert(c);

  }


}

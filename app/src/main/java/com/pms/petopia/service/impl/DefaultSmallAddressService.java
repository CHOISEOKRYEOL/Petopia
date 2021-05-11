package com.pms.petopia.service.impl;

import java.util.List;
import com.pms.petopia.dao.SmallAddressDao;
import com.pms.petopia.domain.SmallAddress;
import com.pms.petopia.service.SmallAddressService;

public class DefaultSmallAddressService implements SmallAddressService {


  SmallAddressDao smallAddressDao;

  public DefaultSmallAddressService(SmallAddressDao smallAddressDao) {
    this.smallAddressDao = smallAddressDao;
  }

  @Override
  public SmallAddress get(int no) throws Exception {
    return smallAddressDao.findByNo(no);
  }

  @Override
  public List<SmallAddress> list() throws Exception {
    return smallAddressDao.findAll();
  }

}

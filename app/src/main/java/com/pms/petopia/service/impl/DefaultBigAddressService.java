package com.pms.petopia.service.impl;

import java.util.List;
import com.pms.petopia.dao.BigAddressDao;
import com.pms.petopia.domain.BigAddress;
import com.pms.petopia.service.BigAddressService;

public class DefaultBigAddressService implements BigAddressService {

  BigAddressDao bigAddressDao;

  public DefaultBigAddressService(BigAddressDao bigAddressDao) {
    this.bigAddressDao = bigAddressDao;
  }

  public int add(BigAddress b) throws Exception {
    return bigAddressDao.insert(b);
  }

  @Override
  public BigAddress get(int no) throws Exception {
    return bigAddressDao.findByNo(no);
  }

  @Override
  public List<BigAddress> list() throws Exception {
    return bigAddressDao.findAll();
  }

}

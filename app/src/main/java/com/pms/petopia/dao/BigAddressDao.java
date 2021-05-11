package com.pms.petopia.dao;

import java.util.List;
import com.pms.petopia.domain.BigAddress;

public interface BigAddressDao {

  BigAddress findByNo(int no) throws Exception;
  List<BigAddress> findAll() throws Exception;

}
package com.pms.petopia.dao;

import java.util.List;
import com.pms.petopia.domain.BigAddress;

public interface BigAddressDao {

  int insert(BigAddress b) throws Exception;
  BigAddress findByNo(int no) throws Exception;
  List<BigAddress> findAll() throws Exception;

}
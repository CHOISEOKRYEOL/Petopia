package com.pms.petopia.dao;

import java.util.List;
import com.pms.petopia.domain.SmallAddress;

public interface SmallAddressDao {

  int insert(SmallAddress s) throws Exception;
  SmallAddress findByNo(int no) throws Exception;
  List<SmallAddress> findAll() throws Exception;


}
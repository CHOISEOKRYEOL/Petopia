package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.SmallAddress;

public interface SmallAddressService {

  int add(SmallAddress s) throws Exception;

  SmallAddress get(int no) throws Exception;

  List<SmallAddress> list() throws Exception;

}

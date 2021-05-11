package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.SmallAddress;

public interface SmallAddressService {

  SmallAddress get(int no) throws Exception;

  List<SmallAddress> list() throws Exception;

}

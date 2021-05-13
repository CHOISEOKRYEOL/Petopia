package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.BigAddress;

public interface BigAddressService {
  int add(BigAddress b) throws Exception;
  BigAddress get(int no) throws Exception;
  List<BigAddress> list() throws Exception;
}

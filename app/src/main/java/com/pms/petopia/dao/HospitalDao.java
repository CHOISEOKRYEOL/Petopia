package com.pms.petopia.dao;

import java.util.List;
import com.pms.petopia.domain.Hospital;

public interface HospitalDao {

  int insert(Hospital hospital) throws Exception;

  List<Hospital> findAll() throws Exception;

  Hospital findByNo(int no) throws Exception;

  List<Hospital> findByKeyword(String keyword) throws Exception;

  int update(Hospital hospital) throws Exception;

  int delete(int no) throws Exception;

}

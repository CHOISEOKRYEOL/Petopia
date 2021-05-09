package com.pms.petopia.service.impl;

import java.util.List;
import com.pms.petopia.dao.HospitalDao;
import com.pms.petopia.domain.Hospital;
import com.pms.petopia.service.HospitalService;

public class DefaultHospitalService implements HospitalService {

  HospitalDao hospitalDao;

  public DefaultHospitalService(HospitalDao hospitalDao) {
    this.hospitalDao = hospitalDao;
  }

  @Override
  public int add(Hospital hospital) throws Exception {
    return hospitalDao.insert(hospital);
  }

  @Override
  public List<Hospital> list() throws Exception {
    return hospitalDao.findAll();
  }

  @Override
  public Hospital get(int no) throws Exception {
    return hospitalDao.findByNo(no);
  }

  @Override
  public int update(Hospital hospital) throws Exception {
    return hospitalDao.update(hospital);
  }

  @Override
  public int delete(int no) throws Exception {
    return hospitalDao.delete(no);
  }

  @Override
  public List<Hospital> search(String keyword) throws Exception {
    return hospitalDao.findByKeyword(keyword);
  }

}

package com.pms.petopia.service.impl;

import java.util.List;
import com.pms.petopia.dao.PetDao;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.service.PetService;

public class DefaultPetService implements PetService {

  PetDao petDao;

  public DefaultPetService(PetDao petDao) {
    this.petDao = petDao;
  }  

  // 등록 업무
  @Override
  public int add(Pet pet) throws Exception {
    return petDao.insert(pet);
  }

  // 조회 업무
  @Override
  public List<Pet> list() throws Exception {
    return petDao.findAll();
  }

  @Override
  public Pet findByNo(int no) throws Exception {
    return petDao.findByNo(no);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return petDao.delete(no);
  }

  @Override
  public int update(Pet pet) throws Exception {
    return petDao.update(pet);
  }

}








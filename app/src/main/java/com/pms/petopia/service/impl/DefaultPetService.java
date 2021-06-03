package com.pms.petopia.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.pms.petopia.dao.PetDao;
import com.pms.petopia.domain.Pet;
import com.pms.petopia.service.PetService;
@Service
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

  // 상세 조회 업무
  @Override
  public Pet get(int no) throws Exception {
    return petDao.findByNo(no);
  }

  @Override
  public int setLeaderPet(int no) throws Exception {
    return petDao.setLeaderPet(no);
  }

  //사용자 조회 업무
  @Override
  public List<Pet> list() throws Exception {
    return petDao.findAll();
  }

  // 변경 업무
  @Override
  public int update(Pet pet) throws Exception {
    return petDao.update(pet);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return petDao.delete(no);
  }

  @Override
  public List<Pet> search(String keyword) throws Exception {
    return petDao.findByKeyword(keyword);
  }

}

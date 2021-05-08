package com.pms.petopia.service.impl;

import java.util.List;
import com.pms.petopia.dao.PetMemberDao;
import com.pms.petopia.domain.PetMember;
import com.pms.petopia.service.PetMemberService;

public class DefaultPetMemberService implements PetMemberService {

  PetMemberDao petMemberDao;

  public DefaultPetMemberService(PetMemberDao petMemberDao) {
    this.petMemberDao = petMemberDao;
  }  

  // 등록 업무
  @Override
  public int add(PetMember petmember) throws Exception {
    return petMemberDao.insert(petmember);
  }

  // 조회 업무
  @Override
  public List<PetMember> list() throws Exception {
    return petMemberDao.findAll();
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return petMemberDao.delete(no);
  }

  @Override
  public int update(PetMember petmember) throws Exception {
    return petMemberDao.update(petmember);
  }

}








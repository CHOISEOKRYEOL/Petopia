package com.pms.petopia.dao;

import java.util.List;
import java.util.Map;
import com.pms.petopia.domain.PetMember;

public interface PetMemberDao {

  int insert(PetMember petmember) throws Exception;

  List<PetMember> findAll() throws Exception;

  PetMember findByNo(int no) throws Exception;

  PetMember findByEmailPassword(Map<String,Object> params) throws Exception;

  int update(PetMember petmember) throws Exception;

  int delete(int no) throws Exception;

  PetMember findByName(String name) throws Exception;
}













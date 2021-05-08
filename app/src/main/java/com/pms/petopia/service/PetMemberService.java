package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.PetMember;

public interface PetMemberService {

  int add(PetMember petmember) throws Exception;

  List<PetMember> list() throws Exception;

  int update(PetMember petmember) throws Exception;

  int delete(int no) throws Exception;


}








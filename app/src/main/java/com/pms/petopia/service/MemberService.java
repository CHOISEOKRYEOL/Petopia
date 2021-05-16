package com.pms.petopia.service;

import com.pms.petopia.domain.Member;

public interface MemberService {

  int add(Member member) throws Exception;

  Member get(int no) throws Exception;

  Member getId(String id, String password) throws Exception;

  Member getEmail(String email, String password) throws Exception;

  int update(Member member) throws Exception;

  int delete(int no) throws Exception;

  int deleteMember(int no) throws Exception;

  int deleteSharingMarketPost(int no) throws Exception;

  int deleteMyTownPost(int no) throws Exception;

  int deleteHospital(int no) throws Exception;

}








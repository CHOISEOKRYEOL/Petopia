package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.Member;

public interface MemberService {

  void certifyNumberForRegister(String phoneNumber, String authenticationNumber) throws Exception;

  void certifyNumberForPassword(String phoneNumber, String authenticationNumber) throws Exception;

  void setNewPassword(String id, String phoneNumber, String newPassword) throws Exception;

  int add(Member member) throws Exception;

  Member get(int no) throws Exception;

  Member getId(String id, String password) throws Exception;

  Member getEmail(String email, String password) throws Exception;

  Member getId(String id) throws Exception;

  Member getEmail(String email) throws Exception;

  Member getNick(String nick) throws Exception;

  Member getTel(String tel) throws Exception;

  Member getIdEmail(String name, String nick) throws Exception;

  Member getIdTel(String id, String tel) throws Exception;

  List<Member> search(String item, String keyword) throws Exception;

  int update(Member member) throws Exception;

  int delete(Member member) throws Exception;

  List<Member> list() throws Exception;

  int deleteMember(int no) throws Exception;

  int deleteSharingMarketPost(int no) throws Exception;

  int deleteMyTownPost(int no) throws Exception;

  int deleteHospital(int no) throws Exception;

}








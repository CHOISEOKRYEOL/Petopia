package com.pms.petopia.dao;

import java.util.List;
import java.util.Map;
import com.pms.petopia.domain.Member;

public interface MemberDao {

  int insert(Member member) throws Exception;

  Member findByNo(int no) throws Exception;

  Member findByIdPassword(Map<String,Object> params) throws Exception;

  Member findByEmailPassword(Map<String,Object> params) throws Exception;

  Member findById(String id) throws Exception;

  Member findByEmail(String email) throws Exception;

  Member findByNick(String nick) throws Exception;

  Member findIdEmailKey(Map<String,Object> params) throws Exception;

  List<Member> findByKeyword(Map<String,Object> params) throws Exception;

  List<Member> findAll() throws Exception;

  int update(Member member) throws Exception;

  int delete(Member member) throws Exception;

  int deleteMember(int no) throws Exception;

  int deleteSharingMarketBoardPost(int no) throws Exception;

  int deleteMyTownBoardPost(int no) throws Exception;

  int deleteHospitalInfo(int no) throws Exception;

}













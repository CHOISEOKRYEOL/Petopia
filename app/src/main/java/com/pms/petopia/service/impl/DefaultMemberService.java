package com.pms.petopia.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.pms.petopia.dao.MemberDao;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;

public class DefaultMemberService implements MemberService {

  MemberDao memberDao;

  public DefaultMemberService(MemberDao memberDao) {
    this.memberDao = memberDao;
  }  

  @Override
  public int add(Member member) throws Exception {
    return memberDao.insert(member);
  }

  @Override
  public Member get(int no) throws Exception {
    return memberDao.findByNo(no);
  }

  @Override
  public Member getId(String id, String password) throws Exception {
    Map<String,Object> params = new HashMap<>();
    params.put("id", id);
    params.put("password", password);

    return memberDao.findByIdPassword(params);
  }

  @Override
  public Member getEmail(String email, String password) throws Exception {
    Map<String,Object> params = new HashMap<>();
    params.put("id", email);
    params.put("password", password);

    return memberDao.findByEmailPassword(params);
  }

  @Override
  public int update(Member member) throws Exception {
    return memberDao.update(member);
  }

  @Override
  public int delete(Member member) throws Exception {
    return memberDao.delete(member);
  }

  @Override
  public List<Member> list() throws Exception {
    return memberDao.findAll();
  }

  @Override
  public int deleteMember(int no) throws Exception {
    return memberDao.deleteMember(no);
  }

  @Override
  public int deleteSharingMarketPost(int no) throws Exception {
    return memberDao.deleteSharingMarketBoardPost(no);
  }

  @Override
  public int deleteMyTownPost(int no) throws Exception {
    return memberDao.deleteMyTownBoardPost(no);
  }

  @Override
  public int deleteHospital(int no) throws Exception {
    return memberDao.deleteHospitalInfo(no);
  }

}








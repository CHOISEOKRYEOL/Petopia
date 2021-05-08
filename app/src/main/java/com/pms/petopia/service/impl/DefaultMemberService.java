package com.pms.petopia.service.impl;

import java.util.HashMap;
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

  // 상세 조회 업무
  @Override
  public Member get(int no) throws Exception {
    return memberDao.findByNo(no);
  }

  // 사용자 조회 업무
  @Override
  public Member get(String id, String password) throws Exception {
    Map<String,Object> params = new HashMap<>();
    params.put("id", id);
    params.put("password", password);

    return memberDao.findByIdPassword(params);
  }

  // 변경 업무
  @Override
  public int update(Member member) throws Exception {
    return memberDao.update(member);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return memberDao.delete(no);
  }

}








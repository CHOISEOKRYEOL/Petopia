package com.pms.petopia.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.pms.petopia.dao.MemberDao;
import com.pms.petopia.domain.Member;
import com.pms.petopia.service.MemberService;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;

@Service
public class DefaultMemberService implements MemberService {

  MemberDao memberDao;

  public DefaultMemberService(MemberDao memberDao) {
    this.memberDao = memberDao;
  }  

  @Override
  public void certifyNumberForRegister(String phoneNumber, String authenticationNumber) throws Exception {

    Key k = new Key();

    String api_key = k.getApi_key();
    String api_secret = k.getApi_secret_key();
    Message message = new Message(api_key, api_secret);

    HashMap<String, String> params = new HashMap<String, String>();
    params.put("to", phoneNumber);
    params.put("from", "01090986073");
    params.put("type", "SMS");
    params.put("text", "Petopia 회원가입 인증번호 " + "["+authenticationNumber+"]");

    try {
      message.send(params);

    } catch (CoolsmsException e) {
      throw new Exception(e);
    }
  }



  @Override
  public void certifyNumberForPassword(String phoneNumber, String authenticationNumber) throws Exception {

    Key k = new Key();

    String api_key = k.getApi_key();
    String api_secret = k.getApi_secret_key();
    Message message = new Message(api_key, api_secret);

    HashMap<String, String> params = new HashMap<String, String>();
    params.put("to", phoneNumber);
    params.put("from", "01090986073");
    params.put("type", "SMS");
    params.put("text", "Petopia 비밀번호 찾기 인증번호 " + "["+authenticationNumber+"]");

    try {
      message.send(params);

    } catch (CoolsmsException e) {
      throw new Exception(e);
    }
  }


  @Override
  public void setNewPassword(String id, String phoneNumber, String newPassword) throws Exception {

    Key k = new Key();

    String api_key = k.getApi_key();
    String api_secret = k.getApi_secret_key();
    Message message = new Message(api_key, api_secret);

    HashMap<String, String> params = new HashMap<String, String>();
    params.put("to", phoneNumber);
    params.put("from", "01090986073");
    params.put("type", "SMS");
    params.put("text", "Petopia 새 암호 " + "["+newPassword+"]");

    try {
      message.send(params);
      Map<String, Object> temp = new HashMap<>();
      temp.put("id", id);
      temp.put("tel", phoneNumber);

      Member m = memberDao.findIdTel(temp);
      m.setPassword(newPassword);
      memberDao.updatePassword(m);

    } catch (CoolsmsException e) {
      throw new Exception(e);
    }
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
  public Member getId(String id) throws Exception {
    return memberDao.findById(id);
  }

  @Override
  public Member getEmail(String email) throws Exception {
    return memberDao.findByEmail(email);
  }

  @Override
  public Member getNick(String nick) throws Exception {
    return memberDao.findByNick(nick);
  }

  @Override
  public Member getTel(String tel) throws Exception {
    return memberDao.findByTel(tel);
  }

  @Override
  public Member getIdEmail(String name, String nick) throws Exception {
    Map<String, Object> params = new HashMap<>();
    params.put("name", name);
    params.put("nick", nick);

    return memberDao.findIdEmailKey(params);
  }

  @Override
  public Member getIdTel(String id, String tel) throws Exception {

    Map<String, Object> params = new HashMap<>();
    params.put("id", id);
    params.put("tel", tel);

    return memberDao.findIdTel(params);
  }

  @Override
  public List<Member> search(String item, String keyword) throws Exception {
    Map<String,Object> params = new HashMap<>();
    params.put("item", item);
    params.put("keyword", keyword);

    return memberDao.findByKeyword(params);
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








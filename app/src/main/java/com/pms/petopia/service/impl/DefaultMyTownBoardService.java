package com.pms.petopia.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.pms.petopia.dao.MyTownBoardDao;
import com.pms.petopia.domain.MyTownBoard;
import com.pms.petopia.service.MyTownBoardService;
@Service
public class DefaultMyTownBoardService implements MyTownBoardService {

  MyTownBoardDao myTownBoardDao; 

  public DefaultMyTownBoardService(MyTownBoardDao myTownBoardDao) {
    this.myTownBoardDao = myTownBoardDao;
  }

  // 게시글 등록 업무
  @Override
  public int add(MyTownBoard board) throws Exception {
    return myTownBoardDao.insert(board);
  }

  @Override
  public List<MyTownBoard> listAll() throws Exception {
    return myTownBoardDao.findAll();
  }

  // 게시글 목록 조회 업무
  @Override
  public List<MyTownBoard> list(int stateNo, int cityNo) throws Exception {
    HashMap<String,Object> params = new HashMap<>();
    params.put("gno", stateNo);
    params.put("cno", cityNo);

    return myTownBoardDao.findByArea(params);
  }

  // 게시글 추천수대로 출력 
  @Override
  public List<MyTownBoard> listRecomment(int stateNo, int cityNo) throws Exception {
    HashMap<String,Object> params = new HashMap<>();
    params.put("gno", stateNo);
    params.put("cno", cityNo);
    return myTownBoardDao.findByRecomment(params);
  }

  // 나의 게시글
  @Override
  public List<MyTownBoard> listMine(int MemberNo) throws Exception {
    return myTownBoardDao.findByMember(MemberNo);
  }

  // 게시글 상세 조회 업무
  @Override
  public MyTownBoard get(int no) throws Exception {
    MyTownBoard myTownBoard = myTownBoardDao.findByNo(no);
    if (myTownBoard != null) {
      myTownBoardDao.updateViewCount(no);
    }
    return myTownBoard;
  }

  // 게시글 변경 업무
  @Override
  public int update(MyTownBoard myTownBoard) throws Exception {
    return myTownBoardDao.update(myTownBoard);
  }

  // 게시글 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return myTownBoardDao.delete(no);
  }

  @Override
  public int deleteAll(int no) throws Exception {
    return myTownBoardDao.deleteAll(no);
  }

  // 게시글 검색 업무
  @Override
  public List<MyTownBoard> search(int stateNo, int cityNo, String keyword) throws Exception {
    HashMap<String,Object> params = new HashMap<>();
    params.put("gno", stateNo);
    params.put("cno", cityNo);
    params.put("keyword", keyword);

    return myTownBoardDao.findByKeyword(params);
  }

  @Override
  public int updateRecommentCount(int no) throws Exception {
    return myTownBoardDao.updateRecommentCount(no);
  }
}








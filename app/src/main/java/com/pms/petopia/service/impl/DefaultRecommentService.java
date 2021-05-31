package com.pms.petopia.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.pms.petopia.dao.RecommentDao;
import com.pms.petopia.domain.Recomment;
import com.pms.petopia.service.RecommentService;
@Service
public class DefaultRecommentService implements RecommentService {

  RecommentDao recommentDao; 

  public DefaultRecommentService(RecommentDao recommentDao) {
    this.recommentDao = recommentDao;
  }

  // 게시글 등록 업무
  @Override
  public int add(Recomment recomment) throws Exception {
    return recommentDao.insert(recomment);
  }

  // 게시글 목록 조회 업무
  @Override
  public List<Recomment> list() throws Exception {
    return recommentDao.findAll();
  }

  // 게시글 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return recommentDao.delete(no);
  }

  @Override
  public String count(int myTownBoardNo) throws Exception {
    return recommentDao.countReco(myTownBoardNo);
  }
}








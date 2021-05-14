package com.pms.petopia.service.impl;

import java.util.List;
import com.pms.petopia.dao.QnaDao;
import com.pms.petopia.domain.Qna;
import com.pms.petopia.service.QnaService;

public class DefaultQnaService implements QnaService {

  QnaDao qnaDao;

  public DefaultQnaService(QnaDao qnaDao) {
    this.qnaDao = qnaDao;
  }

  @Override
  public int add(Qna qna) throws Exception {
    return qnaDao.insert(qna);
  }

  @Override
  public List<Qna> list() throws Exception {
    return qnaDao.findAll();
  }

  @Override
  public Qna findByNo(int no) throws Exception {
    return qnaDao.findByNo(no);
  }

  @Override
  public int update(Qna qna) throws Exception {
    return qnaDao.update(qna);
  }

  @Override
  public int delete(int no) throws Exception {
    return qnaDao.delete(no);
  }



}

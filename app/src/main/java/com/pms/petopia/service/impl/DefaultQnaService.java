package com.pms.petopia.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.pms.petopia.dao.QnaDao;
import com.pms.petopia.domain.Qna;
import com.pms.petopia.service.QnaService;
@Service
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
  public Qna get(int no) throws Exception {
    return qnaDao.findByNo(no);
  }

  @Override
  public int update(Qna qna) throws Exception {
    return qnaDao.update(qna);
  }

  @Override
  public int answer(Qna qna) throws Exception {
    return qnaDao.answer(qna);
  }

  @Override
  public int delete(int no) throws Exception {
    return qnaDao.delete(no);
  }

  @Override
  public int deleteAll(int no) throws Exception {
    return qnaDao.deleteAll(no);
  }

}

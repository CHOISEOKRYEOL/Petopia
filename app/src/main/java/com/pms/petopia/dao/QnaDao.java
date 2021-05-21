package com.pms.petopia.dao;

import java.util.List;
import com.pms.petopia.domain.Qna;

public interface QnaDao {

  int insert(Qna qna) throws Exception;

  Qna findByNo(int no) throws Exception;

  List<Qna> findAll() throws Exception;

  int update(Qna qna) throws Exception;

  int answer(Qna qna) throws Exception;

  int delete(int no) throws Exception;
}

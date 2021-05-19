package com.pms.petopia.dao;

import java.util.HashMap;
import java.util.List;
import com.pms.petopia.domain.Record;

// BoardDao 의 규칙 정의
public interface RecordDao {

  int insert(Record record) throws Exception;

  List<Record> findByKeyword(String keyword) throws Exception;

  Record findByNo(int no) throws Exception;

  int update(Record record) throws Exception;

  int updateViewCount(int no) throws Exception;

  int delete(int no) throws Exception;

  List<Record> findAll() throws Exception;

  HashMap<String,Object> add() throws Exception;
}













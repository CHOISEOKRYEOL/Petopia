package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.Record;

public interface RecordService {

  int add(Record record) throws Exception;

  List<Record> list() throws Exception;

  Record get(int no) throws Exception;

  int update(Record record) throws Exception;

  int delete(int no) throws Exception;

}








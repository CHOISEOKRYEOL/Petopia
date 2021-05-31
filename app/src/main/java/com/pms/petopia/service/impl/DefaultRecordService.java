package com.pms.petopia.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.pms.petopia.dao.RecordDao;
import com.pms.petopia.domain.Record;
import com.pms.petopia.service.RecordService;
@Service
public class DefaultRecordService implements RecordService {

  RecordDao recordDao;

  public DefaultRecordService(RecordDao recordDao) {
    this.recordDao = recordDao;
  }  

  // 등록 업무
  @Override
  public int add(Record record) throws Exception {
    return recordDao.insert(record);
  }

  @Override
  public Record get(int no) throws Exception {
    return recordDao.findByNo(no);
  }

  // 조회 업무
  @Override
  public List<Record> list() throws Exception {
    return recordDao.findAll();
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return recordDao.delete(no);
  }

  @Override
  public int update(Record record) throws Exception {
    return recordDao.update(record);
  }

  @Override
  public HashMap<String, Object> add() throws Exception {
    return recordDao.add();
  }


  //  @Override
  //  public List<Member> getMembers(int projectNo) throws Exception {
  //    return recordDao.findMembers(projectNo);
  //  }

}








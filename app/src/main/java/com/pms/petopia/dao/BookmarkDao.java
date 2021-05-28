package com.pms.petopia.dao;

import java.util.List;
import java.util.Map;
import com.pms.petopia.domain.Bookmark;

public interface BookmarkDao {

  int insert(Bookmark bookMark) throws Exception;

  List<Bookmark> findAll(int no) throws Exception;

  List<Bookmark> findByNo(int no) throws Exception;

  Bookmark findByNumbers(Map<String,Integer> params) throws Exception;

  int delete(int no) throws Exception;

  int deleteAll(int no) throws Exception;

  int deleteByAdmin(int no) throws Exception;
}

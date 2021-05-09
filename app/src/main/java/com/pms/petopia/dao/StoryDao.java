package com.pms.petopia.dao;

import java.util.List;
import com.pms.petopia.domain.Story;

public interface StoryDao {

  int insert(Story story) throws Exception;

  List<Story> findAll() throws Exception;

  List<Story> findByKeyword(String keyword) throws Exception;

  Story findByNo(int no) throws Exception;

  int update(Story story) throws Exception;

  int delete(int no) throws Exception;

}

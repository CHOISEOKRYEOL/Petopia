package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.Story;

public interface StoryService {

  int add(Story story) throws Exception;

  List<Story> list() throws Exception;

  int update(Story story) throws Exception;

  int delete(int no) throws Exception;

  List<Story> search(String keyword) throws Exception;

}

package com.pms.petopia.service.impl;

import java.util.List;
import com.pms.petopia.dao.StoryDao;
import com.pms.petopia.domain.Story;
import com.pms.petopia.service.StoryService;

public class DefaultStorylSearvice implements StoryService {

  StoryDao storyDao;

  public DefaultStorylSearvice(StoryDao storyDao) {
    this.storyDao = storyDao;
  }

  @Override
  public int add(Story story) throws Exception {
    return storyDao.insert(story);
  }

  @Override
  public List<Story> list() throws Exception {
    return storyDao.findAll();
  }

  @Override
  public int update(Story story) throws Exception {
    return storyDao.update(story);
  }

  @Override
  public int delete(int no) throws Exception {
    return storyDao.delete(no);
  }

  @Override
  public List<Story> search(String keyword) throws Exception {
    return storyDao.findByKeyword(keyword);
  }

}

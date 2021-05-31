package com.pms.petopia.service.impl;

import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Service;
import com.pms.petopia.dao.BookmarkDao;
import com.pms.petopia.domain.Bookmark;
import com.pms.petopia.service.BookmarkService;

@Service
public class DefaultBookmarkService implements BookmarkService {

  BookmarkDao bookmarkDao;

  public DefaultBookmarkService(BookmarkDao bookmarkDao) {
    this.bookmarkDao = bookmarkDao;
  }

  @Override
  public int add(Bookmark bookmark) throws Exception {
    return bookmarkDao.insert(bookmark);
  }

  @Override
  public List<Bookmark> list(int no) throws Exception {
    return bookmarkDao.findAll(no);
  }

  @Override
  public List<Bookmark> get(int no) throws Exception {
    return bookmarkDao.findByNo(no);
  }

  @Override
  public Bookmark get(int member, int hospital) throws Exception {
    HashMap<String, Integer> params = new HashMap<>();
    params.put("member", member);
    params.put("hospital", hospital);

    return bookmarkDao.findByNumbers(params);
  }

  @Override
  public int delete(int no) throws Exception {
    return bookmarkDao.delete(no);
  }

  @Override
  public int deleteAll(int no) throws Exception {
    return bookmarkDao.deleteAll(no);
  }

  @Override
  public int deleteByAdmin(int no) throws Exception {
    return bookmarkDao.deleteByAdmin(no);
  }

}

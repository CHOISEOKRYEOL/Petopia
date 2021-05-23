package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.Bookmark;

public interface BookmarkService {

  int add(Bookmark bookMark) throws Exception;

  List<Bookmark> list(int no) throws Exception;

  List<Bookmark> get(int no) throws Exception;

  Bookmark get(int member, int hospital) throws Exception;

  int delete(int no) throws Exception;
}

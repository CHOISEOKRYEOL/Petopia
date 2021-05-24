package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.Review;

public interface ReviewService {
  int add(Review review) throws Exception;

  Review get(int no) throws Exception;

  List<Review> list(int no) throws Exception;

  List<Review> listAll() throws Exception;

  List<Review> search(String item, String keyword) throws Exception;

  int update(Review review) throws Exception;

  int delete(int no) throws Exception;

  int deleteAll(int no) throws Exception;

  int deleteByAdmin(int no) throws Exception;
}

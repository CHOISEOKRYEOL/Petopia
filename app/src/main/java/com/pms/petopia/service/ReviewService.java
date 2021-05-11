package com.pms.petopia.service;

import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Review;

public interface ReviewService {
  int add(Review review) throws Exception;

  Review get(int no) throws Exception;

  Review get(Hospital hospital) throws Exception;

  int update(Review review) throws Exception;

  int delete(int no) throws Exception;
}

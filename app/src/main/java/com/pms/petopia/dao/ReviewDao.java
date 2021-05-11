package com.pms.petopia.dao;

import com.pms.petopia.domain.Hospital;
import com.pms.petopia.domain.Review;

public interface ReviewDao {

  int insert(Review review) throws Exception;

  Review findByNo(int no) throws Exception;

  Review findAll(Hospital hospital) throws Exception;

  int update(Review review) throws Exception;

  int delete(int no) throws Exception;

}

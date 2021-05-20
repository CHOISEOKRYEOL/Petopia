package com.pms.petopia.dao;

import java.util.List;
import com.pms.petopia.domain.Review;

public interface ReviewDao {

  int insert(Review review) throws Exception;

  Review findByNo(int no) throws Exception;

  List<Review> findAll(int no) throws Exception;

  List<Review> findAllList() throws Exception;

  int update(Review review) throws Exception;

  int delete(int no) throws Exception;

}

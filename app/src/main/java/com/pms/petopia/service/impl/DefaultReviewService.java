package com.pms.petopia.service.impl;

import java.util.List;
import com.pms.petopia.dao.ReviewDao;
import com.pms.petopia.domain.Review;
import com.pms.petopia.service.ReviewService;

public class DefaultReviewService implements ReviewService {
  ReviewDao reviewDao;

  public DefaultReviewService(ReviewDao reviewDao) {
    this.reviewDao = reviewDao;
  }  

  @Override
  public int add(Review review) throws Exception {
    return reviewDao.insert(review);
  }

  // 상세 조회 업무
  @Override
  public Review get(int no) throws Exception {
    return reviewDao.findByNo(no);
  }

  // 사용자 조회 업무
  @Override
  public List<Review> list(int no) throws Exception {

    return reviewDao.findAll(no);
  }

  @Override
  public List<Review> listAll() throws Exception {
    return reviewDao.findAllList();
  }

  // 변경 업무
  @Override
  public int update(Review review) throws Exception {
    return reviewDao.update(review);
  }

  // 삭제 업무
  @Override
  public int delete(int no) throws Exception {
    return reviewDao.delete(no);
  }

}

package com.pms.petopia.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import com.pms.petopia.dao.ReviewDao;
import com.pms.petopia.domain.Review;
import com.pms.petopia.service.ReviewService;

@Service
public class DefaultReviewService implements ReviewService {
  ReviewDao reviewDao;

  public DefaultReviewService(ReviewDao reviewDao) {
    this.reviewDao = reviewDao;
  }  

  @Override
  public int add(Review review) throws Exception {
    return reviewDao.insert(review);
  }

  @Override
  public Review get(int no) throws Exception {
    return reviewDao.findByNo(no);
  }

  @Override
  public List<Review> list(int no) throws Exception {

    return reviewDao.findAll(no);
  }

  @Override
  public List<Review> listAll() throws Exception {
    return reviewDao.findAllList();
  }

  @Override
  public List<Review> search(String item, String keyword) throws Exception {
    Map<String,Object> params = new HashMap<>();
    params.put("item", item);
    params.put("keyword", keyword);

    return reviewDao.findByKeyword(params);
  }

  @Override
  public int update(Review review) throws Exception {
    return reviewDao.update(review);
  }

  @Override
  public int delete(int no) throws Exception {
    return reviewDao.delete(no);
  }

  @Override
  public int deleteAll(int no) throws Exception {
    return reviewDao.deleteAll(no);
  }

  @Override
  public int deleteByAdmin(int no) throws Exception {
    return reviewDao.deleteByAdmin(no);
  }

  @Override
  public String countReview(int no) throws Exception {
    return reviewDao.countReview(no);
  }

}

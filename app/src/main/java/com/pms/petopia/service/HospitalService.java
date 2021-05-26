package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.Hospital;

public interface HospitalService {

  int add(Hospital hospital) throws Exception;

  List<Hospital> list() throws Exception;

  Hospital get(int no) throws Exception;

  int update(Hospital hospital) throws Exception;

  int delete(int no) throws Exception;

  List<Hospital> search(String keyword) throws Exception;

  int rate(Hospital hospital) throws Exception;

  int setAccumulatedRating(Hospital hospital) throws Exception;

  int initAccumulatedRating(int no) throws Exception;

  Hospital getRating(int no) throws Exception;


}

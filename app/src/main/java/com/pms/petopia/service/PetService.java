package com.pms.petopia.service;

import java.util.List;
import com.pms.petopia.domain.Pet;

public interface PetService {

  int add(Pet pet) throws Exception;

  List<Pet> list() throws Exception;

  Pet get(int no) throws Exception;

  int update(Pet pet) throws Exception;

  int delete(int no) throws Exception;

  List<Pet> search(String keyword) throws Exception;

}








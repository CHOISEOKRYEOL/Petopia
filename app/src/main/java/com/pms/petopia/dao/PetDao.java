package com.pms.petopia.dao;

import java.util.List;
import com.pms.petopia.domain.Pet;

public interface PetDao {

  int insert(Pet pet) throws Exception;

  List<Pet> findAll() throws Exception;

  Pet findByNo(int no) throws Exception;

  int update(Pet pet) throws Exception;

  int delete(int no) throws Exception;

  Pet findByName(String name) throws Exception;

}













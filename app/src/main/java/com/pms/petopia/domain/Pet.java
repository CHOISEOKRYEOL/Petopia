package com.pms.petopia.domain;

import java.sql.Date;

public class Pet {

  private int no;
  private String name;
  private int age;
  private Date birthDay;
  private int gender; // 1 = female / 0 = male
  private String photo;
  private int typeNo;
  private int speciesNo;
  private Type type;
  private Species species;
  private Member owner;

  //  private int roleNo;
  //  private Member role;
  //  private int owner;
  //  private int leader;
  //  private List<Member> members;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public int getAge() {
    return age;
  }
  public void setAge(int age) {
    this.age = age;
  }
  public Date getBirthDay() {
    return birthDay;
  }
  public void setBirthDay(Date birthDay) {
    this.birthDay = birthDay;
  }
  public int getGender() {
    return gender;
  }
  public void setGender(int gender) {
    this.gender = gender;
  }
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  public int getSpeciesNo() {
    return speciesNo;
  }
  public void setSpeciesNo(int speciesNo) {
    this.speciesNo = speciesNo;
  }
  public Member getOwner() {
    return owner;
  }
  public void setOwner(Member owner) {
    this.owner = owner;
  }
  public Type getType() {
    return type;
  }
  public void setType(Type type) {
    this.type = type;
  }
  public Species getSpecies() {
    return species;
  }
  public void setSpecies(Species species) {
    this.species = species;
  }
  @Override
  public String toString() {
    return "Pet [no=" + no + ", name=" + name + ", age=" + age + ", birthDay=" + birthDay
        + ", gender=" + gender + ", photo=" + photo + ", speciesNo=" + speciesNo + ", owner="
        + owner + ", type=" + type + ", species=" + species + "]";
  }

  //  public void setMembers(List<Member> members) {
  //    this.members = members;
  //  }  



}

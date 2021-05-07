package com.pms.petopia.domain;

import java.sql.Date;

public class Pet {

  private int no;
  private String name;
  private int age;
  private Date birthDay;
  private boolean gender; // true = female | false = male
  private String photo;
  private Member owner;

  @Override
  public String toString() {
    return "Pet [no=" + no + ", owner=" + owner + ", name=" + name + ", age=" + age + ", birthDay="
        + birthDay + ", gender=" + gender + ", photo=" + photo + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public Member getOwner() {
    return owner;
  }
  public void setOwner(Member owner) {
    this.owner = owner;
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
  public boolean isGender() {
    return gender;
  }
  public void setGender(boolean gender) {
    this.gender = gender;
  }
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }

}

package com.pms.petopia.domain;

import java.sql.Date;

public class Pet {

  private int no;
  private String name;
  private int age;
  private Date birthDay;
  private int gender; // 1 = female / 0 = male
  private String photo;
  private Member owner;
  private Type type;

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



}

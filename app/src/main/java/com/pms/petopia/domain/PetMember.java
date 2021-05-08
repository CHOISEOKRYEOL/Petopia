package com.pms.petopia.domain;

import java.lang.reflect.Member;
import java.sql.Date;

public class PetMember {

  private int no;
  private String name;
  private int age;
  private Date birth;
  private int gender;
  private String photo;
  private Member member;
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
  public Date getBirth() {
    return birth;
  }
  public void setBirth(Date birth) {
    this.birth = birth;
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
  public Member getMember() {
    return member;
  }
  public void setMember(Member member) {
    this.member = member;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + age;
    result = prime * result + ((birth == null) ? 0 : birth.hashCode());
    result = prime * result + gender;
    result = prime * result + ((member == null) ? 0 : member.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + no;
    result = prime * result + ((photo == null) ? 0 : photo.hashCode());
    return result;
  }
  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    PetMember other = (PetMember) obj;
    if (age != other.age)
      return false;
    if (birth == null) {
      if (other.birth != null)
        return false;
    } else if (!birth.equals(other.birth))
      return false;
    if (gender != other.gender)
      return false;
    if (member == null) {
      if (other.member != null)
        return false;
    } else if (!member.equals(other.member))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (no != other.no)
      return false;
    if (photo == null) {
      if (other.photo != null)
        return false;
    } else if (!photo.equals(other.photo))
      return false;
    return true;
  }
  @Override
  public String toString() {
    return "PetMember [no=" + no + ", name=" + name + ", age=" + age + ", birth=" + birth
        + ", gender=" + gender + ", photo=" + photo + ", member=" + member + "]";
  }


}

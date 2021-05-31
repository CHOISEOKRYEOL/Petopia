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
  private Member role;
  private Type type;
  private Species species;
  private int leader;

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
  public Member getRole() {
    return role;
  }
  public void setRole(Member role) {
    this.role = role;
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
  public int getLeader() {
    return leader;
  }
  public void setLeader(int leader) {
    this.leader = leader;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + age;
    result = prime * result + ((birthDay == null) ? 0 : birthDay.hashCode());
    result = prime * result + gender;
    result = prime * result + leader;
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + no;
    result = prime * result + ((owner == null) ? 0 : owner.hashCode());
    result = prime * result + ((photo == null) ? 0 : photo.hashCode());
    result = prime * result + ((role == null) ? 0 : role.hashCode());
    result = prime * result + ((species == null) ? 0 : species.hashCode());
    result = prime * result + ((type == null) ? 0 : type.hashCode());
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
    Pet other = (Pet) obj;
    if (age != other.age)
      return false;
    if (birthDay == null) {
      if (other.birthDay != null)
        return false;
    } else if (!birthDay.equals(other.birthDay))
      return false;
    if (gender != other.gender)
      return false;
    if (leader != other.leader)
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (no != other.no)
      return false;
    if (owner == null) {
      if (other.owner != null)
        return false;
    } else if (!owner.equals(other.owner))
      return false;
    if (photo == null) {
      if (other.photo != null)
        return false;
    } else if (!photo.equals(other.photo))
      return false;
    if (role == null) {
      if (other.role != null)
        return false;
    } else if (!role.equals(other.role))
      return false;
    if (species == null) {
      if (other.species != null)
        return false;
    } else if (!species.equals(other.species))
      return false;
    if (type == null) {
      if (other.type != null)
        return false;
    } else if (!type.equals(other.type))
      return false;
    return true;
  }
  @Override
  public String toString() {
    return "Pet [no=" + no + ", name=" + name + ", age=" + age + ", birthDay=" + birthDay
        + ", gender=" + gender + ", photo=" + photo + ", owner=" + owner + ", role=" + role
        + ", type=" + type + ", species=" + species + ", leader=" + leader + "]";
  }



}

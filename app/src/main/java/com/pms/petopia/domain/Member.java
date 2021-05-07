package com.pms.petopia.domain;

import java.sql.Date;

public class Member {

  private int no;
  private String name;
  private String nick;
  private String id;
  private String password;
  private String email;
  private String tel;
  private int role;
  private Date registeredDate;

  @Override
  public String toString() {
    return "Member [no=" + no + ", name=" + name + ", nick=" + nick + ", id=" + id + ", password="
        + password + ", email=" + email + ", phone=" + tel + ", role=" + role
        + ", registeredDate=" + registeredDate + "]";
  }

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
  public String getNick() {
    return nick;
  }
  public void setNick(String nick) {
    this.nick = nick;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public int getRole() {
    return role;
  }
  public void setRole(int role) {
    this.role = role;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }

}

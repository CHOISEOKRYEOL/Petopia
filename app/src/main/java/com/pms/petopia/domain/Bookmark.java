package com.pms.petopia.domain;

public class Bookmark {

  private int no;
  private Member member;
  private Hospital hospital;

  @Override
  public String toString() {
    return "Bookmark [no=" + no + ", member=" + member + ", hospital=" + hospital + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public Member getMember() {
    return member;
  }
  public void setMember(Member member) {
    this.member = member;
  }
  public Hospital getHospital() {
    return hospital;
  }
  public void setHospital(Hospital hospital) {
    this.hospital = hospital;
  }

}

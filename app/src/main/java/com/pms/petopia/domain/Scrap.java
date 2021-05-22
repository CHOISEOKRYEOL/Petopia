package com.pms.petopia.domain;

public class Scrap {

  private int no;
  private Member member;
  private Story story;
  private int isScrap;

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
  public Story getStory() {
    return story;
  }
  public void setStory(Story story) {
    this.story = story;
  }
  public int getIsScrap() {
    return isScrap;
  }
  public void setIsScrap(int isScrap) {
    this.isScrap = isScrap;
  }



}

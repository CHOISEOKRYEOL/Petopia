package com.pms.petopia.domain;

import java.sql.Date;

public class MyTownBoard {

  private int no;
  private String title;
  private String content;
  private Date createdDate;
  private int viewCount;
  private int recommendCount;
  private Member writer;
  private BigAddress bigAddress;
  private SmallAddress smallAddress;

  @Override
  public String toString() {
    return "MyTownBoard [no=" + no + ", title=" + title + ", content=" + content + ", createdDate="
        + createdDate + ", viewCount=" + viewCount + ", recommendCount=" + recommendCount
        + ", writer=" + writer + ", bigAddress=" + bigAddress + ", smallAddress=" + smallAddress
        + "]";
  }

  public int getNo() {
    return no;
  }

  public void setNo(int no) {
    this.no = no;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Date getCreatedDate() {
    return createdDate;
  }

  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }

  public int getViewCount() {
    return viewCount;
  }

  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }

  public Member getWriter() {
    return writer;
  }

  public void setWriter(Member writer) {
    this.writer = writer;
  }

  public BigAddress getBigAddress() {
    return bigAddress;
  }

  public void setBigAddress(BigAddress bigAddress) {
    this.bigAddress = bigAddress;
  }

  public SmallAddress getSmallAddress() {
    return smallAddress;
  }

  public void setSmallAddress(SmallAddress smallAddress) {
    this.smallAddress = smallAddress;
  }

  public int getRecommendCount() {
    return recommendCount;
  }

  public void setRecommendCount(int recommendCount) {
    this.recommendCount = recommendCount;
  }



}

package com.pms.petopia.domain;

import java.sql.Date;

public class Review {

  private int no;
  private int serviceRate;
  private int cleanlinessRate; 
  private int costRate;
  private String comment;
  private String photo;
  private Date createdDate;
  private Member writer;

  @Override
  public String toString() {
    return "Review [no=" + no + ", serviceRate=" + serviceRate + ", cleanlinessRate="
        + cleanlinessRate + ", costRate=" + costRate + ", comment=" + comment + ", photo=" + photo
        + ", createdDate=" + createdDate + ", writer=" + writer + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getServiceRate() {
    return serviceRate;
  }
  public void setServiceRate(int serviceRate) {
    this.serviceRate = serviceRate;
  }
  public int getCleanlinessRate() {
    return cleanlinessRate;
  }
  public void setCleanlinessRate(int cleanlinessRate) {
    this.cleanlinessRate = cleanlinessRate;
  }
  public int getCostRate() {
    return costRate;
  }
  public void setCostRate(int costRate) {
    this.costRate = costRate;
  }
  public String getComment() {
    return comment;
  }
  public void setComment(String comment) {
    this.comment = comment;
  }
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }

}

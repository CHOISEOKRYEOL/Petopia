package com.pms.petopia.domain;

import java.sql.Date;

public class Review {

  private int no;
  private int serviceRating;
  private int cleanlinessRating;
  private int costRating;
  private String comment;
  private String photo;
  private Date createdDate;
  private Member writer;
  private Hospital hospital;

  @Override
  public String toString() {
    return "Review [no=" + no + ", serviceRating=" + serviceRating + ", cleanlinessRating="
        + cleanlinessRating + ", costRating=" + costRating + ", comment=" + comment + ", photo="
        + photo + ", createdDate=" + createdDate + ", writer=" + writer + ", hospital=" + hospital
        + "]";
  }

  public Hospital getHospital() {
    return hospital;
  }
  public void setHospital(Hospital hospital) {
    this.hospital = hospital;
  }
  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public int getServiceRating() {
    return serviceRating;
  }
  public void setServiceRating(int serviceRating) {
    this.serviceRating = serviceRating;
  }
  public int getCleanlinessRating() {
    return cleanlinessRating;
  }
  public void setCleanlinessRating(int cleanlinessRating) {
    this.cleanlinessRating = cleanlinessRating;
  }
  public int getCostRating() {
    return costRating;
  }
  public void setCostRating(int costRating) {
    this.costRating = costRating;
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

package com.pms.petopia.domain;

import java.sql.Date;
import java.util.List;

public class SharingMarketBoard {

  private int no;
  private String title;
  private String content;
  private Date createdDate;
  private Member writer;
  private int viewCount;
  private SharingMarketBoardCategory category;
  private List<SharingMarketBoardPhoto> photos;
  private SharingMarketBoardPhoto photo;

  @Override
  public String toString() {
    return "SharingMarketBoard [no=" + no + ", title=" + title + ", content=" + content
        + ", createdDate=" + createdDate + ", writer=" + writer + ", viewCount=" + viewCount
        + ", category=" + category + ", photos=" + photos + ", photo=" + photo + "]";
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
  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }
  public int getViewCount() {
    return viewCount;
  }
  public void setViewCount(int viewCount) {
    this.viewCount = viewCount;
  }
  public SharingMarketBoardCategory getCategory() {
    return category;
  }
  public void setCategory(SharingMarketBoardCategory category) {
    this.category = category;
  }

  public List<SharingMarketBoardPhoto> getPhotos() {
    return photos;
  }

  public void setPhotos(List<SharingMarketBoardPhoto> photos) {
    this.photos = photos;
  }

  public SharingMarketBoardPhoto getPhoto() {
    return photo;
  }

  public void setPhoto(SharingMarketBoardPhoto photo) {
    this.photo = photo;
  }

}

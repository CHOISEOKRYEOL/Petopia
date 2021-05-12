package com.pms.petopia.domain;

import java.sql.Date;

public class SharingMarketBoard {

  private int no;
  private int category;
  private String title;
  private String content;
  private Date createdDate;
  private Member writer;
  private int viewCount;

  @Override
public String toString() {
	return "SharingMarketBoard [no=" + no + ", category=" + category + ", title=" + title + ", content=" + content
			+ ", createdDate=" + createdDate + ", writer=" + writer + ", veiwCount=" + viewCount + "]";
}
public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }

  public int getCategory() {
	return category;
}
public void setCategory(int category) {
	this.category = category;
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
public int getVeiwCount() {
	return viewCount;
}
public void setVeiwCount(int veiwCount) {
	this.viewCount = veiwCount;
}
  
  

}

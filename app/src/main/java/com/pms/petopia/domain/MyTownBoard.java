package com.pms.petopia.domain;

import java.sql.Date;

public class MyTownBoard {

  private int no;
  private String title;
  private String content;
  private Date CreatedDate;
  private int vw_count;
  private Member writer;

  @Override
  public String toString() {
    return "MyTownBoard [no=" + no + ", title=" + title + ", content=" + content + ", CreatedDate="
        + CreatedDate + ", vw_count=" + vw_count + ", writer=" + writer + "]";
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
    return CreatedDate;
  }
  public void setCreatedDate(Date createdDate) {
    CreatedDate = createdDate;
  }
  public int getVw_count() {
    return vw_count;
  }
  public void setVw_count(int vw_count) {
    this.vw_count = vw_count;
  }
  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }

}

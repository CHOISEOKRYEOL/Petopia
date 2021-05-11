package com.pms.petopia.domain;

import java.sql.Date;

public class Story {

  private int no;
  private String title;
  private String url;
  private String site;
  private Date registeredDate;
  private Member admin;

  @Override
  public String toString() {
    return "Story [no=" + no + ", title=" + title + ", url=" + url + ", site=" + site
        + ", registeredDate=" + registeredDate + ", admin=" + admin + "]";
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
  public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
  public String getSite() {
    return site;
  }
  public void setSite(String site) {
    this.site = site;
  }
  public Date getRegisteredDate() {
    return registeredDate;
  }
  public void setRegisteredDate(Date registeredDate) {
    this.registeredDate = registeredDate;
  }
  public Member getAdmin() {
    return admin;
  }
  public void setAdmin(Member admin) {
    this.admin = admin;
  }

}

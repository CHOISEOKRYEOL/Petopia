package com.pms.petopia.domain;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Story {

  private int no;
  private String title;
  private String url;
  private String site;
  private Date registeredDate;

  // 날짜 값을 특정 포맷의 문자열로 만들어 리턴한다.
  public String getRegisteredDate2() {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(registeredDate);
  }

  @Override
  public String toString() {
    return "Story [no=" + no + ", title=" + title + ", url=" + url + ", site=" + site
        + ", registeredDate=" + registeredDate + "]";
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

}

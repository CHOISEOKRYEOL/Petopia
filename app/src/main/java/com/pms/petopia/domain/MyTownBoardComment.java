package com.pms.petopia.domain;

import java.sql.Date;

public class MyTownBoardComment {

  private int no;
  private String content;
  private Member writer;
  private Date createdDate;
  private MyTownBoard myTownBoard;

  @Override
  public String toString() {
    return "MyTownBoardComment [no=" + no + ", content=" + content + ", writer=" + writer
        + ", createdDate=" + createdDate + ", myTownBoard=" + myTownBoard + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getContent() {
    return content;
  }
  public void setContent(String content) {
    this.content = content;
  }
  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }
  public Date getCreatedDate() {
    return createdDate;
  }
  public void setCreatedDate(Date createdDate) {
    this.createdDate = createdDate;
  }
  public MyTownBoard getMyTownBoard() {
    return myTownBoard;
  }
  public void setMyTownBoard(MyTownBoard myTownBoard) {
    this.myTownBoard = myTownBoard;
  }





}

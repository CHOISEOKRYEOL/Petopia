package com.pms.petopia.domain;

public class MyTownBoardComment {

  private int no;
  private String content;
  private Member writer;

  @Override
  public String toString() {
    return "Comment [no=" + no + ", content=" + content + ", writer=" + writer + "]";
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



}

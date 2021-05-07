package com.pms.petopia.domain;

public class Comment {

  private int no;
  private boolean type; // true = 우리동네 | false = 나눔장터 
  private String content;
  private Member writer;

  @Override
  public String toString() {
    return "Comment [no=" + no + ", type=" + type + ", content=" + content + ", writer=" + writer
        + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public boolean isType() {
    return type;
  }
  public void setType(boolean type) {
    this.type = type;
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

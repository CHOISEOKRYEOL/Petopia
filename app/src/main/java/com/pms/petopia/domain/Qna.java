package com.pms.petopia.domain;

import java.sql.Date;

public class Qna {

  private int no;
  private String title;
  private String content;
  private Date createdDate;
  private String answer;
  private Date answeredDate;
  private Member writer;

  @Override
  public String toString() {
    return "Qna [no=" + no + ", title=" + title + ", content=" + content + ", createdDate="
        + createdDate + ", answer=" + answer + ", answeredDate=" + answeredDate + ", writer="
        + writer + "]";
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
  public String getAnswer() {
    return answer;
  }
  public void setAnswer(String answer) {
    this.answer = answer;
  }
  public Date getAnsweredDate() {
    return answeredDate;
  }
  public void setAnsweredDate(Date answeredDate) {
    this.answeredDate = answeredDate;
  }
  public Member getWriter() {
    return writer;
  }
  public void setWriter(Member writer) {
    this.writer = writer;
  }

}

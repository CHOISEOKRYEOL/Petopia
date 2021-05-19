package com.pms.petopia.domain;

import java.sql.Date;

public class SharingMarketBoardComment {

  private int no;
  private String content;
  private Member writer;
  private Date createdDAte;
  private SharingMarketBoard sharingMarketBoard;
  
  
@Override
public String toString() {
	return "Comment [no=" + no + ", content=" + content + ", writer=" + writer + ", createdDAte=" + createdDAte
			+ ", sharingMarketBoard=" + sharingMarketBoard + "]";
	
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
public Date getCreatedDAte() {
	return createdDAte;
}
public void setCreatedDAte(Date createdDAte) {
	this.createdDAte = createdDAte;
}
public SharingMarketBoard getSharingMarketBoard() {
	return sharingMarketBoard;
}
public void setSharingMarketBoard(SharingMarketBoard sharingMarketBoard) {
	this.sharingMarketBoard = sharingMarketBoard;
}


}

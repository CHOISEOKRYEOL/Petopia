package com.pms.petopia.domain;

public class SharingMarketBoardPhoto {

  private int no;
  private SharingMarketBoard sharingMarketBoard;
  private String photo;
  
@Override
public String toString() {
	return "SharingMarketBoardPhoto [no=" + no + ", sharingMarketBoard=" + sharingMarketBoard + ", photo=" + photo
			+ "]";
}
public int getNo() {
	return no;
}
public void setNo(int no) {
	this.no = no;
}
public SharingMarketBoard getSharingMarketBoard() {
	return sharingMarketBoard;
}
public void setSharingMarketBoard(SharingMarketBoard sharingMarketBoard) {
	this.sharingMarketBoard = sharingMarketBoard;
}
public String getPhoto() {
	return photo;
}
public void setPhoto(String photo) {
	this.photo = photo;
}

}

package com.pms.petopia.domain;

public class SharingMarketBoardPhoto {

  private int no;
  private SharingMarketBoard sharingmarketboard;
  private String photo;

  @Override
  public String toString() {
    return "SharingMarketBoardPhoto [no=" + no + ", sharingmarketboard=" + sharingmarketboard
        + ", photo=" + photo + "]";
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public SharingMarketBoard getSharingmarketboard() {
    return sharingmarketboard;
  }
  public void setSharingmarketboard(SharingMarketBoard sharingmarketboard) {
    this.sharingmarketboard = sharingmarketboard;
  }
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }


}

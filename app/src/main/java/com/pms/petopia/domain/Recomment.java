package com.pms.petopia.domain;

public class Recomment {

  private int no;
  private Member recommender;
  private MyTownBoard myTownBoard;

  public Member getRecommender() {
    return recommender;
  }
  public void setRecommender(Member recommender) {
    this.recommender = recommender;
  }
  public MyTownBoard getMyTownBoard() {
    return myTownBoard;
  }
  public void setMyTownBoard(MyTownBoard myTownBoard) {
    this.myTownBoard = myTownBoard;
  }

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }

}

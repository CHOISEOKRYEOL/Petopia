package com.pms.petopia.domain;

public class Recomment {

  private Member recommender;
  private MyTownBoard myTownBoard;

  @Override
  public String toString() {
    return "Recomment [recommender=" + recommender + ", myTownBoard=" + myTownBoard + "]";
  }

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

}

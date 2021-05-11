package com.pms.petopia.domain;

public class SmallAddress {

  private int no;
  private String name;
  private BigAddress bigAddress;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public BigAddress getBigAddress() {
    return bigAddress;
  }
  public void setBigAddress(BigAddress bigAddress) {
    this.bigAddress = bigAddress;
  }

}

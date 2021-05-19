package com.pms.petopia.domain;


public class SharingMarketBoardCategory {

  private int no;
  private String name;
  
@Override
public String toString() {
	return "SharingMarketBoardCategory [no=" + no + ", category=" + name + "]";
}

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

}

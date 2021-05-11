package com.pms.petopia.domain;

public class Hospital {

  private int no;
  private String name;
  private String tel;
  private String address;
  private String businessHour;
  private int parking;
  private int veterinarian;
  // private int rate;
  private Member admin;
  private int bigAddress;
  private int smallAddress;
  //  private float longitude;
  //  private float latitude;

  @Override
  public String toString() {
    return "Hospital [no=" + no + ", name=" + name + ", tel=" + tel + ", address=" + address
        + ", businessHour=" + businessHour + ", parking=" + parking + ", veterinarian="
        + veterinarian + ", admin=" + admin + ", bigAddress=" + bigAddress + ", smallAddress="
        + smallAddress + "]";
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
  public String getTel() {
    return tel;
  }
  public void setTel(String tel) {
    this.tel = tel;
  }
  public String getAddress() {
    return address;
  }
  public void setAddress(String address) {
    this.address = address;
  }
  public String getBusinessHour() {
    return businessHour;
  }
  public void setBusinessHour(String businessHour) {
    this.businessHour = businessHour;
  }
  public int getParking() {
    return parking;
  }
  public void setParking(int parking) {
    this.parking = parking;
  }
  public int getVeterinarian() {
    return veterinarian;
  }
  public void setVeterinarian(int veterinarian) {
    this.veterinarian = veterinarian;
  }
  public Member getAdmin() {
    return admin;
  }
  public void setAdmin(Member admin) {
    this.admin = admin;
  }

  public int getBigAddress() {
    return bigAddress;
  }

  public void setBigAddress(int bigAddress) {
    this.bigAddress = bigAddress;
  }

  public int getSmallAddress() {
    return smallAddress;
  }

  public void setSmallAddress(int smallAddress) {
    this.smallAddress = smallAddress;
  }


}

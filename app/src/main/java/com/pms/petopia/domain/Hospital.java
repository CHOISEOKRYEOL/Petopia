package com.pms.petopia.domain;

public class Hospital {

  private int no;
  private String name;
  private String tel;
  private boolean parking;
  private int veterinarian;
  private String businessHour;
  private int rate;
  private float longitude;
  private float latitude;

  @Override
  public String toString() {
    return "Hospital [no=" + no + ", name=" + name + ", tel=" + tel + ", parking=" + parking
        + ", veterinarian=" + veterinarian + ", businessHour=" + businessHour + ", rate=" + rate
        + ", longitude=" + longitude + ", latitude=" + latitude + "]";
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
  public boolean isParking() {
    return parking;
  }
  public void setParking(boolean parking) {
    this.parking = parking;
  }
  public int getVeterinarian() {
    return veterinarian;
  }
  public void setVeterinarian(int veterinarian) {
    this.veterinarian = veterinarian;
  }
  public String getBusinessHour() {
    return businessHour;
  }
  public void setBusinessHour(String businessHour) {
    this.businessHour = businessHour;
  }
  public int getRate() {
    return rate;
  }
  public void setRate(int rate) {
    this.rate = rate;
  }
  public float getLongitude() {
    return longitude;
  }
  public void setLongitude(float longitude) {
    this.longitude = longitude;
  }
  public float getLatitude() {
    return latitude;
  }
  public void setLatitude(float latitude) {
    this.latitude = latitude;
  }

}

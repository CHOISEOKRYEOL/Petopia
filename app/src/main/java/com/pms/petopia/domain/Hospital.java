package com.pms.petopia.domain;

public class Hospital {

  private int no;
  private String name;
  private String tel;
  private String address;
  private int startTime;
  private int endTime;
  private int parking;
  private int veterinarian;
  private String photo;
  private float rating;
  private float accumulatedRating;
  private BigAddress bigAddress;
  private SmallAddress smallAddress;
  private Review review;
  //  private float longitude;
  //  private float latitude;

  @Override
  public String toString() {
    return "Hospital [no=" + no + ", name=" + name + ", tel=" + tel + ", address=" + address
        + ", startTime=" + startTime + ", endTime=" + endTime + ", parking=" + parking
        + ", veterinarian=" + veterinarian + ", photo=" + photo + ", rating=" + rating
        + ", accumulatedRating=" + accumulatedRating + ", bigAddress=" + bigAddress
        + ", smallAddress=" + smallAddress + ", review=" + review + "]";
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
  public int getStartTime() {
    return startTime;
  }
  public void setStartTime(int startTime) {
    this.startTime = startTime;
  }
  public int getEndTime() {
    return endTime;
  }
  public void setEndTime(int endTime) {
    this.endTime = endTime;
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
  public String getPhoto() {
    return photo;
  }
  public void setPhoto(String photo) {
    this.photo = photo;
  }
  public float getRating() {
    return rating;
  }
  public void setRating(float rating) {
    this.rating = rating;
  }
  public float getAccumulatedRating() {
    return accumulatedRating;
  }
  public void setAccumulatedRating(float accumulatedRating) {
    this.accumulatedRating = accumulatedRating;
  }
  public BigAddress getBigAddress() {
    return bigAddress;
  }
  public void setBigAddress(BigAddress bigAddress) {
    this.bigAddress = bigAddress;
  }
  public SmallAddress getSmallAddress() {
    return smallAddress;
  }
  public void setSmallAddress(SmallAddress smallAddress) {
    this.smallAddress = smallAddress;
  }
  public Review getReview() {
    return review;
  }
  public void setReview(Review review) {
    this.review = review;
  }

}

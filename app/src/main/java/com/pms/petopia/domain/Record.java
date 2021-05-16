package com.pms.petopia.domain;

public class Record {
  private int no;
  private int state;
  private String record;
  private Pet pet;
  private Hospital hospital;

  public Record() {}

  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public String getRecord() {
    return record;
  }

  public void setRecord(String record) {
    this.record = record;
  }

  public Pet getPet() {
    return pet;
  }

  public void setPet(Pet pet) {
    this.pet = pet;
  }

  public Hospital getHospital() {
    return hospital;
  }

  public void setHospital(Hospital hospital) {
    this.hospital = hospital;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((hospital == null) ? 0 : hospital.hashCode());
    result = prime * result + ((pet == null) ? 0 : pet.hashCode());
    result = prime * result + ((record == null) ? 0 : record.hashCode());
    result = prime * result + state;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Record other = (Record) obj;
    if (hospital == null) {
      if (other.hospital != null)
        return false;
    } else if (!hospital.equals(other.hospital))
      return false;
    if (pet == null) {
      if (other.pet != null)
        return false;
    } else if (!pet.equals(other.pet))
      return false;
    if (record == null) {
      if (other.record != null)
        return false;
    } else if (!record.equals(other.record))
      return false;
    if (state != other.state)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Record [state=" + state + ", record=" + record + ", pet=" + pet + ", hospital="
        + hospital + "]";
  }




}

package com.pms.petopia.domain;

public class Record {
  private int no;
  private int state;
  private String record;
  private Pet petNo;
  private Hospital hospitalNo;

  public int getNo() {
    return no;
  }
  public void setNo(int no) {
    this.no = no;
  }
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
  public Pet getPetNo() {
    return petNo;
  }
  public void setPetNo(Pet petNo) {
    this.petNo = petNo;
  }
  public Hospital getHospitalNo() {
    return hospitalNo;
  }
  public void setHospitalNo(Hospital hospitalNo) {
    this.hospitalNo = hospitalNo;
  }
  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((hospitalNo == null) ? 0 : hospitalNo.hashCode());
    result = prime * result + no;
    result = prime * result + ((petNo == null) ? 0 : petNo.hashCode());
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
    if (hospitalNo == null) {
      if (other.hospitalNo != null)
        return false;
    } else if (!hospitalNo.equals(other.hospitalNo))
      return false;
    if (no != other.no)
      return false;
    if (petNo == null) {
      if (other.petNo != null)
        return false;
    } else if (!petNo.equals(other.petNo))
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
    return "Record [no=" + no + ", state=" + state + ", record=" + record + ", petNo=" + petNo
        + ", hospitalNo=" + hospitalNo + "]";
  }
}

package com.pms.petopia.domain;

public class Record {
  private int state;
  private String record;
  private PetMember petmember;

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

  public PetMember getPetmember() {
    return petmember;
  }

  public void setPetmember(PetMember petmember) {
    this.petmember = petmember;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((petmember == null) ? 0 : petmember.hashCode());
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
    if (petmember == null) {
      if (other.petmember != null)
        return false;
    } else if (!petmember.equals(other.petmember))
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
    return "Record [state=" + state + ", record=" + record + ", petmember=" + petmember + "]";
  }



}

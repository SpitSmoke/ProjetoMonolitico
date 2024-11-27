package dev.lobophf.domain;

public enum TelephoneType {
  LANDLINE("landline"), CELLPHONE("cellphone"), PUBLIC("public");

  private String description;

  TelephoneType(String description) {
    this.description = description;
  }

  public String getDescription() {
    return description;
  }

}

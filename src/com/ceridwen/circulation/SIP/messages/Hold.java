package com.ceridwen.circulation.SIP.messages;

public class Hold extends Message {
  private String holdMode;
  private java.util.Date transactionDate = new java.util.Date();
  private java.util.Date expirationDate;
  private String pickupLocation;
  private String holdType;
  private String institutionId;
  private String patronIdentifier;
  private String patronPassword;
  private String itemIdentifier;
  private String titleIdentifier;
  private String terminalPassword;
  private Boolean feeAckowledged;
  public String getCommand() {
    return "15";
  }
  public String getHoldMode() {
    return holdMode;
  }
  public void setHoldMode(String holdMode) {
    this.holdMode = holdMode;
  }
  public java.util.Date getTransactionDate() {
    return transactionDate;
  }
  public void setTransactionDate(java.util.Date transactionDate) {
    this.transactionDate = transactionDate;
  }
  public java.util.Date getExpirationDate() {
    return expirationDate;
  }
  public void setExpirationDate(java.util.Date expirationDate) {
    this.expirationDate = expirationDate;
  }
  public String getPickupLocation() {
    return pickupLocation;
  }
  public void setPickupLocation(String pickupLocation) {
    this.pickupLocation = pickupLocation;
  }
  public String getHoldType() {
    return holdType;
  }
  public void setHoldType(String holdType) {
    this.holdType = holdType;
  }
  public String getInstitutionId() {
    return institutionId;
  }
  public void setInstitutionId(String institutionId) {
    this.institutionId = institutionId;
  }
  public String getPatronIdentifier() {
    return patronIdentifier;
  }
  public void setPatronIdentifier(String patronIdentifier) {
    this.patronIdentifier = patronIdentifier;
  }
  public String getPatronPassword() {
    return patronPassword;
  }
  public void setPatronPassword(String patronPassword) {
    this.patronPassword = patronPassword;
  }
  public String getItemIdentifier() {
    return itemIdentifier;
  }
  public void setItemIdentifier(String itemIdentifier) {
    this.itemIdentifier = itemIdentifier;
  }
  public String getTitleIdentifier() {
    return titleIdentifier;
  }
  public void setTitleIdentifier(String titleIdentifier) {
    this.titleIdentifier = titleIdentifier;
  }
  public String getTerminalPassword() {
    return terminalPassword;
  }
  public void setTerminalPassword(String terminalPassword) {
    this.terminalPassword = terminalPassword;
  }
  public Boolean getFeeAckowledged() {
    return feeAckowledged;
  }
  public void setFeeAckowledged(Boolean feeAckowledged) {
    this.feeAckowledged = feeAckowledged;
  }
}

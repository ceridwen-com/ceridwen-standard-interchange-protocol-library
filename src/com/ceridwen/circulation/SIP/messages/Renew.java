package com.ceridwen.circulation.SIP.messages;

public class Renew extends Message {
  private boolean thirdPartyAllowed;
  private boolean noBlock;
  private java.util.Date transactionDate;
  private java.util.Date noBlockDueDate;
  private String institutionId;
  private String patronIdentifier;
  private String patronPassword;
  private String itemIdentifier;
  private String titleIdentifier;
  private String terminalPassword;
  private String itemProperties;
  private Boolean feeAcknowledged;
  public String getCommand() {
    return "29";
  }
  public boolean isThirdPartyAllowed() {
    return thirdPartyAllowed;
  }
  public void setThirdPartyAllowed(boolean thirdPartyAllowed) {
    this.thirdPartyAllowed = thirdPartyAllowed;
  }
  public boolean isNoBlock() {
    return noBlock;
  }
  public void setNoBlock(boolean noBlock) {
    this.noBlock = noBlock;
  }
  public java.util.Date getTransactionDate() {
    return transactionDate;
  }
  public void setTransactionDate(java.util.Date transactionDate) {
    this.transactionDate = transactionDate;
  }
  public java.util.Date getNoBlockDueDate() {
    return noBlockDueDate;
  }
  public void setNoBlockDueDate(java.util.Date noBlockDueDate) {
    this.noBlockDueDate = noBlockDueDate;
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
  public String getItemProperties() {
    return itemProperties;
  }
  public void setItemProperties(String itemProperties) {
    this.itemProperties = itemProperties;
  }
  public Boolean getFeeAcknowledged() {
    return feeAcknowledged;
  }
  public void setFeeAcknowledged(Boolean feeAcknowledged) {
    this.feeAcknowledged = feeAcknowledged;
  }
}

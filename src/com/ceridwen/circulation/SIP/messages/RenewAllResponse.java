package com.ceridwen.circulation.SIP.messages;

public class RenewAllResponse extends Message {
  private Boolean ok;
  private String renewedCount;
  private String unrenewedCount;
  private java.util.Date transactionDate = new java.util.Date();
  private String institutionId;
  private String screenMessage;
  private String printLine;
  public String getCommand() {
    return "66";
  }
  public Boolean getOk() {
    return ok;
  }
  public void setOk(Boolean ok) {
    this.ok = ok;
  }
  public String getRenewedCount() {
    return renewedCount;
  }
  public void setRenewedCount(String renewedCount) {
    this.renewedCount = renewedCount;
  }
  public String getUnrenewedCount() {
    return unrenewedCount;
  }
  public void setUnrenewedCount(String unrenewedCount) {
    this.unrenewedCount = unrenewedCount;
  }
  public java.util.Date getTransactionDate() {
    return transactionDate;
  }
  public void setTransactionDate(java.util.Date transactionDate) {
    this.transactionDate = transactionDate;
  }
  public String getInstitutionId() {
    return institutionId;
  }
  public void setInstitutionId(String institutionId) {
    this.institutionId = institutionId;
  }
  public String getScreenMessage() {
    return screenMessage;
  }
  public void setScreenMessage(String screenMessage) {
    this.screenMessage = screenMessage;
  }
  public String getPrintLine() {
    return printLine;
  }
  public void setPrintline(String printLine) {
    this.printLine = printLine;
  }
}

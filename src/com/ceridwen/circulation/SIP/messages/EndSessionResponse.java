package com.ceridwen.circulation.SIP.messages;

public class EndSessionResponse extends Message {
  private Boolean endSession;
  private String institutionId;
  private String patronIdentifier;
  private String screenMessage;
  private String printLine;
  private java.util.Date transactionDate;
  public String getCommand() {
    return "36";
  }
  public Boolean getEndSession() {
    return endSession;
  }
  public void setEndSession(Boolean endSession) {
    this.endSession = endSession;
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
  public String getPatronIdentifier() {
    return patronIdentifier;
  }
  public void setPatronIdentifier(String patronIdentifier) {
    this.patronIdentifier = patronIdentifier;
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
  public void setPrintLine(String printLine) {
    this.printLine = printLine;
  }
}

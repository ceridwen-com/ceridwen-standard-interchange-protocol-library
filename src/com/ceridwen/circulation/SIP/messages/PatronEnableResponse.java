package com.ceridwen.circulation.SIP.messages;

public class PatronEnableResponse extends Message {
  private String patronStatus;
  private String language;
  private java.util.Date transactionDate;
  private String institutionId;
  private String patronIdentifier;
  private String personalName;
  private Boolean validPatronPassword;
  private String screenMessage;
  private String printLine;
  private Boolean validPatron;
  public String getCommand() {
    return "26";
  }
  public String getPatronStatus() {
    return patronStatus;
  }
  public void setPatronStatus(String patronStatus) {
    this.patronStatus = patronStatus;
  }
  public String getLanguage() {
    return language;
  }
  public void setLanguage(String language) {
    this.language = language;
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
  public String getPersonalName() {
    return personalName;
  }
  public void setPersonalName(String personalName) {
    this.personalName = personalName;
  }
  public Boolean getValidPatron() {
    return validPatron;
  }
  public void setValidPatron(Boolean validPatron) {
    this.validPatron = validPatron;
  }
  public Boolean getValidPatronPassword() {
    return validPatronPassword;
  }
  public void setValidPatronPassword(Boolean validPatronPassword) {
    this.validPatronPassword = validPatronPassword;
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

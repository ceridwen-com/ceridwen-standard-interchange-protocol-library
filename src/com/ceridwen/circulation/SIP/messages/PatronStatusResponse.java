package com.ceridwen.circulation.SIP.messages;

import java.util.Date;

/**
 * <p>Title: RTSI</p>
 * <p>Description: Real Time Self Issue</p>
 * <p>Copyright: </p>

 * @author Matthew J. Dovey
 * @version 1.0
 */

public class PatronStatusResponse extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = 163945073911230183L;
private String patronStatus;
  private String language = "000";
  private Date transactionDate = new Date();
  private String institutionId;
  private String patronIdentifier;
  private String personalName;
  private Boolean validPatron;
  private Boolean validPatronPassword;
  private String currencyType;
  private String feeAmount;
  private String screenMessage;
  private String printLine;

  public String getCommand() {
    return "24";
  }
  public String getCurrencyType() {
    return currencyType;
  }
  public String getFeeAmount() {
    return feeAmount;
  }
  public String getInstitutionId() {
    return institutionId;
  }
  public String getLanguage() {
    return language;
  }
  public String getPrintLine() {
    return printLine;
  }
  public String getPatronIdentifier() {
    return patronIdentifier;
  }
  public String getPatronStatus() {
    return patronStatus;
  }
  public String getPersonalName() {
    return personalName;
  }
  public String getScreenMessage() {
    return screenMessage;
  }
  public Date getTransactionDate() {
    return transactionDate;
  }
  public Boolean getValidPatron() {
    return validPatron;
  }
  public Boolean getValidPatronPassword() {
    return validPatronPassword;
  }
  public void setValidPatronPassword(Boolean validPatronPassword) {
    this.validPatronPassword = validPatronPassword;
  }
  public void setValidPatron(Boolean validPatron) {
    this.validPatron = validPatron;
  }
  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }
  public void setScreenMessage(String screenMessage) {
    this.screenMessage = screenMessage;
  }
  public void setPrintLine(String printLine) {
    this.printLine = printLine;
  }
  public void setPersonalName(String personalName) {
    this.personalName = personalName;
  }
  public void setPatronStatus(String patronStatus) {
    this.patronStatus = patronStatus;
  }
  public void setPatronIdentifier(String patronIdentifier) {
    this.patronIdentifier = patronIdentifier;
  }
  public void setLanguage(String language) {
    this.language = language;
  }
  public void setInstitutionId(String institutionId) {
    this.institutionId = institutionId;
  }
  public void setFeeAmount(String feeAmount) {
    this.feeAmount = feeAmount;
  }
  public void setCurrencyType(String currencyType) {
    this.currencyType = currencyType;
  }
}

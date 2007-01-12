package com.ceridwen.circulation.SIP.messages;

public class FeePaid extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = -5641260852799759246L;
private java.util.Date transactionDate = new java.util.Date();
  private String feeType;
  private String paymentType;
  private String currencyType;
  private String feeAmount;
  private String institutionId;
  private String patronIdentifier;
  private String terminalPassword;
  private String patronPassword;
  private String feeIdentifier;
  private String transactionId;
  public String getCommand() {
    return "37";
  }
  public java.util.Date getTransactionDate() {
    return transactionDate;
  }
  public void setTransactionDate(java.util.Date transactionDate) {
    this.transactionDate = transactionDate;
  }
  public String getFeeType() {
    return feeType;
  }
  public void setFeeType(String feeType) {
    this.feeType = feeType;
  }
  public String getPaymentType() {
    return paymentType;
  }
  public void setPaymentType(String paymentType) {
    this.paymentType = paymentType;
  }
  public String getCurrencyType() {
    return currencyType;
  }
  public void setCurrencyType(String currencyType) {
    this.currencyType = currencyType;
  }
  public String getFeeAmount() {
    return feeAmount;
  }
  public void setFeeAmount(String feeAmount) {
    this.feeAmount = feeAmount;
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
  public String getTerminalPassword() {
    return terminalPassword;
  }
  public void setTerminalPassword(String terminalPassword) {
    this.terminalPassword = terminalPassword;
  }
  public String getPatronPassword() {
    return patronPassword;
  }
  public void setPatronPassword(String patronPassword) {
    this.patronPassword = patronPassword;
  }
  public String getFeeIdentifier() {
    return feeIdentifier;
  }
  public void setFeeIdentifier(String feeIdentifier) {
    this.feeIdentifier = feeIdentifier;
  }
  public String getTransactionId() {
    return transactionId;
  }
  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }
}

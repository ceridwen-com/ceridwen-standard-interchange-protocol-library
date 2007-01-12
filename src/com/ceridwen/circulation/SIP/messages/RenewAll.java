package com.ceridwen.circulation.SIP.messages;

public class RenewAll extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = -7106820916482094784L;
private java.util.Date transactionDate = new java.util.Date();
  private String institutionId;
  private String patronIdentifier;
  private String patronPassword;
  private String terminalPassword;
  private Boolean feeAcknowledged;
  public String getCommand() {
    return "65";
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
  public String getPatronPassword() {
    return patronPassword;
  }
  public void setPatronPassword(String patronPassword) {
    this.patronPassword = patronPassword;
  }
  public String getTerminalPassword() {
    return terminalPassword;
  }
  public void setTerminalPassword(String terminalPassword) {
    this.terminalPassword = terminalPassword;
  }
  public Boolean getFeeAcknowledged() {
    return feeAcknowledged;
  }
  public void setFeeAcknowledged(Boolean feeAcknowledged) {
    this.feeAcknowledged = feeAcknowledged;
  }
}

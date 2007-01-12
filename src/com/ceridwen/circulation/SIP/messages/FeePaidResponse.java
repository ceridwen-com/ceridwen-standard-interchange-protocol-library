package com.ceridwen.circulation.SIP.messages;

public class FeePaidResponse extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = 3684506970071368895L;
private Boolean paymentAccepted;
  private java.util.Date transactionDate = new java.util.Date();
  private String institutionId;
  private String patronIdentifier;
  private String transactionId;
  private String screenMessage;
  private String printLine;
  public String getCommand() {
    return "38";
  }
  public Boolean getPaymentAccepted() {
    return paymentAccepted;
  }
  public void setPaymentAccepted(Boolean paymentAccepted) {
    this.paymentAccepted = paymentAccepted;
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
  public String getTransactionId() {
    return transactionId;
  }
  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
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

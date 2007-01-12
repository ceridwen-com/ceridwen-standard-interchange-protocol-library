package com.ceridwen.circulation.SIP.messages;

public class BlockPatron extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = 7336173091305475737L;
private Boolean cardRetained;
  private java.util.Date transactionDate = new java.util.Date();
  private String institutionId;
  private String blockedCardMessage;
  private String patronIdentifier;
  private String terminalPassword;
  public String getCommand() {
    return "01";
  }
  public Boolean getCardRetained() {
    return cardRetained;
  }
  public void setCardRetained(Boolean cardRetained) {
    this.cardRetained = cardRetained;
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
  public String getBlockedCardMessage() {
    return blockedCardMessage;
  }
  public void setBlockedCardMessage(String blockedCardMessage) {
    this.blockedCardMessage = blockedCardMessage;
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

}

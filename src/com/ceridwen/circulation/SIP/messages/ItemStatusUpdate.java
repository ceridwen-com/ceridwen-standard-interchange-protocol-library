package com.ceridwen.circulation.SIP.messages;

public class ItemStatusUpdate extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = -2127793191374183987L;
private java.util.Date transactionDate = new java.util.Date();
  private String institutionId;
  private String itemIdentifier;
  private String terminalPassword;
  private String itemProperties;
  public String getCommand() {
    return "19";
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
  public String getItemIdentifier() {
    return itemIdentifier;
  }
  public void setItemIdentifier(String itemIdentifier) {
    this.itemIdentifier = itemIdentifier;
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
}

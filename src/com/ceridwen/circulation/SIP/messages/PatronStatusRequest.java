package com.ceridwen.circulation.SIP.messages;

import java.util.Date;

/**
 * <p>Title: RTSI</p>
 * <p>Description: Real Time Self Issue</p>
 * <p>Copyright: </p>

 * @author Matthew J. Dovey
 * @version 1.0
 */

public class PatronStatusRequest extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = -4867507215519281871L;
private String language = "000";
  private Date transactionDate = new Date();
  private String institutionId;
  private String patronIdentifier;
  private String terminalPassword;
  private String patronPassword;

  public String getCommand() {
    return "23";
  }
  public String getInstitutionId() {
    return institutionId;
  }
  public String getLanguage() {
    return language;
  }
  public String getPatronIdentifier() {
    return patronIdentifier;
  }
  public String getPatronPassword() {
    return patronPassword;
  }
  public String getTerminalPassword() {
    return terminalPassword;
  }
  public Date getTransactionDate() {
    return transactionDate;
  }
  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }
  public void setTerminalPassword(String terminalPassword) {
    this.terminalPassword = terminalPassword;
  }
  public void setPatronPassword(String patronPassword) {
    this.patronPassword = patronPassword;
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
}

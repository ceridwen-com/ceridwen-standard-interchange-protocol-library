/**
 * <p>Title: Self Issue</p>
 * <p>Description: Self Issue Client</p>
 * <p>Copyright: 2004,</p>
 * <p>Company: ceridwen.com</p>
 * @author Matthew J. Dovey
 * @version 2.1
 */

package com.ceridwen.circulation.SIP.messages;

import java.util.Date;

public class PatronInformation extends Message {
  private String language;
  private Date transactionDate;
  private String summary;
  private String institutionId;
  private String patronIdentifier;
  private String terminalPassword;
  private String patronPassword;
  private String startItem;
  private String endItem;

  public String getCommand() {
    return "63";
  }
  public String getEndItem() {
    return endItem;
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
  public String getStartItem() {
    return startItem;
  }
  public String getSummary() {
    return summary;
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
  public void setSummary(String summary) {
    this.summary = summary;
  }
  public void setStartItem(String startItem) {
    this.startItem = startItem;
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
  public void setEndItem(String endItem) {
    this.endItem = endItem;
  }
}

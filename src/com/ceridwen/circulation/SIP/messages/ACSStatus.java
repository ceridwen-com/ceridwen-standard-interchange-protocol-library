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

public class ACSStatus extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = -611426325284828647L;
private Boolean onLineStatus;
  private Boolean checkInOk;
  private Boolean checkOutOk;
  private Boolean renewalPolicy;
  private Boolean statusUpdateOk;
  private Boolean offlineOk;
  private String timeoutPeriod;
  private String retriesAllowed;
  private Date dateTimeSync = new Date();
  private String protocolVersion;
  private String institutionId;
  private String libraryName;
  private String supportedMessages;
  private String terminalLocation;
  private String screenMessage;
  private String printLine;

  public String getCommand() {
    return "98";
  }
  public Boolean isCheckInOk() {
    return checkInOk;
  }
  public Boolean isCheckOutOk() {
    return checkOutOk;
  }
  public Date getDateTimeSync() {
    return dateTimeSync;
  }
  public String getInstitutionId() {
    return institutionId;
  }
  public String getLibraryName() {
    return libraryName;
  }
  public Boolean isOfflineOk() {
    return offlineOk;
  }
  public Boolean isOnLineStatus() {
    return onLineStatus;
  }
  public String getPrintLine() {
    return printLine;
  }
  public String getProtocolVersion() {
    return protocolVersion;
  }
  public Boolean isRenewalPolicy() {
    return renewalPolicy;
  }
  public String getRetriesAllowed() {
    return retriesAllowed;
  }
  public String getScreenMessage() {
    return screenMessage;
  }
  public Boolean isStatusUpdateOk() {
    return statusUpdateOk;
  }
  public String getSupportedMessages() {
    return supportedMessages;
  }
  public String getTerminalLocation() {
    return terminalLocation;
  }
  public String getTimeoutPeriod() {
    return timeoutPeriod;
  }
  public void setTimeoutPeriod(String timeoutPeriod) {
    this.timeoutPeriod = timeoutPeriod;
  }
  public void setTerminalLocation(String terminalLocation) {
    this.terminalLocation = terminalLocation;
  }
  public void setSupportedMessages(String supportedMessages) {
    this.supportedMessages = supportedMessages;
  }
  public void setStatusUpdateOk(Boolean statusUpdateOk) {
    this.statusUpdateOk = statusUpdateOk;
  }
  public void setScreenMessage(String screenMessage) {
    this.screenMessage = screenMessage;
  }
  public void setRetriesAllowed(String retriesAllowed) {
    this.retriesAllowed = retriesAllowed;
  }
  public void setRenewalPolicy(Boolean renewalPolicy) {
    this.renewalPolicy = renewalPolicy;
  }
  public void setProtocolVersion(String protocolVersion) {
    this.protocolVersion = protocolVersion;
  }
  public void setPrintLine(String printLine) {
    this.printLine = printLine;
  }
  public void setOnLineStatus(Boolean onLineStatus) {
    this.onLineStatus = onLineStatus;
  }
  public void setOfflineOk(Boolean offlineOk) {
    this.offlineOk = offlineOk;
  }
  public void setLibraryName(String libraryName) {
    this.libraryName = libraryName;
  }
  public void setInstitutionId(String institutionId) {
    this.institutionId = institutionId;
  }
  public void setDateTimeSync(Date dateTimeSync) {
    this.dateTimeSync = dateTimeSync;
  }
  public void setCheckOutOk(Boolean checkOutOk) {
    this.checkOutOk = checkOutOk;
  }
  public void setCheckInOk(Boolean checkInOk) {
    this.checkInOk = checkInOk;
  }
}

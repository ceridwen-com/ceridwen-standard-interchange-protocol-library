/*******************************************************************************
 * Copyright (c) 2010 Matthew J. Dovey.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * <http://www.gnu.org/licenses/>.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     Matthew J. Dovey - initial API and implementation
 ******************************************************************************/
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

import com.ceridwen.circulation.SIP.types.flagfields.SupportedMessages;

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
  private Integer timeoutPeriod;
  private Integer retriesAllowed;
  private Date dateTimeSync = new Date();
  private String protocolVersion;
  private String institutionId;
  private String libraryName;
  private SupportedMessages supportedMessages = new SupportedMessages();
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
  public Integer getRetriesAllowed() {
    return retriesAllowed;
  }
  public String getScreenMessage() {
    return screenMessage;
  }
  public Boolean isStatusUpdateOk() {
    return statusUpdateOk;
  }
  public SupportedMessages getSupportedMessages() {
    return supportedMessages;
  }
  public String getTerminalLocation() {
    return terminalLocation;
  }
  public Integer getTimeoutPeriod() {
    return timeoutPeriod;
  }
  public void setTimeoutPeriod(Integer timeoutPeriod) {
    this.timeoutPeriod = timeoutPeriod;
  }
  public void setTerminalLocation(String terminalLocation) {
    this.terminalLocation = terminalLocation;
  }
  /**
   * Use getSupportedMessages().set(SupportedMessages.VALUE)
   *     getSupportedMessages().unset(SupportedMessages.VALUE)
   *     getSupportedMessages().unsetAll()
   *   
   * @param summary
   */  
  @Deprecated  
  public void setSupportedMessages(SupportedMessages supportedMessages) {
    this.supportedMessages = supportedMessages;
  }
  public void setStatusUpdateOk(Boolean statusUpdateOk) {
    this.statusUpdateOk = statusUpdateOk;
  }
  public void setScreenMessage(String screenMessage) {
    this.screenMessage = screenMessage;
  }
  public void setRetriesAllowed(Integer retriesAllowed) {
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

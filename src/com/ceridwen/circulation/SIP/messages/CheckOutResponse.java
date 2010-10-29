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

public class CheckOutResponse extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = 9222995766948881317L;
private Boolean ok;
  private Boolean renewalOk;
  private Boolean magenticMedia;
  private Boolean desensitize;
  private Date transactionDate = new Date();
  private String institutionId;
  private String patronIdentifier;
  private String itemIdentifier;
  private String titleIdentifier;
  private String dueDate;
  private String feeType;
  private Boolean securityInhibit;
  private String currencyType;
  private String feeAmount;
  private String mediaType;
  private String itemProperties;
  private String transactionId;
  private String screenMessage;
  private String printLine;

  public String getCommand() {
    return "12";
  }
  public String getCurrencyType() {
    return currencyType;
  }
  public Boolean getDesensitize() {
    return desensitize;
  }
  public String getDueDate() {
    return dueDate;
  }
  public String getFeeAmount() {
    return feeAmount;
  }
  public String getFeeType() {
    return feeType;
  }
  public String getInstitutionId() {
    return institutionId;
  }
  public String getItemIdentifier() {
    return itemIdentifier;
  }
  public String getItemProperties() {
    return itemProperties;
  }
  public Boolean getMagenticMedia() {
    return magenticMedia;
  }
  public String getMediaType() {
    return mediaType;
  }
  public Boolean getOk() {
    return ok;
  }
  public String getPatronIdentifier() {
    return patronIdentifier;
  }
  public String getPrintLine() {
    return printLine;
  }
  public Boolean getRenewalOk() {
    return renewalOk;
  }
  public String getScreenMessage() {
    return screenMessage;
  }
  public Boolean getSecurityInhibit() {
    return securityInhibit;
  }
  public String getTitleIdentifier() {
    return titleIdentifier;
  }
  public Date getTransactionDate() {
    return transactionDate;
  }
  public String getTransactionId() {
    return transactionId;
  }
  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }
  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }
  public void setTitleIdentifier(String titleIdentifier) {
    this.titleIdentifier = titleIdentifier;
  }
  public void setSecurityInhibit(Boolean securityInhibit) {
    this.securityInhibit = securityInhibit;
  }
  public void setScreenMessage(String screenMessage) {
    this.screenMessage = screenMessage;
  }
  public void setRenewalOk(Boolean renewalOk) {
    this.renewalOk = renewalOk;
  }
  public void setPrintLine(String printLine) {
    this.printLine = printLine;
  }
  public void setPatronIdentifier(String patronIdentifier) {
    this.patronIdentifier = patronIdentifier;
  }
  public void setOk(Boolean ok) {
    this.ok = ok;
  }
  public void setMediaType(String mediaType) {
    this.mediaType = mediaType;
  }
  public void setMagenticMedia(Boolean magenticMedia) {
    this.magenticMedia = magenticMedia;
  }
  public void setItemProperties(String itemProperties) {
    this.itemProperties = itemProperties;
  }
  public void setItemIdentifier(String itemIdentifier) {
    this.itemIdentifier = itemIdentifier;
  }
  public void setInstitutionId(String institutionId) {
    this.institutionId = institutionId;
  }
  public void setFeeType(String feeType) {
    this.feeType = feeType;
  }
  public void setFeeAmount(String feeAmount) {
    this.feeAmount = feeAmount;
  }
  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }
  public void setDesensitize(Boolean desensitize) {
    this.desensitize = desensitize;
  }
  public void setCurrencyType(String currencyType) {
    this.currencyType = currencyType;
  }
}

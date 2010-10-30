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
package com.ceridwen.circulation.SIP.messages;

import com.ceridwen.circulation.SIP.types.enumerations.CurrencyType;
import com.ceridwen.circulation.SIP.types.enumerations.FeeType;
import com.ceridwen.circulation.SIP.types.enumerations.MediaType;

public class RenewResponse extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = 434658072913047721L;
private Boolean ok;
  private Boolean renewalOk;
  private Boolean magneticMedia;
  private Boolean desensitize;
  private java.util.Date transactionDate = new java.util.Date();
  private String institutionId;
  private String patronIdentifier;
  private String itemIdentifier;
  private String titleIdentifier;
  private String dueDate;
  private FeeType feeType = FeeType.OTHER;
  private Boolean securityInhibit;
  private CurrencyType currencyType = CurrencyType.USDOLLAR;
  private String feeAmount;
  private MediaType mediaType = MediaType.OTHER;
  private String itemProperties;
  private String transactionId;
  private String screenMessage;
  private String printLine;
  public String getCommand() {
    return "30";
  }
  public Boolean getOk() {
    return ok;
  }
  public void setOk(Boolean ok) {
    this.ok = ok;
  }
  public Boolean getRenewalOk() {
    return renewalOk;
  }
  public void setRenewalOk(Boolean renewalOk) {
    this.renewalOk = renewalOk;
  }
  public Boolean getMagneticMedia() {
    return magneticMedia;
  }
  public void setMagneticMedia(Boolean magneticMedia) {
    this.magneticMedia = magneticMedia;
  }
  public Boolean getDesensitize() {
    return desensitize;
  }
  public void setDesensitize(Boolean desensitize) {
    this.desensitize = desensitize;
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
  public String getItemIdentifier() {
    return itemIdentifier;
  }
  public void setItemIdentifier(String itemIdentifier) {
    this.itemIdentifier = itemIdentifier;
  }
  public String getTitleIdentifier() {
    return titleIdentifier;
  }
  public void setTitleIdentifier(String titleIdentifier) {
    this.titleIdentifier = titleIdentifier;
  }
  public String getDueDate() {
    return dueDate;
  }
  public void setDueDate(String dueDate) {
    this.dueDate = dueDate;
  }
  public FeeType getFeeType() {
    return feeType;
  }
  public void setFeeType(FeeType feeType) {
    this.feeType = feeType;
  }
  public Boolean getSecurityInhibit() {
    return securityInhibit;
  }
  public void setSecurityInhibit(Boolean securityInhibit) {
    this.securityInhibit = securityInhibit;
  }
  public CurrencyType getCurrencyType() {
    return currencyType;
  }
  public void setCurrencyType(CurrencyType currencyType) {
    this.currencyType = currencyType;
  }
  public String getFeeAmount() {
    return feeAmount;
  }
  public void setFeeAmount(String feeAmount) {
    this.feeAmount = feeAmount;
  }
  public MediaType getMediaType() {
    return mediaType;
  }
  public void setMediaType(MediaType mediaType) {
    this.mediaType = mediaType;
  }
  public String getItemProperties() {
    return itemProperties;
  }
  public void setItemProperties(String itemProperties) {
    this.itemProperties = itemProperties;
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

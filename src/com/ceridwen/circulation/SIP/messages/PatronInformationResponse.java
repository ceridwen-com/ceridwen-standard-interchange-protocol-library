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

import java.util.Date;

import com.ceridwen.circulation.SIP.types.enumerations.CurrencyType;
import com.ceridwen.circulation.SIP.types.enumerations.Language;
import com.ceridwen.circulation.SIP.types.flagfields.PatronStatus;

/**
 * <p>Title: RTSI</p>
 * <p>Description: Real Time Self Issue</p>
 * <p>Copyright: </p>

 * @author Matthew J. Dovey
 * @version 1.0
 */

public class PatronInformationResponse extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = 5284231102576474180L;
  private PatronStatus patronStatus = new PatronStatus();
  private Language language = Language.UNKNOWN;
  private Date transactionDate = new Date();
  private String holdItemsCount;
  private String overdueItemsCount;
  private String chargedItemsCount;
  private String fineItemsCount;
  private String recallItemsCount;
  private String unavailableHoldsCount;
  private String institutionId;
  private String patronIdentifier;
  private String personalName;
  private String holdItemsLimit;
  private String overdueItemsLimit;
  private String chargedItemsLimit;
  private Boolean validPatron;
  private Boolean validPatronPassword;
  private CurrencyType currencyType = CurrencyType.USDOLLAR;
  private String feeAmount;
  private String feeLimit;
  private String[] holdItems;
  private String[] overdueItems;
  private String[] chargedItems;
  private String[] fineItems;
  private String[] recallItems;
  private String[] unavailableHoldItems;
  private String homeAddress;
  private String eMailAddress;
  private String homePhoneNumber;
  private String screenMessage;
  private String printLine;

  public String getCommand() {
    return "64";
  }
  public String[] getChargedItems() {
    return chargedItems;
  }
  public String getChargedItemsCount() {
    return chargedItemsCount;
  }
  public String getChargedItemsLimit() {
    return chargedItemsLimit;
  }
  public CurrencyType getCurrencyType() {
    return currencyType;
  }
  public String getEMailAddress() {
    return eMailAddress;
  }
  public String getFeeAmount() {
    return feeAmount;
  }
  public String getFeeLimit() {
    return feeLimit;
  }
  public String[] getFineItems() {
    return fineItems;
  }
  public String getFineItemsCount() {
    return fineItemsCount;
  }
  public String[] getHoldItems() {
    return holdItems;
  }
  public String getHoldItemsCount() {
    return holdItemsCount;
  }
  public String getHoldItemsLimit() {
    return holdItemsLimit;
  }
  public String getHomeAddress() {
    return homeAddress;
  }
  public String getHomePhoneNumber() {
    return homePhoneNumber;
  }
  public String getInstitutionId() {
    return institutionId;
  }
  public Language getLanguage() {
    return language;
  }
  public String[] getOverdueItems() {
    return overdueItems;
  }
  public String getOverdueItemsCount() {
    return overdueItemsCount;
  }
  public String getOverdueItemsLimit() {
    return overdueItemsLimit;
  }
  public String getPatronIdentifier() {
    return patronIdentifier;
  }
  public PatronStatus getPatronStatus() {
    return patronStatus;
  }
  public String getPersonalName() {
    return personalName;
  }
  public String getPrintLine() {
    return printLine;
  }
  public String[] getRecallItems() {
    return recallItems;
  }
  public String getRecallItemsCount() {
    return recallItemsCount;
  }
  public String getScreenMessage() {
    return screenMessage;
  }
  public Date getTransactionDate() {
    return transactionDate;
  }
  public String getUnavailableHoldsCount() {
    return unavailableHoldsCount;
  }
  public String[] getUnavailableHoldItems() {
    return unavailableHoldItems;
  }
  public Boolean getValidPatron() {
    return validPatron;
  }
  public Boolean getValidPatronPassword() {
    return validPatronPassword;
  }
  public void setValidPatronPassword(Boolean validPatronPassword) {
    this.validPatronPassword = validPatronPassword;
  }
  public void setValidPatron(Boolean validPatron) {
    this.validPatron = validPatron;
  }
  public void setUnavailableHoldItems(String[] unavailableHoldItems) {
    this.unavailableHoldItems = unavailableHoldItems;
  }
  public void setUnavailableHoldsCount(String unavailableHoldsCount) {
    this.unavailableHoldsCount = unavailableHoldsCount;
  }
  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }
  public void setScreenMessage(String screenMessage) {
    this.screenMessage = screenMessage;
  }
  public void setRecallItemsCount(String recallItemsCount) {
    this.recallItemsCount = recallItemsCount;
  }
  public void setRecallItems(String[] recallItems) {
    this.recallItems = recallItems;
  }
  public void setPrintLine(String printLine) {
    this.printLine = printLine;
  }
  public void setPersonalName(String personalName) {
    this.personalName = personalName;
  }
  @Deprecated  
  public void setPatronStatus(PatronStatus patronStatus) {
    this.patronStatus = patronStatus;
  }
  public void setPatronIdentifier(String patronIdentifier) {
    this.patronIdentifier = patronIdentifier;
  }
  public void setOverdueItemsLimit(String overdueItemsLimit) {
    this.overdueItemsLimit = overdueItemsLimit;
  }
  public void setOverdueItemsCount(String overdueItemsCount) {
    this.overdueItemsCount = overdueItemsCount;
  }
  public void setOverdueItems(String[] overdueItems) {
    this.overdueItems = overdueItems;
  }
  public void setLanguage(Language language) {
    this.language = language;
  }
  public void setInstitutionId(String institutionId) {
    this.institutionId = institutionId;
  }
  public void setHomePhoneNumber(String homePhoneNumber) {
    this.homePhoneNumber = homePhoneNumber;
  }
  public void setHomeAddress(String homeAddress) {
    this.homeAddress = homeAddress;
  }
  public void setHoldItemsLimit(String holdItemsLimit) {
    this.holdItemsLimit = holdItemsLimit;
  }
  public void setHoldItemsCount(String holdItemsCount) {
    this.holdItemsCount = holdItemsCount;
  }
  public void setHoldItems(String[] holdItems) {
    this.holdItems = holdItems;
  }
  public void setFineItemsCount(String fineItemsCount) {
    this.fineItemsCount = fineItemsCount;
  }
  public void setFineItems(String[] fineItems) {
    this.fineItems = fineItems;
  }
  public void setFeeLimit(String feeLimit) {
    this.feeLimit = feeLimit;
  }
  public void setFeeAmount(String feeAmount) {
    this.feeAmount = feeAmount;
  }
  public void setChargedItems(String[] chargedItems) {
    this.chargedItems = chargedItems;
  }
  public void setChargedItemsCount(String chargedItemsCount) {
    this.chargedItemsCount = chargedItemsCount;
  }
  public void setChargedItemsLimit(String chargedItemsLimit) {
    this.chargedItemsLimit = chargedItemsLimit;
  }
  public void setCurrencyType(CurrencyType currencyType) {
    this.currencyType = currencyType;
  }
  public void setEMailAddress(String eMailAddress) {
    this.eMailAddress = eMailAddress;
  }
}

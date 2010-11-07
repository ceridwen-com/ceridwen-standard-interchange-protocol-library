/*******************************************************************************
 * Copyright (c) 2010 Matthew J. Dovey (www.ceridwen.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at 
 * <http://www.gnu.org/licenses/>
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
 *     Matthew J. Dovey (www.ceridwen.com) - initial API and implementation
 ******************************************************************************/
package com.ceridwen.circulation.SIP.messages;

import java.util.Date;

import com.ceridwen.circulation.SIP.types.enumerations.CurrencyType;
import com.ceridwen.circulation.SIP.types.enumerations.Language;
import com.ceridwen.circulation.SIP.types.flagfields.PatronStatus;

/**
 * <p>Title: RTSI</p> <p>Description: Real Time Self Issue</p> <p>Copyright:
 * </p>
 * 
 * @author Matthew J. Dovey
 * @version 1.0
 */

public class PatronInformationResponse extends Message {
    /**
	 * 
	 */
    private static final long serialVersionUID = 5284231102576474180L;
    private PatronStatus patronStatus = new PatronStatus();
    private Language language;
    private Date transactionDate;
    private Integer holdItemsCount;
    private Integer overdueItemsCount;
    private Integer chargedItemsCount;
    private Integer fineItemsCount;
    private Integer recallItemsCount;
    private Integer unavailableHoldsCount;
    private String institutionId;
    private String patronIdentifier;
    private String personalName;
    private Integer holdItemsLimit;
    private Integer overdueItemsLimit;
    private Integer chargedItemsLimit;
    private Boolean validPatron;
    private Boolean validPatronPassword;
    private CurrencyType currencyType;
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

    @Override
    public String getCommand() {
        return "64";
    }

    public String[] getChargedItems() {
        return this.chargedItems;
    }

    public Integer getChargedItemsCount() {
        return this.chargedItemsCount;
    }

    public Integer getChargedItemsLimit() {
        return this.chargedItemsLimit;
    }

    public CurrencyType getCurrencyType() {
        return this.currencyType;
    }

    public String getEMailAddress() {
        return this.eMailAddress;
    }

    public String getFeeAmount() {
        return this.feeAmount;
    }

    public String getFeeLimit() {
        return this.feeLimit;
    }

    public String[] getFineItems() {
        return this.fineItems;
    }

    public Integer getFineItemsCount() {
        return this.fineItemsCount;
    }

    public String[] getHoldItems() {
        return this.holdItems;
    }

    public Integer getHoldItemsCount() {
        return this.holdItemsCount;
    }

    public Integer getHoldItemsLimit() {
        return this.holdItemsLimit;
    }

    public String getHomeAddress() {
        return this.homeAddress;
    }

    public String getHomePhoneNumber() {
        return this.homePhoneNumber;
    }

    public String getInstitutionId() {
        return this.institutionId;
    }

    public Language getLanguage() {
        return this.language;
    }

    public String[] getOverdueItems() {
        return this.overdueItems;
    }

    public Integer getOverdueItemsCount() {
        return this.overdueItemsCount;
    }

    public Integer getOverdueItemsLimit() {
        return this.overdueItemsLimit;
    }

    public String getPatronIdentifier() {
        return this.patronIdentifier;
    }

    public PatronStatus getPatronStatus() {
        return this.patronStatus;
    }

    public String getPersonalName() {
        return this.personalName;
    }

    public String getPrintLine() {
        return this.printLine;
    }

    public String[] getRecallItems() {
        return this.recallItems;
    }

    public Integer getRecallItemsCount() {
        return this.recallItemsCount;
    }

    public String getScreenMessage() {
        return this.screenMessage;
    }

    public Date getTransactionDate() {
        return this.transactionDate;
    }

    public Integer getUnavailableHoldsCount() {
        return this.unavailableHoldsCount;
    }

    public String[] getUnavailableHoldItems() {
        return this.unavailableHoldItems;
    }

    public Boolean isValidPatron() {
        return this.validPatron;
    }

    public Boolean isValidPatronPassword() {
        return this.validPatronPassword;
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

    public void setUnavailableHoldsCount(Integer unavailableHoldsCount) {
        this.unavailableHoldsCount = unavailableHoldsCount;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setScreenMessage(String screenMessage) {
        this.screenMessage = screenMessage;
    }

    public void setRecallItemsCount(Integer recallItemsCount) {
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

    public void setOverdueItemsLimit(Integer overdueItemsLimit) {
        this.overdueItemsLimit = overdueItemsLimit;
    }

    public void setOverdueItemsCount(Integer overdueItemsCount) {
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

    public void setHoldItemsLimit(Integer holdItemsLimit) {
        this.holdItemsLimit = holdItemsLimit;
    }

    public void setHoldItemsCount(Integer holdItemsCount) {
        this.holdItemsCount = holdItemsCount;
    }

    public void setHoldItems(String[] holdItems) {
        this.holdItems = holdItems;
    }

    public void setFineItemsCount(Integer fineItemsCount) {
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

    public void setChargedItemsCount(Integer chargedItemsCount) {
        this.chargedItemsCount = chargedItemsCount;
    }

    public void setChargedItemsLimit(Integer chargedItemsLimit) {
        this.chargedItemsLimit = chargedItemsLimit;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public void setEMailAddress(String eMailAddress) {
        this.eMailAddress = eMailAddress;
    }
}

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

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

import com.ceridwen.circulation.SIP.types.descriptors.PositionedFieldDescriptor;
import com.ceridwen.circulation.SIP.types.descriptors.TaggedFieldDescriptor;

/**
 * <p>Title: RTSI</p> <p>Description: Real Time Self Issue</p> <p>Copyright:
 * </p>
 * 
 * @author Matthew J. Dovey
 * @version 1.0
 */

public class PatronInformationResponseBeanInfo extends MessageBeanInfo {
    Class<PatronInformationResponse> beanClass = PatronInformationResponse.class;

    public PatronInformationResponseBeanInfo() {
    }

    public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
        PropertyDescriptor _chargedItems = new PropertyDescriptor("chargedItems", this.beanClass, "getChargedItems", "setChargedItems");
        PropertyDescriptor _chargedItemsCount = new PropertyDescriptor("chargedItemsCount", this.beanClass, "getChargedItemsCount", "setChargedItemsCount");
        PropertyDescriptor _chargedItemsLimit = new PropertyDescriptor("chargedItemsLimit", this.beanClass, "getChargedItemsLimit", "setChargedItemsLimit");
        PropertyDescriptor _currencyType = new PropertyDescriptor("currencyType", this.beanClass, "getCurrencyType", "setCurrencyType");
        PropertyDescriptor _eMailAddress = new PropertyDescriptor("eMailAddress", this.beanClass, "getEMailAddress", "setEMailAddress");
        PropertyDescriptor _feeAmount = new PropertyDescriptor("feeAmount", this.beanClass, "getFeeAmount", "setFeeAmount");
        PropertyDescriptor _feeLimit = new PropertyDescriptor("feeLimit", this.beanClass, "getFeeLimit", "setFeeLimit");
        PropertyDescriptor _fineItems = new PropertyDescriptor("fineItems", this.beanClass, "getFineItems", "setFineItems");
        PropertyDescriptor _fineItemsCount = new PropertyDescriptor("fineItemsCount", this.beanClass, "getFineItemsCount", "setFineItemsCount");
        PropertyDescriptor _holdItems = new PropertyDescriptor("holdItems", this.beanClass, "getHoldItems", "setHoldItems");
        PropertyDescriptor _holdItemsCount = new PropertyDescriptor("holdItemsCount", this.beanClass, "getHoldItemsCount", "setHoldItemsCount");
        PropertyDescriptor _holdItemsLimit = new PropertyDescriptor("holdItemsLimit", this.beanClass, "getHoldItemsLimit", "setHoldItemsLimit");
        PropertyDescriptor _homeAddress = new PropertyDescriptor("homeAddress", this.beanClass, "getHomeAddress", "setHomeAddress");
        PropertyDescriptor _homePhoneNumber = new PropertyDescriptor("homePhoneNumber", this.beanClass, "getHomePhoneNumber", "setHomePhoneNumber");
        PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", this.beanClass, "getInstitutionId", "setInstitutionId");
        PropertyDescriptor _language = new PropertyDescriptor("language", this.beanClass, "getLanguage", "setLanguage");
        PropertyDescriptor _overdueItems = new PropertyDescriptor("overdueItems", this.beanClass, "getOverdueItems", "setOverdueItems");
        PropertyDescriptor _overdueItemsCount = new PropertyDescriptor("overdueItemsCount", this.beanClass, "getOverdueItemsCount", "setOverdueItemsCount");
        PropertyDescriptor _overdueItemsLimit = new PropertyDescriptor("overdueItemsLimit", this.beanClass, "getOverdueItemsLimit", "setOverdueItemsLimit");
        PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", this.beanClass, "getPatronIdentifier", "setPatronIdentifier");
        PropertyDescriptor _patronStatus = new PropertyDescriptor("patronStatus", this.beanClass, "getPatronStatus", "setPatronStatus");
        PropertyDescriptor _personalName = new PropertyDescriptor("personalName", this.beanClass, "getPersonalName", "setPersonalName");
        PropertyDescriptor _printLine = new PropertyDescriptor("printLine", this.beanClass, "getPrintLine", "setPrintLine");
        PropertyDescriptor _recallItems = new PropertyDescriptor("recallItems", this.beanClass, "getRecallItems", "setRecallItems");
        PropertyDescriptor _recallItemsCount = new PropertyDescriptor("recallItemsCount", this.beanClass, "getRecallItemsCount", "setRecallItemsCount");
        PropertyDescriptor _screenMessage = new PropertyDescriptor("screenMessage", this.beanClass, "getScreenMessage", "setScreenMessage");
        PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", this.beanClass, "getTransactionDate", "setTransactionDate");
        PropertyDescriptor _unavailableHoldsCount = new PropertyDescriptor("unavailableHoldsCount", this.beanClass, "getUnavailableHoldsCount",
                "setUnavailableHoldsCount");
        PropertyDescriptor _unavailableHoldItems = new PropertyDescriptor("unavailableHoldItems", this.beanClass, "getUnavailableHoldItems",
                "setUnavailableHoldItems");
        PropertyDescriptor _validPatron = new PropertyDescriptor("validPatron", this.beanClass, "isValidPatron", "setValidPatron");
        PropertyDescriptor _validPatronPassword = new PropertyDescriptor("validPatronPassword", this.beanClass, "isValidPatronPassword",
                "setValidPatronPassword");

        _patronStatus.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2, 15));
        _language.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(16, 18));
        _transactionDate.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(19, 36));
        _holdItemsCount.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(37, 40));
        _overdueItemsCount.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(41, 44));
        _chargedItemsCount.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(45, 48));
        _fineItemsCount.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(49, 52));
        _recallItemsCount.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(53, 56));
        _unavailableHoldsCount.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(57, 60));

        _currencyType.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _feeAmount.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _patronIdentifier.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(true));

        PropertyDescriptor[] pds = new PropertyDescriptor[] {
                _chargedItems,
                _chargedItemsCount,
                _chargedItemsLimit,
                _currencyType,
                _eMailAddress,
                _feeAmount,
                _feeLimit,
                _fineItems,
                _fineItemsCount,
                _holdItems,
                _holdItemsCount,
                _holdItemsLimit,
                _homeAddress,
                _homePhoneNumber,
                _institutionId,
                _language,
                _overdueItems,
                _overdueItemsCount,
                _overdueItemsLimit,
                _patronIdentifier,
                _patronStatus,
                _personalName,
                _printLine,
                _recallItems,
                _recallItemsCount,
                _screenMessage,
                _transactionDate,
                _unavailableHoldsCount,
                _unavailableHoldItems,
                _validPatron,
                _validPatronPassword };
        return pds;
    }
}

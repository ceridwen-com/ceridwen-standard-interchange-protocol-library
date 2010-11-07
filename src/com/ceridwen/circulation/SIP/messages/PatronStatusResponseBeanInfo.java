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

public class PatronStatusResponseBeanInfo extends MessageBeanInfo {
    Class<PatronStatusResponse> beanClass = PatronStatusResponse.class;

    public PatronStatusResponseBeanInfo() {
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
        PropertyDescriptor _currencyType = new PropertyDescriptor("currencyType", this.beanClass, "getCurrencyType", "setCurrencyType");
        PropertyDescriptor _feeAmount = new PropertyDescriptor("feeAmount", this.beanClass, "getFeeAmount", "setFeeAmount");
        PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", this.beanClass, "getInstitutionId", "setInstitutionId");
        PropertyDescriptor _language = new PropertyDescriptor("language", this.beanClass, "getLanguage", "setLanguage");
        PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", this.beanClass, "getPatronIdentifier", "setPatronIdentifier");
        PropertyDescriptor _patronStatus = new PropertyDescriptor("patronStatus", this.beanClass, "getPatronStatus", "setPatronStatus");
        PropertyDescriptor _personalName = new PropertyDescriptor("personalName", this.beanClass, "getPersonalName", "setPersonalName");
        PropertyDescriptor _printLine = new PropertyDescriptor("printLine", this.beanClass, "getPrintLine", "setPrintLine");
        PropertyDescriptor _screenMessage = new PropertyDescriptor("screenMessage", this.beanClass, "getScreenMessage", "setScreenMessage");
        PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", this.beanClass, "getTransactionDate", "setTransactionDate");
        PropertyDescriptor _validPatron = new PropertyDescriptor("validPatron", this.beanClass, "isValidPatron", "setValidPatron");
        PropertyDescriptor _validPatronPassword = new PropertyDescriptor("validPatronPassword", this.beanClass, "isValidPatronPassword",
                "setValidPatronPassword");

        _patronStatus.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2, 15));
        _language.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(16, 18));
        _transactionDate.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(19, 36));

        _currencyType.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _feeAmount.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _patronIdentifier.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(true));

        PropertyDescriptor[] pds = new PropertyDescriptor[] {
                _currencyType,
                _feeAmount,
                _institutionId,
                _language,
                _patronIdentifier,
                _patronStatus,
                _personalName,
                _printLine,
                _screenMessage,
                _transactionDate,
                _validPatron,
                _validPatronPassword };
        return pds;
    }
}

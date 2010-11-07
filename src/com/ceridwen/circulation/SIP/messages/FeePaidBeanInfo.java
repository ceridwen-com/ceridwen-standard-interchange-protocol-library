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
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * 
 * @author not attributable
 * @version 1.0
 */

public class FeePaidBeanInfo extends MessageBeanInfo {
    Class<FeePaid> beanClass = FeePaid.class;

    public FeePaidBeanInfo() {
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
        PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", this.beanClass, "getTransactionDate", "setTransactionDate");
        PropertyDescriptor _feeType = new PropertyDescriptor("feeType", this.beanClass, "getFeeType", "setFeeType");
        PropertyDescriptor _paymentType = new PropertyDescriptor("paymentType", this.beanClass, "getPaymentType", "setPaymentType");
        PropertyDescriptor _currencyType = new PropertyDescriptor("currencyType", this.beanClass, "getCurrencyType", "setCurrencyType");
        PropertyDescriptor _feeAmount = new PropertyDescriptor("feeAmount", this.beanClass, "getFeeAmount", "setFeeAmount");
        PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", this.beanClass, "getInstitutionId", "setInstitutionId");
        PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", this.beanClass, "getPatronIdentifier", "setPatronIdentifier");
        PropertyDescriptor _terminalPassword = new PropertyDescriptor("terminalPassword", this.beanClass, "getTerminalPassword", "setTerminalPassword");
        PropertyDescriptor _patronPassword = new PropertyDescriptor("patronPassword", this.beanClass, "getPatronPassword", "setPatronPassword");
        PropertyDescriptor _feeIdentifier = new PropertyDescriptor("feeIdentifier", this.beanClass, "getFeeIdentifier", "setFeeIdentifier");
        PropertyDescriptor _transactionId = new PropertyDescriptor("transactionId", this.beanClass, "getTransactionId", "setTransactionId");

        _transactionDate.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2, 19));
        _feeType.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(20, 21, true));
        _paymentType.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(22, 23));
        _currencyType.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(24, 26, true));

        _feeAmount.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(true));
        _patronIdentifier.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(true));
        _patronPassword.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _terminalPassword.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));

        PropertyDescriptor[] pds = new PropertyDescriptor[] {
                _transactionDate,
                _feeType,
                _paymentType,
                _currencyType,
                _feeAmount,
                _institutionId,
                _patronIdentifier,
                _terminalPassword,
                _patronPassword,
                _feeIdentifier,
                _transactionId };
        return pds;
    }
}

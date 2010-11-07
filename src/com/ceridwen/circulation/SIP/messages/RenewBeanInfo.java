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

public class RenewBeanInfo extends MessageBeanInfo {
    Class<Renew> beanClass = Renew.class;

    public RenewBeanInfo() {
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
        PropertyDescriptor _thirdPartyAllowed = new PropertyDescriptor("thirdPartyAllowed", this.beanClass, "isThirdPartyAllowed", "setThirdPartyAllowed");
        PropertyDescriptor _noBlock = new PropertyDescriptor("noBlock", this.beanClass, "isNoBlock", "setNoBlock");
        PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", this.beanClass, "getTransactionDate", "setTransactionDate");
        PropertyDescriptor _nbDueDate = new PropertyDescriptor("nbDueDate", this.beanClass, "getNbDueDate", "setNbDueDate");
        PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", this.beanClass, "getInstitutionId", "setInstitutionId");
        PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", this.beanClass, "getPatronIdentifier", "setPatronIdentifier");
        PropertyDescriptor _patronPassword = new PropertyDescriptor("patronPassword", this.beanClass, "getPatronPassword", "setPatronPassword");
        PropertyDescriptor _itemIdentifier = new PropertyDescriptor("itemIdentifier", this.beanClass, "getItemIdentifier", "setItemIdentifier");
        PropertyDescriptor _titleIdentifier = new PropertyDescriptor("titleIdentifier", this.beanClass, "getTitleIdentifier", "setTitleIdentifier");
        PropertyDescriptor _terminalPassword = new PropertyDescriptor("terminalPassword", this.beanClass, "getTerminalPassword", "setTerminalPassword");
        PropertyDescriptor _itemProperties = new PropertyDescriptor("itemProperties", this.beanClass, "getItemProperties", "setItemProperties");
        PropertyDescriptor _feeAcknowledged = new PropertyDescriptor("feeAcknowledged", this.beanClass, "isFeeAcknowledged", "setFeeAcknowledged");

        _thirdPartyAllowed.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2, 2));
        _noBlock.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(3, 3));
        _transactionDate.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(4, 21));
        _nbDueDate.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(22, 39));

        _itemIdentifier.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _itemProperties.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _patronIdentifier.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(true));
        _patronPassword.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _terminalPassword.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _titleIdentifier.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));

        PropertyDescriptor[] pds = new PropertyDescriptor[] {
                _thirdPartyAllowed,
                _noBlock,
                _transactionDate,
                _nbDueDate,
                _institutionId,
                _patronIdentifier,
                _patronPassword,
                _itemIdentifier,
                _titleIdentifier,
                _terminalPassword,
                _itemProperties,
                _feeAcknowledged };
        return pds;
    }
}

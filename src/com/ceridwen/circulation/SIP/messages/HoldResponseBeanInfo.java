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

public class HoldResponseBeanInfo extends MessageBeanInfo {
    Class<HoldResponse> beanClass = HoldResponse.class;

    public HoldResponseBeanInfo() {
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
        PropertyDescriptor _ok = new PropertyDescriptor("ok", this.beanClass, "isOk", "setOk");
        PropertyDescriptor _available = new PropertyDescriptor("available", this.beanClass, "isAvailable", "setAvailable");
        PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", this.beanClass, "getTransactionDate", "setTransactionDate");
        PropertyDescriptor _expirationDate = new PropertyDescriptor("expirationDate", this.beanClass, "getExpirationDate", "setExpirationDate");
        PropertyDescriptor _queuePosition = new PropertyDescriptor("queuePosition", this.beanClass, "getQueuePosition", "setQueuePosition");
        PropertyDescriptor _pickupLocation = new PropertyDescriptor("pickupLocation", this.beanClass, "getPickupLocation", "setPickupLocation");
        PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", this.beanClass, "getInstitutionId", "setInstitutionId");
        PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", this.beanClass, "getPatronIdentifier", "setPatronIdentifier");
        PropertyDescriptor _itemIdentifier = new PropertyDescriptor("itemIdentifier", this.beanClass, "getItemIdentifier", "setItemIdentifier");
        PropertyDescriptor _titleIdentifier = new PropertyDescriptor("titleIdentifier", this.beanClass, "getTitleIdentifier", "setTitleIdentifier");
        PropertyDescriptor _screenMessage = new PropertyDescriptor("screenMessage", this.beanClass, "getScreenMessage", "setScreenMessage");
        PropertyDescriptor _printLine = new PropertyDescriptor("printLine", this.beanClass, "getPrintLine", "setPrintLine");

        _ok.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2, 2));
        _available.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(3, 3));
        _transactionDate.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(4, 21));

        _patronIdentifier.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(true));
        _itemIdentifier.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _titleIdentifier.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));

        PropertyDescriptor[] pds = new PropertyDescriptor[] {
                _ok,
                _available,
                _transactionDate,
                _expirationDate,
                _queuePosition,
                _pickupLocation,
                _institutionId,
                _patronIdentifier,
                _itemIdentifier,
                _titleIdentifier,
                _screenMessage,
                _printLine };
        return pds;
    }
}

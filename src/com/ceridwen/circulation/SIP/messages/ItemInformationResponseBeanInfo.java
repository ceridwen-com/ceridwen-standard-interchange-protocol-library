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
/**
 * <p>Title: Self Issue</p>
 * <p>Description: Self Issue Client</p>
 * <p>Copyright: 2004,</p>
 * <p>Company: ceridwen.com</p>
 * @author Matthew J. Dovey
 * @version 2.1
 */

package com.ceridwen.circulation.SIP.messages;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

import com.ceridwen.circulation.SIP.types.descriptors.PositionedFieldDescriptor;
import com.ceridwen.circulation.SIP.types.descriptors.TaggedFieldDescriptor;

public class ItemInformationResponseBeanInfo extends MessageBeanInfo {
    Class<ItemInformationResponse> beanClass = ItemInformationResponse.class;

    public ItemInformationResponseBeanInfo() {
    }

    @Override
    public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
        PropertyDescriptor _circulationStatus = new PropertyDescriptor("circulationStatus", this.beanClass, "getCirculationStatus", "setCirculationStatus");
        PropertyDescriptor _currencyType = new PropertyDescriptor("currencyType", this.beanClass, "getCurrencyType", "setCurrencyType");
        PropertyDescriptor _currentLocation = new PropertyDescriptor("currentLocation", this.beanClass, "getCurrentLocation", "setCurrentLocation");
        PropertyDescriptor _dueDate = new PropertyDescriptor("dueDate", this.beanClass, "getDueDate", "setDueDate");
        PropertyDescriptor _feeAmount = new PropertyDescriptor("feeAmount", this.beanClass, "getFeeAmount", "setFeeAmount");
        PropertyDescriptor _feeType = new PropertyDescriptor("feeType", this.beanClass, "getFeeType", "setFeeType");
        PropertyDescriptor _holdPickupDate = new PropertyDescriptor("holdPickupDate", this.beanClass, "getHoldPickupDate", "setHoldPickupDate");
        PropertyDescriptor _holdQueueLength = new PropertyDescriptor("holdQueueLength", this.beanClass, "getHoldQueueLength", "setHoldQueueLength");
        PropertyDescriptor _itemIdentifier = new PropertyDescriptor("itemIdentifier", this.beanClass, "getItemIdentifier", "setItemIdentifier");
        PropertyDescriptor _itemProperties = new PropertyDescriptor("itemProperties", this.beanClass, "getItemProperties", "setItemProperties");
        PropertyDescriptor _mediaType = new PropertyDescriptor("mediaType", this.beanClass, "getMediaType", "setMediaType");
        PropertyDescriptor _owner = new PropertyDescriptor("owner", this.beanClass, "getOwner", "setOwner");
        PropertyDescriptor _permanentLocation = new PropertyDescriptor("permanentLocation", this.beanClass, "getPermanentLocation", "setPermanentLocation");
        PropertyDescriptor _printLine = new PropertyDescriptor("printLine", this.beanClass, "getPrintLine", "setPrintLine");
        PropertyDescriptor _recallDate = new PropertyDescriptor("recallDate", this.beanClass, "getRecallDate", "setRecallDate");
        PropertyDescriptor _screenMessage = new PropertyDescriptor("screenMessage", this.beanClass, "getScreenMessage", "setScreenMessage");
        PropertyDescriptor _securityMarker = new PropertyDescriptor("securityMarker", this.beanClass, "getSecurityMarker", "setSecurityMarker");
        PropertyDescriptor _titleIdentifier = new PropertyDescriptor("titleIdentifier", this.beanClass, "getTitleIdentifier", "setTitleIdentifier");
        PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", this.beanClass, "getTransactionDate", "setTransactionDate");

        _circulationStatus.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2, 3));
        _securityMarker.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(4, 5));
        _feeType.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(6, 7, true));
        _transactionDate.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(8, 25));

        _currencyType.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _currentLocation.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _dueDate.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _feeAmount.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _itemIdentifier.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(true));
        _itemProperties.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _permanentLocation.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
        _titleIdentifier.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(true));

        PropertyDescriptor[] pds = new PropertyDescriptor[] {
                _circulationStatus,
                _currencyType,
                _currentLocation,
                _dueDate,
                _feeAmount,
                _feeType,
                _holdPickupDate,
                _holdQueueLength,
                _itemIdentifier,
                _itemProperties,
                _mediaType,
                _owner,
                _permanentLocation,
                _printLine,
                _recallDate,
                _screenMessage,
                _securityMarker,
                _titleIdentifier,
                _transactionDate };
        return pds;
    }
}

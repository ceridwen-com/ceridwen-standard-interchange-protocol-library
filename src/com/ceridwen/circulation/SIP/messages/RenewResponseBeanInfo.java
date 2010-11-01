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

import java.beans.*;

import com.ceridwen.circulation.SIP.types.descriptors.PositionedFieldDescriptor;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class RenewResponseBeanInfo extends MessageBeanInfo {
  Class<RenewResponse> beanClass = RenewResponse.class;
  public RenewResponseBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
      PropertyDescriptor _ok = new PropertyDescriptor("ok", beanClass, "getOk", "setOk");
      PropertyDescriptor _renewalOk = new PropertyDescriptor("renewalOk", beanClass, "getRenewalOk", "setRenewalOk");
      PropertyDescriptor _magneticMedia = new PropertyDescriptor("magneticMedia", beanClass, "getMagneticMedia", "setMagneticMedia");
      PropertyDescriptor _desensitize = new PropertyDescriptor("desensitize", beanClass, "getDesensitize", "setDesensitize");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");

      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", beanClass, "getPatronIdentifier", "setPatronIdentifier");
      PropertyDescriptor _itemIdentifier = new PropertyDescriptor("itemIdentifier", beanClass, "getItemIdentifier", "setItemIdentifier");
      PropertyDescriptor _titleIdentifier = new PropertyDescriptor("titleIdentifier", beanClass, "getTitleIdentifier", "setTitleIdentifier");
      PropertyDescriptor _dueDate = new PropertyDescriptor("dueDate", beanClass, "getDueDate", "setDueDate");
      PropertyDescriptor _feeType = new PropertyDescriptor("feeType", beanClass, "getFeeType", "setFeeType");
      PropertyDescriptor _securityInhibit = new PropertyDescriptor("securityInhibit", beanClass, "getSecurityInhibit", "setSecurityInhibit");
      PropertyDescriptor _currencyType = new PropertyDescriptor("currencyType", beanClass, "getCurrencyType", "setCurrencyType");
      PropertyDescriptor _feeAmount = new PropertyDescriptor("feeAmount", beanClass, "getFeeAmount", "setFeeAmount");
      PropertyDescriptor _mediaType = new PropertyDescriptor("mediaType", beanClass, "getMediaType", "setMediaType");
      PropertyDescriptor _itemProperties = new PropertyDescriptor("itemProperties", beanClass, "getItemProperties", "setItemProperties");
      PropertyDescriptor _transactionId = new PropertyDescriptor("transactionId", beanClass, "getTransactionId", "setTransactionId");
      PropertyDescriptor _screenMessage = new PropertyDescriptor("screenMessage", beanClass, "getScreenMessage", "setScreenMessage");
      PropertyDescriptor _printLine = new PropertyDescriptor("printLine", beanClass, "getPrintLine", "setPrintLine");

      _ok.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2,2));
      _renewalOk.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(3,3));
      _magneticMedia.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(4,4));
      _desensitize.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(5,5));
      _transactionDate.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(6,23));

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _currencyType,
        _desensitize,
        _dueDate,
        _feeAmount,
        _feeType,
        _institutionId,
        _itemIdentifier,
        _itemProperties,
        _magneticMedia,
        _mediaType,
        _ok,
        _patronIdentifier,
        _printLine,
        _renewalOk,
        _screenMessage,
        _securityInhibit,
        _titleIdentifier,
        _transactionDate,
        _transactionId};
      return pds;
  }
}

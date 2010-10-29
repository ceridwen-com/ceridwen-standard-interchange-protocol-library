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
import com.ceridwen.circulation.SIP.helpers.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class RenewResponseBeanInfo extends SimpleBeanInfo {
  Class<RenewResponse> beanClass = RenewResponse.class;
  String iconColor16x16Filename;
  String iconColor32x32Filename;
  String iconMono16x16Filename;
  String iconMono32x32Filename;

  public RenewResponseBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptors() {
    try {
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

      _ok.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(2,2));
      _renewalOk.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(3,3));
      _magneticMedia.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(4,4));
      _desensitize.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(5,5));
      _transactionDate.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(6,23));

      _institutionId.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AO"));
      _patronIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AA"));
      _itemIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AB"));
      _titleIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AJ"));
      _dueDate.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AH"));
      _feeType.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BT"));
      _securityInhibit.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CI"));
      _currencyType.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BH"));
      _feeAmount.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BV"));
      _mediaType.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CK"));
      _itemProperties.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CH"));
      _transactionId.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BK"));
      _screenMessage.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AF"));
      _printLine.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AG"));

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
    catch(IntrospectionException ex) {
      ex.printStackTrace();
      return null;
    }
  }
  public java.awt.Image getIcon(int iconKind) {
    switch (iconKind) {
      case BeanInfo.ICON_COLOR_16x16:
        return iconColor16x16Filename != null ? loadImage(iconColor16x16Filename) : null;
      case BeanInfo.ICON_COLOR_32x32:
        return iconColor32x32Filename != null ? loadImage(iconColor32x32Filename) : null;
      case BeanInfo.ICON_MONO_16x16:
        return iconMono16x16Filename != null ? loadImage(iconMono16x16Filename) : null;
      case BeanInfo.ICON_MONO_32x32:
        return iconMono32x32Filename != null ? loadImage(iconMono32x32Filename) : null;
    }
    return null;
  }
}

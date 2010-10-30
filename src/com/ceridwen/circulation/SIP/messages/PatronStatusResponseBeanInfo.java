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
import com.ceridwen.circulation.SIP.types.descriptors.FixedFieldDescriptor;
import com.ceridwen.circulation.SIP.types.descriptors.VariableFieldDescriptor;


/**
 * <p>Title: RTSI</p>
 * <p>Description: Real Time Self Issue</p>
 * <p>Copyright: </p>

 * @author Matthew J. Dovey
 * @version 1.0
 */

public class PatronStatusResponseBeanInfo extends SimpleBeanInfo {
  Class<PatronStatusResponse> beanClass = PatronStatusResponse.class;
  String iconColor16x16Filename;
  String iconColor32x32Filename;
  String iconMono16x16Filename;
  String iconMono32x32Filename;

  public PatronStatusResponseBeanInfo() {
  }

  public PropertyDescriptor[] getPropertyDescriptors() {
    try {
      PropertyDescriptor _currencyType = new PropertyDescriptor("currencyType", beanClass, "getCurrencyType", "setCurrencyType");
      PropertyDescriptor _feeAmount = new PropertyDescriptor("feeAmount", beanClass, "getFeeAmount", "setFeeAmount");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _language = new PropertyDescriptor("language", beanClass, "getLanguage", "setLanguage");
      PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", beanClass, "getPatronIdentifier", "setPatronIdentifier");
      PropertyDescriptor _patronStatus = new PropertyDescriptor("patronStatus", beanClass, "getPatronStatus", "setPatronStatus");
      PropertyDescriptor _personalName = new PropertyDescriptor("personalName", beanClass, "getPersonalName", "setPersonalName");
      PropertyDescriptor _printLine = new PropertyDescriptor("printLine", beanClass, "getPrintLine", "setPrintLine");
      PropertyDescriptor _screenMessage = new PropertyDescriptor("screenMessage", beanClass, "getScreenMessage", "setScreenMessage");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");
      PropertyDescriptor _validPatron = new PropertyDescriptor("validPatron", beanClass, "getValidPatron", "setValidPatron");
      PropertyDescriptor _validPatronPassword = new PropertyDescriptor("validPatronPassword", beanClass, "getValidPatronPassword", "setValidPatronPassword");

      _patronStatus.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(2, 15));
      _language.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(16,18));
      _transactionDate.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(19,36));

      _institutionId.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AO"));
      _patronIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AA"));
      _personalName.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AE"));
      _validPatron.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BL", true));
      _validPatronPassword.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CQ", true));
      _currencyType.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BH", true));
      _feeAmount.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BV", true));
      _screenMessage.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AF", true));
      _printLine.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AG", true));

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
        _validPatronPassword};
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
  public BeanInfo[] getAdditionalBeanInfo() {
    Class<?> superclass = beanClass.getSuperclass();
    try {
      BeanInfo superBeanInfo = Introspector.getBeanInfo(superclass);
      return new BeanInfo[] { superBeanInfo };
    }
    catch(IntrospectionException ex) {
      ex.printStackTrace();
      return null;
    }
  }
}

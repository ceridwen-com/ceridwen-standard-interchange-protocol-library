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
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class FeePaidBeanInfo extends SimpleBeanInfo {
  Class<FeePaid> beanClass = FeePaid.class;
  String iconColor16x16Filename;
  String iconColor32x32Filename;
  String iconMono16x16Filename;
  String iconMono32x32Filename;

  public FeePaidBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptors() {
    try {
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");
      PropertyDescriptor _feeType = new PropertyDescriptor("feeType", beanClass, "getFeeType", "setFeeType");
      PropertyDescriptor _paymentType = new PropertyDescriptor("paymentType", beanClass, "getPaymentType", "setPaymentType");
      PropertyDescriptor _currencyType = new PropertyDescriptor("currencyType", beanClass, "getCurrencyType", "setCurrencyType");
      PropertyDescriptor _feeAmount = new PropertyDescriptor("feeAmount", beanClass, "getFeeAmount", "setFeeAmount");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", beanClass, "getPatronIdentifier", "setPatronIdentifier");
      PropertyDescriptor _terminalPassword = new PropertyDescriptor("terminalPassword", beanClass, "getTerminalPassword", "setTerminalPassword");
      PropertyDescriptor _patronPassword = new PropertyDescriptor("patronPassword", beanClass, "getPatronPassword", "setPatronPassword");
      PropertyDescriptor _feeIdentifier = new PropertyDescriptor("feeIdentifier", beanClass, "getFeeIdentifier", "setFeeIdentifier");
      PropertyDescriptor _transactionId = new PropertyDescriptor("transactionId", beanClass, "getTransactionId", "setTransactionId");

      _transactionDate.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(2,19));
      _feeType.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(20,21));
      _paymentType.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(22,23));
      _currencyType.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(24,26));

      _feeAmount.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BV"));
      _institutionId.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AO"));
      _patronIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AA"));
      _terminalPassword.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AC"));
      _patronPassword.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AD"));
      _feeIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CG"));
      _transactionId.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BK"));

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

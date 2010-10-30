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

public class RenewBeanInfo extends SimpleBeanInfo {
  Class<Renew> beanClass = Renew.class;
  String iconColor16x16Filename;
  String iconColor32x32Filename;
  String iconMono16x16Filename;
  String iconMono32x32Filename;

  public RenewBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptors() {
    try {
      PropertyDescriptor _thirdPartyAllowed = new PropertyDescriptor("thirdPartyAllowed", beanClass, "isThirdPartyAllowed", "setThirdPartyAllowed");
      PropertyDescriptor _noBlock = new PropertyDescriptor("noBlock", beanClass, "isNoBlock", "setNoBlock");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");
      PropertyDescriptor _noBlockDueDate = new PropertyDescriptor("noBlockDueDate", beanClass, "getNoBlockDueDate", "setNoBlockDueDate");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", beanClass, "getPatronIdentifier", "setPatronIdentifier");
      PropertyDescriptor _patronPassword = new PropertyDescriptor("patronPassword", beanClass, "getPatronPassword", "setPatronPassword");
      PropertyDescriptor _itemIdentifier = new PropertyDescriptor("itemIdentifier", beanClass, "getItemIdentifier", "setItemIdentifier");
      PropertyDescriptor _titleIdentifier = new PropertyDescriptor("titleIdentifier", beanClass, "getTitleIdentifier", "setTitleIdentifier");
      PropertyDescriptor _terminalPassword = new PropertyDescriptor("terminalPassword", beanClass, "getTerminalPassword", "setTerminalPassword");
      PropertyDescriptor _itemProperties = new PropertyDescriptor("itemProperties", beanClass, "getItemProperties", "setItemProperties");
      PropertyDescriptor _feeAcknowledged = new PropertyDescriptor("feeAcknowledged", beanClass, "getFeeAcknowledged", "setFeeAcknowledged");

      _thirdPartyAllowed.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(2,2));
      _noBlock.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(3,3));
      _transactionDate.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(4,21));
      _noBlockDueDate.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(2,39));

      _institutionId.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AO"));
      _patronIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AA"));
      _patronPassword.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AD"));
      _itemIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AB"));
      _titleIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AJ"));
      _terminalPassword.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AC"));
      _itemProperties.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CH"));
      _feeAcknowledged.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BO"));

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _thirdPartyAllowed,
        _noBlock,
        _transactionDate,
        _noBlockDueDate,
        _institutionId,
        _patronIdentifier,
        _patronPassword,
        _itemIdentifier,
        _titleIdentifier,
        _terminalPassword,
        _itemProperties,
        _feeAcknowledged};
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

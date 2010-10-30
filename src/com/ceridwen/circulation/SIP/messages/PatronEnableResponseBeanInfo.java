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

public class PatronEnableResponseBeanInfo extends SimpleBeanInfo {
  Class<PatronEnableResponse> beanClass = PatronEnableResponse.class;
  String iconColor16x16Filename;
  String iconColor32x32Filename;
  String iconMono16x16Filename;
  String iconMono32x32Filename;

  public PatronEnableResponseBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptors() {
    try {
      PropertyDescriptor _patronStatus = new PropertyDescriptor("patronStatus", beanClass, "getPatronStatus", "setPatronStatus");
      PropertyDescriptor _language = new PropertyDescriptor("language", beanClass, "getLanguage", "setLanguage");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", beanClass, "getPatronIdentifier", "setPatronIdentifier");
      PropertyDescriptor _personalName = new PropertyDescriptor("personalName", beanClass, "getPersonalName", "setPersonalName");
      PropertyDescriptor _validPatron = new PropertyDescriptor("validPatron", beanClass, "getValidPatron", "setValidPatron");
      PropertyDescriptor _validPatronPassword = new PropertyDescriptor("validPatronPassword", beanClass, "getValidPatronPassword", "setValidPatronPassword");
      PropertyDescriptor _screenMessage = new PropertyDescriptor("screenMessage", beanClass, "getScreenMessage", "setScreenMessage");
      PropertyDescriptor _printLine = new PropertyDescriptor("printLine", beanClass, "getPrintLine", "setPrintLine");

      _patronStatus.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(2,15));
      _language.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(16,18));
      _transactionDate.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(19,36));

      _institutionId.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AO"));
      _patronIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AA"));
      _personalName.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AE"));
      _validPatron.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BL"));
      _validPatronPassword.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CQ"));
      _screenMessage.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AF"));
      _printLine.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AG"));


      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _patronStatus,
        _language,
        _transactionDate,
        _institutionId,
        _patronIdentifier,
        _personalName,
        _validPatron,
        _validPatronPassword,
        _screenMessage,
        _printLine};
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

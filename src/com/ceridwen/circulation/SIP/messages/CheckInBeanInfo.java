/**
 * <p>Title: Self Issue</p>
 * <p>Description: Self Issue Client</p>
 * <p>Copyright: 2004,</p>
 * <p>Company: ceridwen.com</p>
 * @author Matthew J. Dovey
 * @version 2.1
 */

package com.ceridwen.circulation.SIP.messages;

import java.beans.*;
import com.ceridwen.circulation.SIP.helpers.*;

public class CheckInBeanInfo extends SimpleBeanInfo {
  Class beanClass = CheckIn.class;
  String iconColor16x16Filename;
  String iconColor32x32Filename;
  String iconMono16x16Filename;
  String iconMono32x32Filename;

  public CheckInBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptors() {
    try {
      PropertyDescriptor _cancel = new PropertyDescriptor("cancel", beanClass, "getCancel", "setCancel");
      PropertyDescriptor _currentLocation = new PropertyDescriptor("currentLocation", beanClass, "getCurrentLocation", "setCurrentLocation");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _itemIdentifier = new PropertyDescriptor("itemIdentifier", beanClass, "getItemIdentifier", "setItemIdentifier");
      PropertyDescriptor _itemProperties = new PropertyDescriptor("itemProperties", beanClass, "getItemProperties", "setItemProperties");
      PropertyDescriptor _noBlock = new PropertyDescriptor("noBlock", beanClass, "getNoBlock", "setNoBlock");
      PropertyDescriptor _returnDate = new PropertyDescriptor("returnDate", beanClass, "getReturnDate", "setReturnDate");
      PropertyDescriptor _terminalPassword = new PropertyDescriptor("terminalPassword", beanClass, "getTerminalPassword", "setTerminalPassword");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");

      _noBlock.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(2,2));
      _transactionDate.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(3,20));
      _returnDate.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(21,38));

      _currentLocation.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AP"));
      _institutionId.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AO"));
      _itemIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AB"));
      _terminalPassword.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AC"));
      _itemProperties.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CH"));
      _cancel.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BI"));

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _cancel,
        _currentLocation,
        _institutionId,
        _itemIdentifier,
        _itemProperties,
        _noBlock,
        _returnDate,
        _terminalPassword,
        _transactionDate};
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

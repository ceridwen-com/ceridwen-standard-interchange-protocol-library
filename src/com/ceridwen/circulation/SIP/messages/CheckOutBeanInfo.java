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

public class CheckOutBeanInfo extends SimpleBeanInfo {
  Class beanClass = CheckOut.class;
  String iconColor16x16Filename;
  String iconColor32x32Filename;
  String iconMono16x16Filename;
  String iconMono32x32Filename;

  public CheckOutBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptors() {
    try {
      PropertyDescriptor _cancel = new PropertyDescriptor("cancel", beanClass, "getCancel", "setCancel");
      PropertyDescriptor _feeAcknowledged = new PropertyDescriptor("feeAcknowledged", beanClass, "getFeeAcknowledged", "setFeeAcknowledged");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _itemIdentifier = new PropertyDescriptor("itemIdentifier", beanClass, "getItemIdentifier", "setItemIdentifier");
      PropertyDescriptor _itemProperties = new PropertyDescriptor("itemProperties", beanClass, "getItemProperties", "setItemProperties");
      PropertyDescriptor _nbDueDate = new PropertyDescriptor("nbDueDate", beanClass, "getNbDueDate", "setNbDueDate");
      PropertyDescriptor _noBlock = new PropertyDescriptor("noBlock", beanClass, "getNoBlock", "setNoBlock");
      PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", beanClass, "getPatronIdentifier", "setPatronIdentifier");
      PropertyDescriptor _patronPassword = new PropertyDescriptor("patronPassword", beanClass, "getPatronPassword", "setPatronPassword");
      PropertyDescriptor _renewalPolicy = new PropertyDescriptor("renewalPolicy", beanClass, "getRenewalPolicy", "setRenewalPolicy");
      PropertyDescriptor _terminalPassword = new PropertyDescriptor("terminalPassword", beanClass, "getTerminalPassword", "setTerminalPassword");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");

      _renewalPolicy.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(2,2));
      _noBlock.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(3,3));
      _transactionDate.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(4,21));
      _nbDueDate.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(22,39));

      _institutionId.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AO"));
      _patronIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AA"));
      _itemIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AB"));
      _terminalPassword.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AC"));
      _itemProperties.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CH"));
      _patronPassword.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AD"));
      _feeAcknowledged.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BO"));
      _cancel.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BI"));

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _cancel,
        _feeAcknowledged,
        _institutionId,
        _itemIdentifier,
        _itemProperties,
        _nbDueDate,
        _noBlock,
        _patronIdentifier,
        _patronPassword,
        _renewalPolicy,
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

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

public class HoldBeanInfo extends SimpleBeanInfo {
  Class beanClass = Hold.class;
  String iconColor16x16Filename;
  String iconColor32x32Filename;
  String iconMono16x16Filename;
  String iconMono32x32Filename;

  public HoldBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptors() {
    try {
      PropertyDescriptor _holdMode = new PropertyDescriptor("holdMode", beanClass, "getHoldMode", "setHoldMode");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");
      PropertyDescriptor _expirationDate = new PropertyDescriptor("expirationDate", beanClass, "getExpirationDate", "setExpirationDate");
      PropertyDescriptor _pickupLocation = new PropertyDescriptor("pickupLocation", beanClass, "getPickupLocation", "setPickupLocation");
      PropertyDescriptor _holdType = new PropertyDescriptor("holdType", beanClass, "getHoldType", "setHoldType");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", beanClass, "getPatronIdentifier", "setPatronIdentifier");
      PropertyDescriptor _patronPassword = new PropertyDescriptor("patronPassword", beanClass, "getPatronPassword", "setPatronPassword");
      PropertyDescriptor _itemIdentifier = new PropertyDescriptor("itemIdentifier", beanClass, "getItemIdentifier", "setItemIdentifier");
      PropertyDescriptor _titleIdentifier = new PropertyDescriptor("titleIdentifier", beanClass, "getTitleIdentifier", "setTitleIdentifier");
      PropertyDescriptor _terminalPassword = new PropertyDescriptor("terminalPassword", beanClass, "getTerminalPassword", "setTerminalPassword");
      PropertyDescriptor _feeAckowledged = new PropertyDescriptor("feeAckowledged", beanClass, "getFeeAckowledged", "setFeeAckowledged");

      _holdMode.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(2,2));
      _transactionDate.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(3,20));

      _expirationDate.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BW"));
      _pickupLocation.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BS"));
      _holdType.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BY"));
      _institutionId.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AO"));
      _patronIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AA"));
      _patronPassword.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AD"));
      _itemIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AB"));
      _titleIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AJ"));
      _terminalPassword.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AC"));
      _feeAckowledged.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BO"));

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _holdMode,
        _transactionDate,
        _expirationDate,
        _pickupLocation,
        _holdType,
        _institutionId,
        _patronIdentifier,
        _patronPassword,
        _itemIdentifier,
        _titleIdentifier,
        _terminalPassword,
        _feeAckowledged};
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

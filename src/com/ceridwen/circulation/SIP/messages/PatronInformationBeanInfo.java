package com.ceridwen.circulation.SIP.messages;

import java.beans.*;
import com.ceridwen.circulation.SIP.helpers.*;

/**
 * <p>Title: RTSI</p>
 * <p>Description: Real Time Self Issue</p>
 * <p>Copyright: </p>

 * @author Matthew J. Dovey
 * @version 1.0
 */

public class PatronInformationBeanInfo extends SimpleBeanInfo {
  Class beanClass = PatronInformation.class;
  String iconColor16x16Filename;
  String iconColor32x32Filename;
  String iconMono16x16Filename;
  String iconMono32x32Filename;

  public PatronInformationBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptors() {
    try {
      PropertyDescriptor _endItem = new PropertyDescriptor("endItem", beanClass, "getEndItem", "setEndItem");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _language = new PropertyDescriptor("language", beanClass, "getLanguage", "setLanguage");
      PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", beanClass, "getPatronIdentifier", "setPatronIdentifier");
      PropertyDescriptor _patronPassword = new PropertyDescriptor("patronPassword", beanClass, "getPatronPassword", "setPatronPassword");
      PropertyDescriptor _startItem = new PropertyDescriptor("startItem", beanClass, "getStartItem", "setStartItem");
      PropertyDescriptor _summary = new PropertyDescriptor("summary", beanClass, "getSummary", "setSummary");
      PropertyDescriptor _terminalPassword = new PropertyDescriptor("terminalPassword", beanClass, "getTerminalPassword", "setTerminalPassword");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");

      _language.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(2,4));
      _transactionDate.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(5,22));
      _summary.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(23,32));

      _institutionId.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AO"));
      _patronIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AA"));
      _terminalPassword.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AC"));
      _patronPassword.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AD"));
      _startItem.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BP", false));
      _endItem.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BQ", false));

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _endItem,
        _institutionId,
        _language,
        _patronIdentifier,
        _patronPassword,
        _startItem,
        _summary,
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

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

public class CheckOutResponseBeanInfo extends SimpleBeanInfo {
  Class<CheckOutResponse> beanClass = CheckOutResponse.class;
  String iconColor16x16Filename;
  String iconColor32x32Filename;
  String iconMono16x16Filename;
  String iconMono32x32Filename;

  public CheckOutResponseBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptors() {
    try {
      PropertyDescriptor _currencyType = new PropertyDescriptor("currencyType", beanClass, "getCurrencyType", "setCurrencyType");
      PropertyDescriptor _desensitize = new PropertyDescriptor("desensitize", beanClass, "getDesensitize", "setDesensitize");
      PropertyDescriptor _dueDate = new PropertyDescriptor("dueDate", beanClass, "getDueDate", "setDueDate");
      PropertyDescriptor _feeAmount = new PropertyDescriptor("feeAmount", beanClass, "getFeeAmount", "setFeeAmount");
      PropertyDescriptor _feeType = new PropertyDescriptor("feeType", beanClass, "getFeeType", "setFeeType");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _itemIdentifier = new PropertyDescriptor("itemIdentifier", beanClass, "getItemIdentifier", "setItemIdentifier");
      PropertyDescriptor _itemProperties = new PropertyDescriptor("itemProperties", beanClass, "getItemProperties", "setItemProperties");
      PropertyDescriptor _magenticMedia = new PropertyDescriptor("magenticMedia", beanClass, "getMagenticMedia", "setMagenticMedia");
      PropertyDescriptor _mediaType = new PropertyDescriptor("mediaType", beanClass, "getMediaType", "setMediaType");
      PropertyDescriptor _ok = new PropertyDescriptor("ok", beanClass, "getOk", "setOk");
      PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", beanClass, "getPatronIdentifier", "setPatronIdentifier");
      PropertyDescriptor _printLine = new PropertyDescriptor("printLine", beanClass, "getPrintLine", "setPrintLine");
      PropertyDescriptor _renewalOk = new PropertyDescriptor("renewalOk", beanClass, "getRenewalOk", "setRenewalOk");
      PropertyDescriptor _screenMessage = new PropertyDescriptor("screenMessage", beanClass, "getScreenMessage", "setScreenMessage");
      PropertyDescriptor _securityInhibit = new PropertyDescriptor("securityInhibit", beanClass, "getSecurityInhibit", "setSecurityInhibit");
      PropertyDescriptor _titleIdentifier = new PropertyDescriptor("titleIdentifier", beanClass, "getTitleIdentifier", "setTitleIdentifier");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");
      PropertyDescriptor _transactionId = new PropertyDescriptor("transactionId", beanClass, "getTransactionId", "setTransactionId");

      _ok.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(2,2));
      _renewalOk.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(3,3));
      _magenticMedia.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(4,4));
      _desensitize.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(5,5));
      _transactionDate.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(6,23));

      _institutionId.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AO"));
      _patronIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AA"));
      _itemIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AB"));
      _titleIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AJ"));
      _dueDate.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AH"));
      _feeType.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BT", true));
      _securityInhibit.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CI", true));
      _currencyType.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BH", true));
      _feeAmount.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BV", true));
      _mediaType.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CK", true));
      _itemProperties.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CH", true));
      _transactionId.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BK", true));
      _screenMessage.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AF", true));
      _printLine.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AG", true));

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _currencyType,
        _desensitize,
        _dueDate,
        _feeAmount,
        _feeType,
        _institutionId,
        _itemIdentifier,
        _itemProperties,
        _magenticMedia,
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

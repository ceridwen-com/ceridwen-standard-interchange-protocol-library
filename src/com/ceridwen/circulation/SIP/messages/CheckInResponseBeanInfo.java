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

public class CheckInResponseBeanInfo extends SimpleBeanInfo {
  Class<CheckInResponse> beanClass = CheckInResponse.class;
  String iconColor16x16Filename;
  String iconColor32x32Filename;
  String iconMono16x16Filename;
  String iconMono32x32Filename;

  public CheckInResponseBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptors() {
    try {
      PropertyDescriptor _alert = new PropertyDescriptor("alert", beanClass, "getAlert", "setAlert");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _itemIdentifier = new PropertyDescriptor("itemIdentifier", beanClass, "getItemIdentifier", "setItemIdentifier");
      PropertyDescriptor _itemProperties = new PropertyDescriptor("itemProperties", beanClass, "getItemProperties", "setItemProperties");
      PropertyDescriptor _magenticMedia = new PropertyDescriptor("magenticMedia", beanClass, "getMagenticMedia", "setMagenticMedia");
      PropertyDescriptor _mediaType = new PropertyDescriptor("mediaType", beanClass, "getMediaType", "setMediaType");
      PropertyDescriptor _ok = new PropertyDescriptor("ok", beanClass, "getOk", "setOk");
      PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", beanClass, "getPatronIdentifier", "setPatronIdentifier");
      PropertyDescriptor _permanentLocation = new PropertyDescriptor("permanentLocation", beanClass, "getPermanentLocation", "setPermanentLocation");
      PropertyDescriptor _printLine = new PropertyDescriptor("printLine", beanClass, "getPrintLine", "setPrintLine");
      PropertyDescriptor _resensitize = new PropertyDescriptor("resensitize", beanClass, "getResensitize", "setResensitize");
      PropertyDescriptor _screenMessage = new PropertyDescriptor("screenMessage", beanClass, "getScreenMessage", "setScreenMessage");
      PropertyDescriptor _sortBin = new PropertyDescriptor("sortBin", beanClass, "getSortBin", "setSortBin");
      PropertyDescriptor _titleIdentifier = new PropertyDescriptor("titleIdentifier", beanClass, "getTitleIdentifier", "setTitleIdentifier");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");

      _ok.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(2,2));
      _resensitize.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(3,3));
      _magenticMedia.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(4,4));
      _alert.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(5,5));
      _transactionDate.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(6,23));

      _institutionId.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AO"));
      _itemIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AB"));
      _permanentLocation.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AQ"));
      _titleIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AJ", true));
      _sortBin.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CL", true));
      _patronIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AA", true));
      _mediaType.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CK", true));
      _itemProperties.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CH", true));
      _screenMessage.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AF", true));
      _printLine.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AG", true));


      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _alert,
        _institutionId,
        _itemIdentifier,
        _itemProperties,
        _magenticMedia,
        _mediaType,
        _ok,
        _patronIdentifier,
        _permanentLocation,
        _printLine,
        _resensitize,
        _screenMessage,
        _sortBin,
        _titleIdentifier,
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

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

public class ItemInformationResponseBeanInfo extends SimpleBeanInfo {
  Class<ItemInformationResponse> beanClass = ItemInformationResponse.class;
  String iconColor16x16Filename;
  String iconColor32x32Filename;
  String iconMono16x16Filename;
  String iconMono32x32Filename;

  public ItemInformationResponseBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptors() {
    try {
      PropertyDescriptor _circulationStatus = new PropertyDescriptor("circulationStatus", beanClass, "getCirculationStatus", "setCirculationStatus");
      PropertyDescriptor _currencyType = new PropertyDescriptor("currencyType", beanClass, "getCurrencyType", "setCurrencyType");
      PropertyDescriptor _currentLocation = new PropertyDescriptor("currentLocation", beanClass, "getCurrentLocation", "setCurrentLocation");
      PropertyDescriptor _dueDate = new PropertyDescriptor("dueDate", beanClass, "getDueDate", "setDueDate");
      PropertyDescriptor _feeAmount = new PropertyDescriptor("feeAmount", beanClass, "getFeeAmount", "setFeeAmount");
      PropertyDescriptor _feeType = new PropertyDescriptor("feeType", beanClass, "getFeeType", "setFeeType");
      PropertyDescriptor _holdPickupDate = new PropertyDescriptor("holdPickupDate", beanClass, "getHoldPickupDate", "setHoldPickupDate");
      PropertyDescriptor _holdQueueLength = new PropertyDescriptor("holdQueueLength", beanClass, "getHoldQueueLength", "setHoldQueueLength");
      PropertyDescriptor _itemIdentifier = new PropertyDescriptor("itemIdentifier", beanClass, "getItemIdentifier", "setItemIdentifier");
      PropertyDescriptor _itemProperties = new PropertyDescriptor("itemProperties", beanClass, "getItemProperties", "setItemProperties");
      PropertyDescriptor _mediaType = new PropertyDescriptor("mediaType", beanClass, "getMediaType", "setMediaType");
      PropertyDescriptor _owner = new PropertyDescriptor("owner", beanClass, "getOwner", "setOwner");
      PropertyDescriptor _permanentLocation = new PropertyDescriptor("permanentLocation", beanClass, "getPermanentLocation", "setPermanentLocation");
      PropertyDescriptor _printLine = new PropertyDescriptor("printLine", beanClass, "getPrintLine", "setPrintLine");
      PropertyDescriptor _recallDate = new PropertyDescriptor("recallDate", beanClass, "getRecallDate", "setRecallDate");
      PropertyDescriptor _screenMessage = new PropertyDescriptor("screenMessage", beanClass, "getScreenMessage", "setScreenMessage");
      PropertyDescriptor _securityMarker = new PropertyDescriptor("securityMarker", beanClass, "getSecurityMarker", "setSecurityMarker");
      PropertyDescriptor _titleIdentifier = new PropertyDescriptor("titleIdentifier", beanClass, "getTitleIdentifier", "setTitleIdentifier");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");

      _circulationStatus.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(2,3));
      _securityMarker.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(4,5));
      _feeType.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(6,7));
      _transactionDate.setValue("SIPFieldDescriptor", new FixedFieldDescriptor(8,25));

      _holdQueueLength.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CF"));
      _dueDate.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AH"));
      _recallDate.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CJ"));
      _holdPickupDate.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CM"));
      _itemIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AB"));
      _titleIdentifier.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AJ"));
      _owner.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BG"));
      _currencyType.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BH"));
      _feeAmount.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("BV"));
      _mediaType.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CK"));
      _permanentLocation.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AQ"));
      _currentLocation.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AP"));
      _itemProperties.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("CH"));
      _screenMessage.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AF"));
      _printLine.setValue("SIPFieldDescriptor", new VariableFieldDescriptor("AG"));

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _circulationStatus,
        _currencyType,
        _currentLocation,
        _dueDate,
        _feeAmount,
        _feeType,
        _holdPickupDate,
        _holdQueueLength,
        _itemIdentifier,
        _itemProperties,
        _mediaType,
        _owner,
        _permanentLocation,
        _printLine,
        _recallDate,
        _screenMessage,
        _securityMarker,
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

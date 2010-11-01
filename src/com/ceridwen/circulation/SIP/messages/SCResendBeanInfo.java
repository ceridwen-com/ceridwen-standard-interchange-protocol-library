package com.ceridwen.circulation.SIP.messages;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;

public class SCResendBeanInfo extends MessageBeanInfo {
		  Class<ACSStatus> beanClass = ACSStatus.class;
		  public SCResendBeanInfo() {
		  }
		  public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
		      PropertyDescriptor[] pds = new PropertyDescriptor[] {};
		      return pds;
		  }
}
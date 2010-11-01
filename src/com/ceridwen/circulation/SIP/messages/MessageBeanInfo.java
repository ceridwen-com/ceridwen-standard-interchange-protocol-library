package com.ceridwen.circulation.SIP.messages;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.beans.SimpleBeanInfo;

import com.ceridwen.circulation.SIP.types.descriptors.FieldDefinitions;

public abstract class MessageBeanInfo extends SimpleBeanInfo {
	
	protected abstract PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException;

	public PropertyDescriptor[] getPropertyDescriptors() {
		try {
			PropertyDescriptor[] pds;
			pds = this.getPropertyDescriptorsInternal();
			FieldDefinitions.fixupFieldDescriptors(this.getClass().getSimpleName(), pds);
			return pds;
		} catch (IntrospectionException e) {
			throw new java.lang.AssertionError(e);
		}
	}

	public java.awt.Image getIcon(int iconKind) {
        return null;
	}
}


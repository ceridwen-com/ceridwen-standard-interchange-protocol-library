package com.ceridwen.circulation.SIP.types.enumerations;

public interface AbstractEnumeration {

	public abstract String toString();
	public abstract String getCode();
	public abstract AbstractEnumeration getKey(String code);
}
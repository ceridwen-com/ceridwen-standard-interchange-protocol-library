package com.ceridwen.circulation.SIP.types.enumerations;

public enum HoldMode implements AbstractEnumeration {
	ADD("+"),
	DELETE("-"),
	CHANGE("*");
	
	private final String code;
	private HoldMode(String code) {
		this.code = code;
	}	
	public String toString() {
		return this.getCode();
	}
	@Override
	public final String getCode() {
		return code;
	}
	@Override
	public final AbstractEnumeration getKey(String code) {
		for (AbstractEnumeration i: HoldMode.values()) {
			if (i.getCode().equals(code)) {
				return i;
			}
		}
		return null;
	}
}

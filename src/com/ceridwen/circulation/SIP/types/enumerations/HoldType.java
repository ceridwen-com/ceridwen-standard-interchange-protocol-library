package com.ceridwen.circulation.SIP.types.enumerations;

public enum HoldType implements AbstractEnumeration {
	OTHER("1"),
	ANY_COPY("2"),
	SPECIFIC_COPY("3"),
	SUBLOCATION_COPY("4");
	
	private final String code;
	private HoldType(String code) {
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
		for (AbstractEnumeration i: HoldType.values()) {
			if (i.getCode().equals(code)) {
				return i;
			}
		}
		return null;
	}
}

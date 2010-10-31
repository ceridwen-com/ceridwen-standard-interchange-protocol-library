package com.ceridwen.circulation.SIP.types.enumerations;

public enum StatusCode implements AbstractEnumeration {
	OK("0"),
	OUT_OF_PAPER("1"),
	SHUTTING_DOWN("2");

	private final String code;
	private StatusCode(String code) {
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
		for (AbstractEnumeration i: StatusCode.values()) {
			if (i.getCode().equals(code)) {
				return i;
			}
		}
		return null;
	}
}


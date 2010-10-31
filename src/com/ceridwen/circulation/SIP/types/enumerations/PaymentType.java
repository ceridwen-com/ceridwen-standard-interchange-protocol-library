package com.ceridwen.circulation.SIP.types.enumerations;

public enum PaymentType implements AbstractEnumeration {
	CASH("00"),
	VISA("01"),
	CREDIT_CARD("02");

	private final String code;
	private PaymentType(String code) {
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
		for (AbstractEnumeration i: PaymentType.values()) {
			if (i.getCode().equals(code)) {
				return i;
			}
		}
		return null;
	}
}

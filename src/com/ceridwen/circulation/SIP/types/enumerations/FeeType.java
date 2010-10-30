package com.ceridwen.circulation.SIP.types.enumerations;

public enum FeeType implements AbstractEnumeration {
	OTHER("01"),
	ADMINISTRATIVE("02"),
	DAMAGE("03"),
	OVERDUE("04"),
	PROCESSING("05"),
	RENTAL("06"),
	REPLACEMENT("07"),
	COMPUTERACCESSCHARGE("08"),
	HOLDFEE("09");
		
	private final String code;
	private FeeType(String code) {
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
		for (AbstractEnumeration i: FeeType.values()) {
			if (i.getCode().equals(code)) {
				return i;
			}
		}
		return null;
	}
}

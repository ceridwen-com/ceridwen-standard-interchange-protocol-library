package com.ceridwen.circulation.SIP.types.enumerations;

public enum CirculationStatus implements AbstractEnumeration {
	OTHER("01"),
	ONORDER("02"),
	AVAILABLE("03"),
	CHARGED("04"),
	CHARGEDUNTILRECALLDATE("05"),
	INPROCESS("06"),
	RECALLED("07"),
	HOLDSHELF("08"),
	AWAITINGRESHELVING("09"),
	INTRANSIT("10"),
	CLAIMEDRETURN("11"),
	LOST("12"),
	MISSING("13");
	
	private final String code;
	private CirculationStatus(String code) {
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
		for (AbstractEnumeration i: CirculationStatus.values()) {
			if (i.getCode().equals(code)) {
				return i;
			}
		}
		return null;
	}
}

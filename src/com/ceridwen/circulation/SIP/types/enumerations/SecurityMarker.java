package com.ceridwen.circulation.SIP.types.enumerations;

public enum SecurityMarker implements AbstractEnumeration {
	OTHER("00"),
	NONE("01"),
	TATTLE_TAPE("02"),
	WHISPER_TAPE("03");
	
	private final String code;
	private SecurityMarker(String code) {
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
		for (AbstractEnumeration i: SecurityMarker.values()) {
			if (i.getCode().equals(code)) {
				return i;
			}
		}
		return null;
	}
}

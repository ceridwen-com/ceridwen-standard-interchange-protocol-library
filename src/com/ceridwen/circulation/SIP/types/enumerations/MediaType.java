package com.ceridwen.circulation.SIP.types.enumerations;

public enum MediaType implements AbstractEnumeration {
	OTHER("000"),
	BOOK("001"),
	MAGAZINE("002"),
	BOUNDJOURNAL("003"),
	AUDIOTAPE("004"),
	VIDEOTAPE("005"),
	CD("006"),
	DISKETTE("007"),
	BOOKWITHDISKETTE("008"),
	BOOKWITHCD("009"),
	BOOKWITHAUDIOTAPE("010");
		
	private final String code;
	private MediaType(String code) {
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
		for (AbstractEnumeration i: MediaType.values()) {
			if (i.getCode().equals(code)) {
				return i;
			}
		}
		return null;
	}
}

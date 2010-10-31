package com.ceridwen.circulation.SIP.types.enumerations;

public enum MediaType implements AbstractEnumeration {
	OTHER("000"),
	BOOK("001"),
	MAGAZINE("002"),
	BOUND_JOURNAL("003"),
	AUDIO_TAPE("004"),
	VIDEO_TAPE("005"),
	CD("006"),
	DISKETTE("007"),
	BOOK_WITH_DISKETTE("008"),
	BOOK_WITH_CD("009"),
	BOOK_WITH_AUDIO_TAPE("010");
		
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

package com.ceridwen.circulation.SIP.types.enumerations;

public enum CurrencyType implements AbstractEnumeration {
	USDOLLAR("USD"),
	CANADIANDOLLAR("CAD"),
	POUNDSTERLING("GBP"),
	FRENCHFRANC("FRF"),
	DEUTSCHEMARK("DEM"),
	ITALIANLIRA("ITL"),
	SPANISHPESETA("ESP"),
	YEN("JPY");	
	private final String code;	
	private CurrencyType(String code) {
		this.code = code;
	}
	@Override
	public String getCode() {
		return code; 
	}
	@Override
	public AbstractEnumeration getKey(String code) {
		for (AbstractEnumeration i: Language.values()) {
			if (i.getCode().equals(code)) {
				return i;
			}
		}
		return null;
	}
	public String toString() {
		return this.getCode();
	}
	
}

package com.ceridwen.circulation.SIP.exceptions;

public class FixedFieldTooLong extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5690108640895112742L;
	private String field;
	private int maxLength;
	
	public FixedFieldTooLong(String field, int maxLength) {
		this.field = field;
		this.maxLength = maxLength;
	}
	
	public String getMessage()
	{
		return this.field + " should be at most " + this.maxLength + " characters";
	}	
}

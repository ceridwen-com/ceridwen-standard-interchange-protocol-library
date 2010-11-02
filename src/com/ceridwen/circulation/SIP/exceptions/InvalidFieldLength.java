package com.ceridwen.circulation.SIP.exceptions;

public class InvalidFieldLength extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5690108640895112742L;
	private String field;
	private int maxLength;
	
	public InvalidFieldLength(String field, int maxLength) {
		this.field = field;
		this.maxLength = maxLength;
	}
	
	public String getMessage()
	{
		return this.field + " - Field Length: " + this.maxLength + " characters";
	}	
}

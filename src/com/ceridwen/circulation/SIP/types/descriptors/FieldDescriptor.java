package com.ceridwen.circulation.SIP.types.descriptors;

public class FieldDescriptor {
	public String tag;
	public Class<?> type;
	public Integer length;
	public Boolean required;
	
	protected FieldDescriptor()
	{
	}
	
	protected FieldDescriptor(String tag, Class<?> type, Integer length, Boolean required)
	{
		this.tag = tag;
		this.type = type;
		this.length = length;
		this.required = required;
	}
}

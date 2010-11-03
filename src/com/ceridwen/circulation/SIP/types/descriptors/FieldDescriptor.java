package com.ceridwen.circulation.SIP.types.descriptors;

public class FieldDescriptor {
	public String tag;
	public Class<?> type;
	public Integer length;
	public Boolean required;
	
	protected FieldDescriptor()
	{
	}
	
	protected FieldDescriptor(String name, FieldDescriptor d, Boolean required) {
 	  this.tag = d.tag;
	  this.length = d.length;
	  if (d.required == null && required != null) {
		  this.required = required;
  	  } else if (d.required == null && required == null) {
		  throw new java.lang.AssertionError(name + " mutable required state needs explicit value");																  
  	  } else if  (d.required != null && required == null) {
  		  this.required = d.required;
  	  } else {
		  throw new java.lang.AssertionError(name + " immutable required state cannot be overriden");																  
  	  }
//	  FieldStatisticsGatherer.getFieldStatisticsGatherer().RecordUsage(name, this.required);
	}	
	
	protected FieldDescriptor(String tag, Class<?> type, Integer length, Boolean required)
	{
		this.tag = tag;
		this.type = type;
		this.length = length;
		this.required = required;
	}	
}

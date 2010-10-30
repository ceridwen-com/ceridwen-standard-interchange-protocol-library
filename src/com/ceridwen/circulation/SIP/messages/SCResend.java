package com.ceridwen.circulation.SIP.messages;

public class SCResend extends Message {

		/**
	 * 
	 */
	private static final long serialVersionUID = 7077005327500597112L;

		public String getCommand() {
			return "96";
		}
	    protected String AddChecksum(String command, Character sequence) {
		    StringBuffer check = new StringBuffer();
		    check.append("AZ");
		    try {
		      check.append(CalculateChecksum(command + check.toString()));
		      return command + check.toString();
		    }
		    catch (Exception e) {
		    	return command;
		    }
		  }		
	}
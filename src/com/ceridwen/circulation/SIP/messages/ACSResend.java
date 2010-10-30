package com.ceridwen.circulation.SIP.messages;

public class ACSResend extends Message {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1455544775405713654L;

	public String getCommand() {
		return "97";
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

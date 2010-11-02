package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.CheckIn;
import com.ceridwen.circulation.SIP.messages.Message;

public class CheckInTest extends AbstractMessageTest<CheckIn> {
	@Override
	public Message getDefaultMessage() {
		CheckIn m = new CheckIn();
		
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "09N19700101    010000                  AB|AC|AO|AP|";
	}

	@Override
	public Message getMessage() {
		CheckIn m = new CheckIn();
		
		m.setCancel(true);
		m.setCurrentLocation("currentLocation");
		m.setInstitutionId("institutionId");
		m.setItemIdentifier("itemIdentifier");
		m.setInstitutionId("institutionId");
		m.setItemIdentifier("itemIdentifier");
		m.setItemProperties("itemProperties");
		m.setNoBlock(true);
		m.setReturnDate(new java.util.Date(0));
		m.setTerminalPassword("terminalPassword");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "09Y19700101    01000019700101    010000ABitemIdentifier|ACterminalPassword|AOinstitutionId|APcurrentLocation|BIY|CHitemProperties|";
	}
}


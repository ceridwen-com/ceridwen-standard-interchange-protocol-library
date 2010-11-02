package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.PatronEnable;
import com.ceridwen.circulation.SIP.messages.Message;

public class PatronEnableTest extends AbstractMessageTest<PatronEnable> {

	@Override
	public Message getDefaultMessage() {
		PatronEnable m = new PatronEnable();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "2519700101    010000AA|AO|";
	}

	@Override
	public Message getMessage() {
		PatronEnable m = new PatronEnable();
		
		m.setInstitutionId("institutionId");
		m.setPatronIdentifier("patronIdentifier");
		m.setPatronPassword("patronPassword");
		m.setTerminalPassword("terminalPassword");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "2519700101    010000AApatronIdentifier|ACterminalPassword|ADpatronPassword|AOinstitutionId|";
	}
}


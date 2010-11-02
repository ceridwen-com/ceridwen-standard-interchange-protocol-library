package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.PatronStatusRequest;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.enumerations.Language;

public class PatronStatusRequestTest extends AbstractMessageTest<PatronStatusRequest> {

	@Override
	public Message getDefaultMessage() {
		PatronStatusRequest m = new PatronStatusRequest();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "2300019700101    010000AA|AC|AD|AO|";
	}

	@Override
	public Message getMessage() {
		PatronStatusRequest m = new PatronStatusRequest();
		
		m.setInstitutionId("institutionId");
		m.setLanguage(Language.UNITED_KINGDOM);
		m.setPatronIdentifier("patronIdentifier");
		m.setPatronPassword("patronPassword");
		m.setTerminalPassword("terminalPassword");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "2302419700101    010000AApatronIdentifier|ACterminalPassword|ADpatronPassword|AOinstitutionId|";
	}
}


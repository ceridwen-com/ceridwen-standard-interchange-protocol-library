package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.EndPatronSession;
import com.ceridwen.circulation.SIP.messages.Message;

public class EndPatronSessionTest extends AbstractMessageTest<EndPatronSession> {

	@Override
	public Message getDefaultMessage() {
		EndPatronSession m = new EndPatronSession();
		
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "3519700101    010000AA|AC|AD|AO|AY0AZF6F4";
	}

	@Override
	public Message getMessage() {
		EndPatronSession m = new EndPatronSession();
		
		m.setInstitutionId("institutionId");
		m.setPatronIdentifier("patronIdentifier");
		m.setPatronPassword("patronPassword");
		m.setTerminalPassword("terminalPassword");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "3519700101    010000AApatronIdentifier|ACterminalPassword|ADpatronPassword|AOinstitutionId|AY0AZDE50";
	}

}


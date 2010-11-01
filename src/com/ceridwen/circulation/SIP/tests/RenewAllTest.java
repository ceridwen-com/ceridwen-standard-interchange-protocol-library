package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.RenewAll;
import com.ceridwen.circulation.SIP.messages.Message;

public class RenewAllTest extends AbstractMessageTest<RenewAll> {

	@Override
	public Message getDefaultMessage() {
		RenewAll m = new RenewAll();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "6519700101    010000AA|AC|AD|AO|BON|AY0AZF596";
	}

	@Override
	public Message getMessage() {
		RenewAll m = new RenewAll();

		m.setFeeAcknowledged(true);
		m.setInstitutionId("institutionId");
		m.setPatronIdentifier("patronIdentifier");
		m.setPatronPassword("patronPassword");
		m.setTerminalPassword("terminalPassword");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "6519700101    010000AApatronIdentifier|ACterminalPassword|ADpatronPassword|AOinstitutionId|BOY|AY0AZDCE7";
	}
}


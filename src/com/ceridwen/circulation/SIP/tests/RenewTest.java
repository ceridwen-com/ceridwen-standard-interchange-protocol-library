package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.Renew;
import com.ceridwen.circulation.SIP.messages.Message;

public class RenewTest extends AbstractMessageTest<Renew> {
	@Override
	public Message getDefaultMessage() {
		Renew m = new Renew();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "29NN19700101    010000                  AA|AO|";
	}

	@Override
	public Message getMessage() {
		Renew m = new Renew();

		m.setFeeAcknowledged(true);
		m.setInstitutionId("institutionId");
		m.setItemIdentifier("itemIdentifier");
		m.setItemProperties("itemProperties");
		m.setNoBlock(true);
		m.setNbDueDate(new java.util.Date(0));
		m.setPatronIdentifier("patronIdentifier");
		m.setPatronPassword("patronPassword");
		m.setTerminalPassword("terminalPassword");
		m.setThirdPartyAllowed(true);
		m.setTitleIdentifier("titleIdentifier");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "29YY19700101    01000019700101    010000AApatronIdentifier|ABitemIdentifier|ACterminalPassword|ADpatronPassword|AJtitleIdentifier|AOinstitutionId|BOY|CHitemProperties|";
	}
}


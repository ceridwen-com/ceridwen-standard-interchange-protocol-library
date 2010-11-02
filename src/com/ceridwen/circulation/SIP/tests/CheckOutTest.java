package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.CheckOut;
import com.ceridwen.circulation.SIP.messages.Message;

public class CheckOutTest extends AbstractMessageTest<CheckOut> {
	@Override
	public Message getDefaultMessage() {
		CheckOut m = new CheckOut();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "11NN19700101    010000                  AA|AB|AC|AO|";
	}

	@Override
	public Message getMessage() {
		CheckOut m = new CheckOut();

		m.setCancel(true);
		m.setFeeAcknowledged(true);
		m.setInstitutionId("institutionId");
		m.setItemIdentifier("itemIdentifier");
		m.setItemProperties("itemProperties");
		m.setNbDueDate(new java.util.Date(0));
		m.setNoBlock(true);
		m.setPatronIdentifier("patronIdentifier");
		m.setPatronPassword("patronPassword");
		m.setRenewalPolicy(true);
		m.setTerminalPassword("terminalPassword");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "11YY19700101    01000019700101    010000AApatronIdentifier|ABitemIdentifier|ACterminalPassword|ADpatronPassword|AOinstitutionId|BIY|BOY|CHitemProperties|";
	}
}


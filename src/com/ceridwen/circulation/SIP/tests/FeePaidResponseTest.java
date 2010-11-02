package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.FeePaidResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class FeePaidResponseTest extends AbstractMessageTest<FeePaidResponse> {

	@Override
	public Message getDefaultMessage() {
		FeePaidResponse m = new FeePaidResponse();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "38N19700101    010000AA|AO|";
	}

	@Override
	public Message getMessage() {
		FeePaidResponse m = new FeePaidResponse();

		m.setInstitutionId("institutionId");
		m.setPatronIdentifier("patronIdentifier");
		m.setPaymentAccepted(true);
		m.setPrintLine("printLine");
		m.setScreenMessage("screenMessage");
		m.setTransactionDate(new java.util.Date(0));
		m.setTransactionId("transactionId");

		return m;
	}

	@Override
	public String getEncoding() {
		return "38Y19700101    010000AApatronIdentifier|AFscreenMessage|AGprintLine|AOinstitutionId|BKtransactionId|";
	}
}


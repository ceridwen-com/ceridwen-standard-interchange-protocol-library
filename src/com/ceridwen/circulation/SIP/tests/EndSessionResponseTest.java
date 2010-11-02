package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.EndSessionResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class EndSessionResponseTest extends AbstractMessageTest<EndSessionResponse> {

	@Override
	public Message getDefaultMessage() {
		EndSessionResponse m = new EndSessionResponse();
		
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "36N19700101    010000AA|AO|";
	}

	@Override
	public Message getMessage() {
		EndSessionResponse m = new EndSessionResponse();
		
		m.setEndSession(true);
		m.setInstitutionId("institutionId");
		m.setPatronIdentifier("patronIdentifier");
		m.setPrintLine("printLine");
		m.setScreenMessage("screenMessage");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "36Y19700101    010000AApatronIdentifier|AFscreenMessage|AGprintLine|AOinstitutionId|";
	}

}


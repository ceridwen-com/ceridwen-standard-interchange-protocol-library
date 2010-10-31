package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.EndSessionResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class EndSessionResponseTest extends AbstractMessageTest<EndSessionResponse> {

	@Override
	public Message getMessage() {
		EndSessionResponse m = new EndSessionResponse();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "36N19700101    010000AA|AF|AG|AO|AY0AZF69F";
	}
}


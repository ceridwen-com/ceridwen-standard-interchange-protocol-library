package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.PatronStatusRequest;
import com.ceridwen.circulation.SIP.messages.Message;

public class PatronStatusRequestTest extends AbstractMessageTest<PatronStatusRequest> {

	@Override
	public Message getMessage() {
		PatronStatusRequest m = new PatronStatusRequest();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "2300019700101    010000AA|AC|AD|AO|AY0AZF667";
	}
}


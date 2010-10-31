package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.PatronEnableResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class PatronEnableResponseTest extends AbstractMessageTest<PatronEnableResponse> {

	@Override
	public Message getMessage() {
		PatronEnableResponse m = new PatronEnableResponse();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "26              00019700101    010000AA|AE|AF|AG|AO|BLN|CQN|AY0AZF0E6";
	}
}


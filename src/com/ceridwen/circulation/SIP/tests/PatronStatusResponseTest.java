package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.PatronStatusResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class PatronStatusResponseTest extends AbstractMessageTest<PatronStatusResponse> {

	@Override
	public Message getMessage() {
		PatronStatusResponse m = new PatronStatusResponse();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "24              00019700101    010000AA|AE|AF|AG|AO|BHUSD|BLN|BV|CQN|AY0AZEDE2";
	}
}


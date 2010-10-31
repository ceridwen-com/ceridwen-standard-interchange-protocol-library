package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.FeePaidResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class FeePaidResponseTest extends AbstractMessageTest<FeePaidResponse> {

	@Override
	public Message getMessage() {
		FeePaidResponse m = new FeePaidResponse();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "38N19700101    010000AA|AF|AG|AO|BK|AY0AZF594";
	}
}


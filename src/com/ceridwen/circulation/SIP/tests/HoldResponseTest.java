package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.HoldResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class HoldResponseTest extends AbstractMessageTest<HoldResponse> {

	@Override
	public Message getMessage() {
		HoldResponse m = new HoldResponse();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "160N19700101    010000                  AA|AB|AF|AG|AJ|AO|BR|BS|AY0AZF00A";
	}
}


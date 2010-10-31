package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.RenewAllResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class RenewAllResponseTest extends AbstractMessageTest<RenewAllResponse> {

	@Override
	public Message getMessage() {
		RenewAllResponse m = new RenewAllResponse();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "660        19700101    010000AF|AG|AO|AY0AZF6B8";
	}
}


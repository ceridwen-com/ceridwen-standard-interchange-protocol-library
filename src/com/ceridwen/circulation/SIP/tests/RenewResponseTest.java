package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.RenewResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class RenewResponseTest extends AbstractMessageTest<RenewResponse> {

	@Override
	public Message getMessage() {
		RenewResponse m = new RenewResponse();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "300NUN19700101    010000AA|AB|AF|AG|AH|AJ|AO|BHUSD|BK|BT01|BV|CH|CIN|CK000|AY0AZE94E";
	}
}


package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.CheckOutResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class CheckOutResponseTest extends AbstractMessageTest<CheckOutResponse> {

	@Override
	public Message getMessage() {
		CheckOutResponse m = new CheckOutResponse();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "120NNN19700101    010000AA|AB|AF|AG|AH|AJ|AO|BHUSD|BK|BT01|BV|CH|CIN|CK000|AY0AZE955";
	}
}


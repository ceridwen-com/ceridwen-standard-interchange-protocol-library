package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.CheckInResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class CheckInResponseTest extends AbstractMessageTest<CheckInResponse> {

	@Override
	public Message getMessage() {
		CheckInResponse m = new CheckInResponse();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));
		
		return m;
	}

	@Override
	public String getEncoding() {
		return "100NNN19700101    010000AA|AB|AF|AG|AJ|AO|AQ|CH|CK000|CL|AY0AZEF1B";
	}
}


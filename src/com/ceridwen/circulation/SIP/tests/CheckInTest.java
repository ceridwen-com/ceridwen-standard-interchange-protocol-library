package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.CheckIn;
import com.ceridwen.circulation.SIP.messages.Message;

public class CheckInTest extends AbstractMessageTest<CheckIn> {

	@Override
	public Message getMessage() {
		CheckIn m = new CheckIn();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "09N19700101    010000                  AB|AC|AO|AP|BIN|AY0AZF303";
	}
}


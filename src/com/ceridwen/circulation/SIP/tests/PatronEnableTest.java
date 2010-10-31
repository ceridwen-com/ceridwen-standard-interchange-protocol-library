package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.PatronEnable;
import com.ceridwen.circulation.SIP.messages.Message;

public class PatronEnableTest extends AbstractMessageTest<PatronEnable> {

	@Override
	public Message getMessage() {
		PatronEnable m = new PatronEnable();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "2519700101    010000AA|AC|AD|AO|AY0AZF6F5";
	}
}


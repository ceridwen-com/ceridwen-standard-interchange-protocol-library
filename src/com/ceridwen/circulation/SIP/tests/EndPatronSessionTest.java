package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.EndPatronSession;
import com.ceridwen.circulation.SIP.messages.Message;

public class EndPatronSessionTest extends AbstractMessageTest<EndPatronSession> {

	@Override
	public Message getMessage() {
		EndPatronSession m = new EndPatronSession();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "3519700101    010000AA|AC|AD|AO|AY0AZF6F4";
	}
}


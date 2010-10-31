package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.Hold;
import com.ceridwen.circulation.SIP.messages.Message;

public class HoldTest extends AbstractMessageTest<Hold> {

	@Override
	public Message getMessage() {
		Hold m = new Hold();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "15*19700101    010000AA|AB|AC|AD|AJ|AO|BON|BS|BW|BY1|AY0AZEFFD";
	}
}


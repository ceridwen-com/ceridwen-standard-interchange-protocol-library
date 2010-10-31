package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.FeePaid;
import com.ceridwen.circulation.SIP.messages.Message;

public class FeePaidTest extends AbstractMessageTest<FeePaid> {

	@Override
	public Message getMessage() {
		FeePaid m = new FeePaid();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "3719700101    0100000100USDAA|AC|AD|AO|BK|BV|CG|AY0AZF222";
	}
}


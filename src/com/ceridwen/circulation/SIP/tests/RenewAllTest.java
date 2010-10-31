package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.RenewAll;
import com.ceridwen.circulation.SIP.messages.Message;

public class RenewAllTest extends AbstractMessageTest<RenewAll> {

	@Override
	public Message getMessage() {
		RenewAll m = new RenewAll();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "6519700101    010000AA|AC|AD|AO|BON|AY0AZF596";
	}
}


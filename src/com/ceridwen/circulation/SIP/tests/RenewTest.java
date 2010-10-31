package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.Renew;
import com.ceridwen.circulation.SIP.messages.Message;

public class RenewTest extends AbstractMessageTest<Renew> {

	@Override
	public Message getMessage() {
		Renew m = new Renew();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "29NN19700101    010000AA|AB|AC|AD|AJ|AO|BON|CH|AY0AZF1ED";
	}
}


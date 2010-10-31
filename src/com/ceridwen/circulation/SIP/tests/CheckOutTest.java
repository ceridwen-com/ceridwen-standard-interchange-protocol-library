package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.CheckOut;
import com.ceridwen.circulation.SIP.messages.Message;

public class CheckOutTest extends AbstractMessageTest<CheckOut> {

	@Override
	public Message getMessage() {
		CheckOut m = new CheckOut();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "11NN19700101    010000                  AA|AB|AC|AO|BIN|BON|AY0AZF170";
	}
}


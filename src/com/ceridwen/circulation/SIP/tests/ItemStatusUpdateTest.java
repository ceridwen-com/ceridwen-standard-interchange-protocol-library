package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.ItemStatusUpdate;
import com.ceridwen.circulation.SIP.messages.Message;

public class ItemStatusUpdateTest extends AbstractMessageTest<ItemStatusUpdate> {

	@Override
	public Message getMessage() {
		ItemStatusUpdate m = new ItemStatusUpdate();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "1919700101    010000AB|AC|AO|CH|AY0AZF6EB";
	}
}


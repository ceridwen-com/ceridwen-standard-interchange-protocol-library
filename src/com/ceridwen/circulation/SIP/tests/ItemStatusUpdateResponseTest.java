package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.ItemStatusUpdateResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class ItemStatusUpdateResponseTest extends AbstractMessageTest<ItemStatusUpdateResponse> {

	@Override
	public Message getMessage() {
		ItemStatusUpdateResponse m = new ItemStatusUpdateResponse();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "20019700101    010000AB|AF|AG|AJ|CH|AY0AZF5C1";
	}
}


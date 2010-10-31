package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.ItemInformationResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class ItemInformationResponseTest extends AbstractMessageTest<ItemInformationResponse> {

	@Override
	public Message getMessage() {
		ItemInformationResponse m = new ItemInformationResponse();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "1801000119700101    010000AB|AF|AG|AH|AJ|AP|AQ|BG|BHUSD|BV|CF|CH|CJ|CK000|CM|AY0AZE8E9";
	}
}


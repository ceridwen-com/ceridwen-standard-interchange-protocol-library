package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.ItemStatusUpdateResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class ItemStatusUpdateResponseTest extends AbstractMessageTest<ItemStatusUpdateResponse> {

	@Override
	public Message getDefaultMessage() {
		ItemStatusUpdateResponse m = new ItemStatusUpdateResponse();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "20019700101    010000AB|";
	}
	
	@Override
	public Message getMessage() {
		ItemStatusUpdateResponse m = new ItemStatusUpdateResponse();

		m.setItemIdentifier("itemIdentifier");
		m.setItemProperties("itemProperties");
		m.setOk(true);
		m.setPrintLine("printLine");
		m.setScreenMessage("screenMessage");
		m.setTitleIdentifier("titleIdentifier");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "20119700101    010000ABitemIdentifier|AFscreenMessage|AGprintLine|AJtitleIdentifier|CHitemProperties|";
	}
}


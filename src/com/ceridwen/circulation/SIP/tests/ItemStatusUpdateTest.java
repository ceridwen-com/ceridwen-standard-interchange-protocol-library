package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.ItemStatusUpdate;
import com.ceridwen.circulation.SIP.messages.Message;

public class ItemStatusUpdateTest extends AbstractMessageTest<ItemStatusUpdate> {
	@Override
	public Message getDefaultMessage() {
		ItemStatusUpdate m = new ItemStatusUpdate();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "1919700101    010000AB|AO|CH|";
	}

	@Override
	public Message getMessage() {
		ItemStatusUpdate m = new ItemStatusUpdate();

		m.setInstitutionId("institutionId");
		m.setItemIdentifier("itemIdentifier");
		m.setItemProperties("itemProperties");
		m.setTerminalPassword("terminalPassword");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "1919700101    010000ABitemIdentifier|ACterminalPassword|AOinstitutionId|CHitemProperties|";
	}
}


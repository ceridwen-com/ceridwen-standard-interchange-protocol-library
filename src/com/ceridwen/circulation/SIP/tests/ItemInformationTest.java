package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.ItemInformation;
import com.ceridwen.circulation.SIP.messages.Message;

public class ItemInformationTest extends AbstractMessageTest<ItemInformation> {

	@Override
	public Message getMessage() {
		ItemInformation m = new ItemInformation();

		m.setInstitutionId("institution");
		m.setItemIdentifier("item");
		m.setTerminalPassword("password");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {		
		return "1719700101    010000ABitem|ACpassword|AOinstitution|AY0AZEE08";
	}
}


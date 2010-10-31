package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.BlockPatron;
import com.ceridwen.circulation.SIP.messages.Message;

public class BlockPatronTest extends AbstractMessageTest<BlockPatron> {

	@Override
	public Message getMessage() {
		BlockPatron m = new BlockPatron();

		m.setBlockedCardMessage("Message");
		m.setCardRetained(true);
		m.setInstitutionId("Institution");
		m.setPatronIdentifier("Patron");
		m.setTerminalPassword("Password");
		m.setTransactionDate(new java.util.Date(0));
		
		return m;
	}

	@Override
	public String getEncoding() {
		return "01Y19700101    010000AAPatron|ACPassword|ALMessage|AOInstitution|AY0AZE964";
	}
}


package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.BlockPatron;
import com.ceridwen.circulation.SIP.messages.Message;

public class BlockPatronTest extends AbstractMessageTest<BlockPatron> {

	@Override
	public Message getDefaultMessage() {
		BlockPatron m = new BlockPatron();

		m.setTransactionDate(new java.util.Date(0));
		
		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "01N19700101    010000AA|AC|AL|AO|AY0AZF6A5";
	}

	@Override
	public Message getMessage() {
		BlockPatron m = new BlockPatron();

		m.setBlockedCardMessage("blockedCardMessage");
		m.setCardRetained(true);
		m.setInstitutionId("institutionId");
		m.setPatronIdentifier("patronIdentifier");
		m.setTerminalPassword("terminalPassword");
		m.setTransactionDate(new java.util.Date(0));
		
		return m;
	}

	@Override
	public String getEncoding() {
		return "01Y19700101    010000AApatronIdentifier|ACterminalPassword|ALblockedCardMessage|AOinstitutionId|AY0AZDCCA";
	}

}


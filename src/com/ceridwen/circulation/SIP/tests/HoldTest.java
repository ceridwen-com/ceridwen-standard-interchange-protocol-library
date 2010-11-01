package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.Hold;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.enumerations.HoldMode;
import com.ceridwen.circulation.SIP.types.enumerations.HoldType;

public class HoldTest extends AbstractMessageTest<Hold> {
	@Override
	public Message getDefaultMessage() {
		Hold m = new Hold();
		
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "15*19700101    010000AA|AB|AC|AD|AJ|AO|BON|BS|BW|BY1|AY0AZEFFD";
	}

	@Override
	public Message getMessage() {
		Hold m = new Hold();
		
		m.setExpirationDate(new java.util.Date(0));
		m.setFeeAcknowledged(true);
		m.setHoldMode(HoldMode.DELETE);		
		m.setHoldType(HoldType.SUBLOCATION_COPY);
		m.setInstitutionId("institutionId");
		m.setItemIdentifier("itemIdentifier");
		m.setPatronIdentifier("patronIdentifier");
		m.setPatronPassword("patronPassword");
		m.setPickupLocation("pickupLocation");
		m.setTerminalPassword("terminalPassword");
		m.setTitleIdentifier("titleIdentifier");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "15-19700101    010000AApatronIdentifier|ABitemIdentifier|ACterminalPassword|ADpatronPassword|AJtitleIdentifier|AOinstitutionId|BOY|BSpickupLocation|BW19700101    010000|BY4|AY0AZC278";
	}
}


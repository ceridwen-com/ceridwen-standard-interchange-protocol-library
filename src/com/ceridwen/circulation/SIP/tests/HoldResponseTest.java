package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.HoldResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class HoldResponseTest extends AbstractMessageTest<HoldResponse> {
	@Override
	public Message getDefaultMessage() {
		HoldResponse m = new HoldResponse();
		
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "160N19700101    010000AA|AO|";
	}

	@Override
	public Message getMessage() {
		HoldResponse m = new HoldResponse();
		
		m.setAvailable(true);
		m.setExpirationDate(new java.util.Date(0));
		m.setInstitutionId("institutionId");
		m.setItemIdentifier("itemIdentifier");
		m.setOk(true);
		m.setPatronIdentifier("patronIdentifier");
		m.setPickupLocation("pickupLocation");
		m.setPrintLine("printLine");
		m.setQueuePosition(12345);
		m.setScreenMessage("screenMessage");
		m.setTitleIdentifier("titleIdentifier");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "161Y19700101    010000AApatronIdentifier|ABitemIdentifier|AFscreenMessage|AGprintLine|AJtitleIdentifier|AOinstitutionId|BR12345|BSpickupLocation|BW19700101    010000|";
	}
}


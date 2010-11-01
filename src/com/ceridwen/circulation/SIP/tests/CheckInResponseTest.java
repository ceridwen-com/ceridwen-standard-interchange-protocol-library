package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.CheckInResponse;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.enumerations.MediaType;

public class CheckInResponseTest extends AbstractMessageTest<CheckInResponse> {
	@Override
	public Message getDefaultMessage() {
		CheckInResponse m = new CheckInResponse();
		
		m.setTransactionDate(new java.util.Date(0));
		
		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "100NNN19700101    010000AA|AB|AF|AG|AJ|AO|AQ|CH|CK000|CL|AY0AZEF1B";
	}

	@Override
	public Message getMessage() {
		CheckInResponse m = new CheckInResponse();
		
		m.setAlert(true);
		m.setInstitutionId("institutionId");
		m.setItemIdentifier("itemIdentifier");
		m.setItemProperties("itemProperties");
		m.setMagenticMedia(true);
		m.setMediaType(MediaType.CD);
		m.setOk(true);
		m.setPatronIdentifier("patronIdentifier");
		m.setPermanentLocation("permanentLocation");
		m.setPrintLine("printLine");
		m.setResensitize(true);
		m.setScreenMessage("screenMessage");
		m.setSortBin("sortBin");
		m.setTitleIdentifier("titleIdentifier");
		m.setTransactionDate(new java.util.Date(0));
		
		return m;
	}

	@Override
	public String getEncoding() {
		return "101YYY19700101    010000AApatronIdentifier|ABitemIdentifier|AFscreenMessage|AGprintLine|AJtitleIdentifier|AOinstitutionId|AQpermanentLocation|CHitemProperties|CK006|CLsortBin|AY0AZBE54";
	}
}


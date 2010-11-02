package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.RenewAllResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class RenewAllResponseTest extends AbstractMessageTest<RenewAllResponse> {

	@Override
	public Message getDefaultMessage() {
		RenewAllResponse m = new RenewAllResponse();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "6600000000019700101    010000AO|";
	}

	@Override
	public Message getMessage() {
		RenewAllResponse m = new RenewAllResponse();

		m.setInstitutionId("institutionId");
		m.setOk(true);
		m.setPrintLine("printLine");
		m.setRenewedCount(1234);
		m.setUnrenewedCount(1234);
		m.setScreenMessage("screenMessage");
		m.setTransactionDate(new java.util.Date(0));
		
		return m;
	}

	@Override
	public String getEncoding() {
		return "6611234123419700101    010000AFscreenMessage|AGprintLine|AOinstitutionId|";
	}
}


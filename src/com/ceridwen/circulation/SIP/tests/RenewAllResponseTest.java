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
		return "660        19700101    010000AF|AG|AO|AY0AZF6B8";
	}

	@Override
	public Message getMessage() {
		RenewAllResponse m = new RenewAllResponse();

		m.setInstitutionId("institutionId");
		m.setOk(true);
		m.setPrintLine("printLine");
		m.setRenewedCount("item");
		m.setUnrenewedCount("item");
		m.setScreenMessage("screenMessage");
		m.setTransactionDate(new java.util.Date(0));
		
		return m;
	}

	@Override
	public String getEncoding() {
		return "661itemitem19700101    010000AFscreenMessage|AGprintLine|AOinstitutionId|AY0AZE5E8";
	}
}


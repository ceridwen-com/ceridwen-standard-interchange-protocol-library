package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.SCStatus;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.enumerations.StatusCode;

public class SCStatusTest extends AbstractMessageTest<SCStatus> {
	@Override
	public Message getDefaultMessage() {
		SCStatus m = new SCStatus();

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "990   2.00AY0AZFCD9";
	}

	@Override
	public Message getMessage() {
		SCStatus m = new SCStatus();
		
		m.setMaxPrintWidth("max");
		m.setProtocolVersion("prot");
		m.setStatusCode(StatusCode.OUT_OF_PAPER);

		return m;
	}

	@Override
	public String getEncoding() {
		return "991maxprotAY0AZFAED";
	}
}


package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.ACSResend;
import com.ceridwen.circulation.SIP.messages.Message;

public class ACSResendTest extends AbstractMessageTest<ACSResend> {

	@Override
	public Message getMessage() {
		ACSResend m = new ACSResend();
		
		return m;
	}

	@Override
	public String getEncoding() {
		return "97AZFEF5";
	}
}


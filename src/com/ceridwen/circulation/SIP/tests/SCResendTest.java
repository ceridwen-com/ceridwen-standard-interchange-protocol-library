package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.SCResend;
import com.ceridwen.circulation.SIP.messages.Message;

public class SCResendTest extends AbstractMessageTest<SCResend> {
	@Override
	public Message getDefaultMessage() {
		SCResend m = new SCResend();

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "96AZFEF6";
	}
	
	@Override
	public Message getMessage() {
		SCResend m = new SCResend();

		return m;
	}

	@Override
	public String getEncoding() {
		return "96AZFEF6";
	}
}


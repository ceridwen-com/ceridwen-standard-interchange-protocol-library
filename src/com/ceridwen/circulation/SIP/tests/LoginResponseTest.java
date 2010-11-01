package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.LoginResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class LoginResponseTest extends AbstractMessageTest<LoginResponse> {

	@Override
	public Message getDefaultMessage() {
		LoginResponse m = new LoginResponse();
		
		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "940AY0AZFDFE";
	}

	@Override
	public Message getMessage() {
		LoginResponse m = new LoginResponse();
		
		m.setOk(true);

		return m;
	}

	@Override
	public String getEncoding() {
		return "941AY0AZFDFD";
	}

}


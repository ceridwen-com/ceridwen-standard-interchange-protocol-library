package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.LoginResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class LoginResponseTest extends AbstractMessageTest<LoginResponse> {

	@Override
	public Message getMessage() {
		LoginResponse m = new LoginResponse();

		/**
		 * TODO Populate properties. 		
		 */

		return m;
	}

	@Override
	public String getEncoding() {
		return "940AY0AZFDFE";
	}
}


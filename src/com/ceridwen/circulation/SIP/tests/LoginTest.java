package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.Login;
import com.ceridwen.circulation.SIP.messages.Message;

public class LoginTest extends AbstractMessageTest<Login> {

	@Override
	public Message getMessage() {
		Login m = new Login();

		/**
		 * TODO Populate properties. 		
		 */

		return m;
	}

	@Override
	public String getEncoding() {
		return "93  CN|CO|CP|AY0AZFAC5";
	}
}


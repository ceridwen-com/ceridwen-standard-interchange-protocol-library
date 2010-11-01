package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.Login;
import com.ceridwen.circulation.SIP.messages.Message;

public class LoginTest extends AbstractMessageTest<Login> {
	@Override
	public Message getDefaultMessage() {
		Login m = new Login();
		
		return m;	}

	@Override
	public String getDefaultEncoding() {
		return "93  CN|CO|CP|AY0AZFAC5";
	}

	@Override
	public Message getMessage() {
		Login m = new Login();
		
		m.setLocationCode("locationCode");
		m.setLoginPassword("loginPassword");
		m.setLoginUserId("loginUserId");
		m.setPWDAlgorithm("P");
		m.setUIDAlgorithm("U");

		return m;
	}

	@Override
	public String getEncoding() {
		return "93UPCNloginUserId|COloginPassword|CPlocationCode|AY0AZEBBB";
	}
}


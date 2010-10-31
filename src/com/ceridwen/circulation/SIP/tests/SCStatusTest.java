package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.SCStatus;
import com.ceridwen.circulation.SIP.messages.Message;

public class SCStatusTest extends AbstractMessageTest<SCStatus> {

	@Override
	public Message getMessage() {
		SCStatus m = new SCStatus();

		/**
		 * TODO Populate properties. 		
		 */

		return m;
	}

	@Override
	public String getEncoding() {
		return "990   2.00AY0AZFCD9";
	}
}


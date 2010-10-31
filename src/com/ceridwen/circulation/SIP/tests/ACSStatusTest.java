package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.ACSStatus;
import com.ceridwen.circulation.SIP.messages.Message;

public class ACSStatusTest extends AbstractMessageTest<ACSStatus> {

	@Override
	public Message getMessage() {
		ACSStatus m = new ACSStatus();

		/**
		 * TODO Populate properties. 		
		 */

		m.setDateTimeSync(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "98NNNNNN      19700101    010000    AF|AG|AM|AN|AO|BXNNNNNNNNNNNNNNNN|AY0AZECC4";
	}
}


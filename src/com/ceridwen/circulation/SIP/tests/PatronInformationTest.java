package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.PatronInformation;
import com.ceridwen.circulation.SIP.messages.Message;

public class PatronInformationTest extends AbstractMessageTest<PatronInformation> {

	@Override
	public Message getMessage() {
		PatronInformation m = new PatronInformation();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "6300019700101    010000          AA|AC|AD|AO|AY0AZF523";
	}
}


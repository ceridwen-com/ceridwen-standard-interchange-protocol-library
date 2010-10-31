package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.PatronInformationResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class PatronInformationResponseTest extends AbstractMessageTest<PatronInformationResponse> {

	@Override
	public Message getMessage() {
		PatronInformationResponse m = new PatronInformationResponse();

		/**
		 * TODO Populate properties. 		
		 */

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "64              00019700101    010000                        AA|AE|AF|AG|AO|BD|BE|BF|BHUSD|BLN|BV|BZ|CA|CB|CC|CQN|AY0AZE3BA";
	}
}


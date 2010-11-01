package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.FeePaid;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.enumerations.CurrencyType;
import com.ceridwen.circulation.SIP.types.enumerations.FeeType;
import com.ceridwen.circulation.SIP.types.enumerations.PaymentType;

public class FeePaidTest extends AbstractMessageTest<FeePaid> {
	@Override
	public Message getDefaultMessage() {
		FeePaid m = new FeePaid();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "3719700101    0100000100USDAA|AC|AD|AO|BK|BV|CG|AY0AZF222";
	}

	@Override
	public Message getMessage() {
		FeePaid m = new FeePaid();
		
		m.setCurrencyType(CurrencyType.UK_POUNDS);
		m.setFeeAmount("feeAmount");
		m.setFeeIdentifier("feeIdentifier");
		m.setFeeType(FeeType.REPLACEMENT);
		m.setInstitutionId("institutionId");
		m.setPatronIdentifier("patronIdentifier");
		m.setPatronPassword("patronPassword");
		m.setPaymentType(PaymentType.VISA);
		m.setTerminalPassword("terminalPassword");
		m.setTransactionDate(new java.util.Date(0));
		m.setTransactionId("transactionId");

		return m;
	}

	@Override
	public String getEncoding() {
		return "3719700101    0100000701GBPAApatronIdentifier|ACterminalPassword|ADpatronPassword|AOinstitutionId|BKtransactionId|BVfeeAmount|CGfeeIdentifier|AY0AZCB60";
	}
}


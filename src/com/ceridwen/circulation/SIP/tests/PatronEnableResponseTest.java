package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.PatronEnableResponse;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.enumerations.Language;
import com.ceridwen.circulation.SIP.types.flagfields.PatronStatus;

public class PatronEnableResponseTest extends AbstractMessageTest<PatronEnableResponse> {
	@Override
	public Message getDefaultMessage() {
		PatronEnableResponse m = new PatronEnableResponse();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "26              00019700101    010000AA|AE|AF|AG|AO|BLN|CQN|AY0AZF0E6";
	}

	@Override
	public Message getMessage() {
		PatronEnableResponse m = new PatronEnableResponse();
		
		m.setInstitutionId("institutionId");
		m.setLanguage(Language.UNITED_KINGDOM);
		m.setPatronIdentifier("patronIdentifier");
		m.getPatronStatus().set(PatronStatus.CARD_REPORTED_LOST);
		m.getPatronStatus().set(PatronStatus.CHARGE_PRIVILEGES_DENIED);
		m.getPatronStatus().set(PatronStatus.EXCESSIVE_OUTSTANDING_FEES);
		m.getPatronStatus().set(PatronStatus.EXCESSIVE_OUTSTANDING_FINES);
		m.getPatronStatus().set(PatronStatus.HOLD_PRIVILIGES_DENIED);
		m.getPatronStatus().set(PatronStatus.RECALL_OVERDUE);
		m.getPatronStatus().set(PatronStatus.RECALL_PRIVILIGES_DENIED);
		m.getPatronStatus().set(PatronStatus.RENEWAL_PRIVILIGES_DENIED);
		m.getPatronStatus().set(PatronStatus.TOO_MANY_CLAIMS_OF_ITEMS_RETURNED);
		m.getPatronStatus().set(PatronStatus.TOO_MANY_ITEMS_BILLED);
		m.getPatronStatus().set(PatronStatus.TOO_MANY_ITEMS_CHARGED);
		m.getPatronStatus().set(PatronStatus.TOO_MANY_ITEMS_LOST);
		m.getPatronStatus().set(PatronStatus.TOO_MANY_ITEMS_OVERDUE);
		m.getPatronStatus().set(PatronStatus.TOO_MANY_RENEWALS);
		m.setPersonalName("personalName");
		m.setPrintLine("printLine");
		m.setScreenMessage("screenMessage");
		m.setTransactionDate(new java.util.Date(0));
		m.setValidPatron(true);
		m.setValidPatronPassword(true);

		return m;
	}

	@Override
	public String getEncoding() {
		return "26YYYYYYYYYYYYYY02419700101    010000AApatronIdentifier|AEpersonalName|AFscreenMessage|AGprintLine|AOinstitutionId|BLY|CQY|AY0AZD3BF";
	}
}


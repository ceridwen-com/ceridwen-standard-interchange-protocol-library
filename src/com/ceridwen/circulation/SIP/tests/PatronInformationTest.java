package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.PatronInformation;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.enumerations.Language;
import com.ceridwen.circulation.SIP.types.flagfields.Summary;

public class PatronInformationTest extends AbstractMessageTest<PatronInformation> {

	@Override
	public Message getDefaultMessage() {
		PatronInformation m = new PatronInformation();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "6300019700101    010000          AA|AO|";
	}

	@Override
	public Message getMessage() {
		PatronInformation m = new PatronInformation();		
		m.setEndItem(12345);
		m.setInstitutionId("institutionId");
		m.setLanguage(Language.UNITED_KINGDOM);
		m.setPatronIdentifier("patronIdentifier");
		m.setPatronPassword("patronPassword");
		m.setStartItem(12345);
		m.getSummary().set(Summary.OVERDUE_ITEMS);
		m.setTerminalPassword("terminalPassword");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "6302419700101    010000 Y        AApatronIdentifier|ACterminalPassword|ADpatronPassword|AOinstitutionId|BP12345|BQ12345|";
	}

}


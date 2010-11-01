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
		return "6300019700101    010000          AA|AC|AD|AO|AY0AZF523";
	}

	@Override
	public Message getMessage() {
		PatronInformation m = new PatronInformation();		
		m.setEndItem("endItem");
		m.setInstitutionId("institutionId");
		m.setLanguage(Language.UNITED_KINGDOM);
		m.setPatronIdentifier("patronIdentifier");
		m.setPatronPassword("patronPassword");
		m.setStartItem("startItem");
		m.getSummary().set(Summary.OVERDUE_ITEMS);
		m.setTerminalPassword("terminalPassword");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "6302419700101    010000 Y        AApatronIdentifier|ACterminalPassword|ADpatronPassword|AOinstitutionId|BPstartItem|BQendItem|AY0AZD3A0";
	}

}


package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.ACSStatus;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.flagfields.SupportedMessages;

public class ACSStatusTest extends AbstractMessageTest<ACSStatus> {
	@Override
	public Message getDefaultMessage() {
		ACSStatus m = new ACSStatus();

		m.setDateTimeSync(new java.util.Date(0));
		
		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "98NNNNNN      19700101    010000    AF|AG|AM|AN|AO|BXNNNNNNNNNNNNNNNN|AY0AZECC4";
	}

	@Override
	public Message getMessage() {
		ACSStatus m = new ACSStatus();
		
		m.setCheckInOk(true);
		m.setCheckOutOk(true);
		m.setDateTimeSync(new java.util.Date(0));
		m.setInstitutionId("institutionId");
		m.setLibraryName("libraryName");
		m.setOfflineOk(true);
		m.setOnLineStatus(true);
		m.setPrintLine("printLine");
		m.setProtocolVersion("2.00");
		m.setRenewalPolicy(true);
		m.setRetriesAllowed("ret");
		m.setScreenMessage("screenMessage"); 
		m.setStatusUpdateOk(true);
		m.getSupportedMessages().set(SupportedMessages.BLOCK_PATRON);
		m.getSupportedMessages().set(SupportedMessages.CHECK_IN);
		m.getSupportedMessages().set(SupportedMessages.CHECK_OUT);
		m.getSupportedMessages().set(SupportedMessages.END_PATRON_SESSION);
		m.getSupportedMessages().set(SupportedMessages.FEE_PAID);
		m.getSupportedMessages().set(SupportedMessages.HOLD);
		m.getSupportedMessages().set(SupportedMessages.ITEM_INFORMATION);
		m.getSupportedMessages().set(SupportedMessages.ITEM_STATUS_UPDATE);
		m.getSupportedMessages().set(SupportedMessages.LOGIN);
		m.getSupportedMessages().set(SupportedMessages.PATRON_ENABLE);
		m.getSupportedMessages().set(SupportedMessages.PATRON_INFORMATION);
		m.getSupportedMessages().set(SupportedMessages.PATRON_STATUS_REQUEST);
		m.getSupportedMessages().set(SupportedMessages.RENEW);
		m.getSupportedMessages().set(SupportedMessages.RENEW_ALL);
		m.getSupportedMessages().set(SupportedMessages.REQUEST_SC_ACS_RESEND);
		m.getSupportedMessages().set(SupportedMessages.SC_ACS_STATUS);
		m.setTerminalLocation("terminalLocation");
		m.setTimeoutPeriod("tim");

		return m;
	}

	@Override
	public String getEncoding() {
		return "98YYYYYYtimret19700101    0100002.00AFscreenMessage|AGprintLine|AMlibraryName|ANterminalLocation|AOinstitutionId|BXYYYYYYYYYYYYYYYY|AY0AZD041";
	}

}


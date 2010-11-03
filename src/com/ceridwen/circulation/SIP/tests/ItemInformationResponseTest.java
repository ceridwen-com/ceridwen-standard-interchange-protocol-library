package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.ItemInformationResponse;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.enumerations.CirculationStatus;
import com.ceridwen.circulation.SIP.types.enumerations.CurrencyType;
import com.ceridwen.circulation.SIP.types.enumerations.FeeType;
import com.ceridwen.circulation.SIP.types.enumerations.MediaType;
import com.ceridwen.circulation.SIP.types.enumerations.SecurityMarker;

public class ItemInformationResponseTest extends AbstractMessageTest<ItemInformationResponse> {
	@Override
	public Message getDefaultMessage() {
		ItemInformationResponse m = new ItemInformationResponse();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "1801000119700101    010000AB|AJ|";
	}

	@Override
	public Message getMessage() {
		ItemInformationResponse m = new ItemInformationResponse();

		m.setCirculationStatus(CirculationStatus.LOST);		
		m.setCurrencyType(CurrencyType.UK_POUNDS);
		m.setCurrentLocation("currentLocation");
		m.setDueDate("dueDate");
		m.setFeeAmount("feeAmount");
		m.setFeeType(FeeType.REPLACEMENT);
		m.setHoldPickupDate(new java.util.Date(0));
		m.setHoldQueueLength(100);
		m.setItemIdentifier("itemIdentifier");
		m.setItemProperties("itemProperties");
		m.setMediaType(MediaType.DISKETTE);
		m.setOwner("owner");
		m.setPrintLine("printLine");
		m.setPermanentLocation("permanentLocation");
		m.setRecallDate(new java.util.Date(0));
		m.setScreenMessage("screenMessage");
		m.setSecurityMarker(SecurityMarker.TATTLE_TAPE);
		m.setTitleIdentifier("titleIdentifier");
		m.setTransactionDate(new java.util.Date(0));
		
		return m;
	}

	@Override
	public String getEncoding() {
		return "1812020719700101    010000ABitemIdentifier|AFscreenMessage|AGprintLine|AHdueDate|AJtitleIdentifier|APcurrentLocation|AQpermanentLocation|BGowner|BHGBP|BVfeeAmount|CF100|CHitemProperties|CJ19700101    010000|CK007|CM19700101    010000|";
	}
}


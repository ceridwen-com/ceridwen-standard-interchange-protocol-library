package com.ceridwen.circulation.SIP.netty.server.driver.operation;

import com.ceridwen.circulation.SIP.messages.PatronInformation;
import com.ceridwen.circulation.SIP.messages.PatronInformationResponse;

public interface PatronInformationOperation {

	public abstract PatronInformationResponse PatronInformation(
			PatronInformation msg);

}
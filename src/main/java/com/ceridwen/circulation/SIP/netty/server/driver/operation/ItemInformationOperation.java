package com.ceridwen.circulation.SIP.netty.server.driver.operation;

import com.ceridwen.circulation.SIP.messages.ItemInformation;
import com.ceridwen.circulation.SIP.messages.ItemInformationResponse;

public interface ItemInformationOperation {

	public abstract ItemInformationResponse ItemInformation(ItemInformation msg);

}
package com.ceridwen.circulation.SIP.netty.server.driver.operation;

import com.ceridwen.circulation.SIP.messages.PatronEnable;
import com.ceridwen.circulation.SIP.messages.PatronEnableResponse;

public interface PatronEnableOperation {

	public abstract PatronEnableResponse PatronEnable(PatronEnable msg);

}
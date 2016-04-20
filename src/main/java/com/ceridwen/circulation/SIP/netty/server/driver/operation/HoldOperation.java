package com.ceridwen.circulation.SIP.netty.server.driver.operation;

import com.ceridwen.circulation.SIP.messages.Hold;
import com.ceridwen.circulation.SIP.messages.HoldResponse;

public interface HoldOperation {

	public abstract HoldResponse Hold(Hold msg);

}
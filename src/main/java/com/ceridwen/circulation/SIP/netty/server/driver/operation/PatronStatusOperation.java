package com.ceridwen.circulation.SIP.netty.server.driver.operation;

import com.ceridwen.circulation.SIP.messages.PatronStatusRequest;
import com.ceridwen.circulation.SIP.messages.PatronStatusResponse;

public interface PatronStatusOperation {

	public abstract PatronStatusResponse PatronStatus(PatronStatusRequest msg);

}
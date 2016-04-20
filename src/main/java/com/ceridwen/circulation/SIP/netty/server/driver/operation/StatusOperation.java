package com.ceridwen.circulation.SIP.netty.server.driver.operation;

import com.ceridwen.circulation.SIP.messages.ACSStatus;
import com.ceridwen.circulation.SIP.messages.SCStatus;

public interface StatusOperation {

	public abstract ACSStatus Status(SCStatus msg);

}
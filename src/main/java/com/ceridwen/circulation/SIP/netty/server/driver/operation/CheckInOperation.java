package com.ceridwen.circulation.SIP.netty.server.driver.operation;

import com.ceridwen.circulation.SIP.messages.CheckIn;
import com.ceridwen.circulation.SIP.messages.CheckInResponse;

public interface CheckInOperation {

	public abstract CheckInResponse CheckIn(CheckIn msg);

}
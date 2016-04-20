package com.ceridwen.circulation.SIP.netty.server.driver.operation;

import com.ceridwen.circulation.SIP.messages.CheckOut;
import com.ceridwen.circulation.SIP.messages.CheckOutResponse;

public interface CheckOutOperation {

	public abstract CheckOutResponse CheckOut(CheckOut msg);

}
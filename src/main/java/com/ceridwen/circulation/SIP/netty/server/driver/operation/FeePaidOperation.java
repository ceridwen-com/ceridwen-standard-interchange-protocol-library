package com.ceridwen.circulation.SIP.netty.server.driver.operation;

import com.ceridwen.circulation.SIP.messages.FeePaid;
import com.ceridwen.circulation.SIP.messages.FeePaidResponse;

public interface FeePaidOperation {

	public abstract FeePaidResponse FeePaid(FeePaid msg);

}
package com.ceridwen.circulation.SIP.netty.server.driver.operation;

import com.ceridwen.circulation.SIP.messages.Renew;
import com.ceridwen.circulation.SIP.messages.RenewResponse;

public interface RenewOperation {

	public abstract RenewResponse Renew(Renew msg);

}
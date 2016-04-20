package com.ceridwen.circulation.SIP.netty.server.driver.operation;

import com.ceridwen.circulation.SIP.messages.RenewAll;
import com.ceridwen.circulation.SIP.messages.RenewAllResponse;

public interface RenewAllOperation {
    public RenewAllResponse RenewAll(RenewAll msg);

}
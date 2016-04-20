package com.ceridwen.circulation.SIP.netty.server.driver;

import com.ceridwen.circulation.SIP.netty.server.driver.operation.RequestResendOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.StatusOperation;

public interface Driver extends RequestResendOperation, StatusOperation {
}
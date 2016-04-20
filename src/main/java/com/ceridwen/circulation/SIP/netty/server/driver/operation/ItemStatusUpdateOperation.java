package com.ceridwen.circulation.SIP.netty.server.driver.operation;

import com.ceridwen.circulation.SIP.messages.ItemStatusUpdate;
import com.ceridwen.circulation.SIP.messages.ItemStatusUpdateResponse;

public interface ItemStatusUpdateOperation {

	public abstract ItemStatusUpdateResponse ItemStatusUpdate(
			ItemStatusUpdate msg);

}
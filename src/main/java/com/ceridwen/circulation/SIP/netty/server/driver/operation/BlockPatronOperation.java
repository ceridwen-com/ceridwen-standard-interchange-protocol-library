package com.ceridwen.circulation.SIP.netty.server.driver.operation;

import com.ceridwen.circulation.SIP.messages.BlockPatron;
import com.ceridwen.circulation.SIP.messages.PatronStatusResponse;

public interface BlockPatronOperation {

	public abstract PatronStatusResponse BlockPatron(BlockPatron msg);

}
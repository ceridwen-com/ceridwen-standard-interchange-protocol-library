package com.ceridwen.circulation.SIP.netty.server.driver.operation;

import com.ceridwen.circulation.SIP.messages.EndPatronSession;
import com.ceridwen.circulation.SIP.messages.EndSessionResponse;

public interface EndPatronSessionOperation {

	public abstract EndSessionResponse EndPatronSession(EndPatronSession msg);

}
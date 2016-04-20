package com.ceridwen.circulation.SIP.netty.server.driver;

import java.util.Date;

import com.ceridwen.circulation.SIP.messages.ACSStatus;
import com.ceridwen.circulation.SIP.messages.SCStatus;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.BlockPatronOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.CheckInOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.CheckOutOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.EndPatronSessionOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.FeePaidOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.HoldOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.ItemInformationOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.ItemStatusUpdateOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.LoginOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.PatronEnableOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.PatronInformationOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.PatronStatusOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.RenewAllOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.RenewOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.RequestResendOperation;
import com.ceridwen.circulation.SIP.netty.server.driver.operation.StatusOperation;
import com.ceridwen.circulation.SIP.types.enumerations.ProtocolVersion;
import com.ceridwen.circulation.SIP.types.flagfields.SupportedMessages;

public abstract class AbstractDriver implements Driver {

	@Override
	public final ACSStatus Status(SCStatus msg) {
		// TODO Auto-generated method stub
        ACSStatus response = new ACSStatus(); 
        if (this instanceof BlockPatronOperation) {
        	response.getSupportedMessages().set(SupportedMessages.BLOCK_PATRON);
        }
        if (this instanceof CheckInOperation) {
	        response.getSupportedMessages().set(SupportedMessages.CHECK_IN);
        }
        if (this instanceof CheckOutOperation) {
	        response.getSupportedMessages().set(SupportedMessages.CHECK_OUT);
		}
        if (this instanceof EndPatronSessionOperation) {
	        response.getSupportedMessages().set(SupportedMessages.END_PATRON_SESSION);
		}
        if (this instanceof FeePaidOperation) {
	        response.getSupportedMessages().set(SupportedMessages.FEE_PAID);
	    }
        if (this instanceof HoldOperation) {
	        response.getSupportedMessages().set(SupportedMessages.HOLD);
	    }
		if (this instanceof ItemInformationOperation) {
	        response.getSupportedMessages().set(SupportedMessages.ITEM_INFORMATION);
    	}
		if (this instanceof ItemStatusUpdateOperation) {
	        response.getSupportedMessages().set(SupportedMessages.ITEM_STATUS_UPDATE);
	    }
	    if (this instanceof LoginOperation) {
	        response.getSupportedMessages().set(SupportedMessages.LOGIN);
	    }
	    if (this instanceof PatronEnableOperation) {
	        response.getSupportedMessages().set(SupportedMessages.PATRON_ENABLE);
	    }
	    if (this instanceof PatronInformationOperation) {
	        response.getSupportedMessages().set(SupportedMessages.PATRON_INFORMATION);
	    }
	    if (this instanceof PatronStatusOperation) {
	        response.getSupportedMessages().set(SupportedMessages.PATRON_STATUS_REQUEST);
	    }
	    if (this instanceof RenewOperation) {
	        response.getSupportedMessages().set(SupportedMessages.RENEW);
	    }
	    if (this instanceof RenewAllOperation) {
	        response.getSupportedMessages().set(SupportedMessages.RENEW_ALL);
	    }
	    if (this instanceof RequestResendOperation) {
	        response.getSupportedMessages().set(SupportedMessages.REQUEST_SC_ACS_RESEND);
	    }
	    if (this instanceof StatusOperation) {
	        response.getSupportedMessages().set(SupportedMessages.SC_ACS_STATUS);
    	}
	    
	    response.setDateTimeSync(new Date());
	    response.setProtocolVersion(ProtocolVersion.VERSION_2_00);
	    response.setRetriesAllowed(999);
	    response.setTimeoutPeriod(999);
		return this.Status(response, msg);
	}
	
	abstract public ACSStatus Status(ACSStatus status, SCStatus msg);
}

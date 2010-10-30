package com.ceridwen.circulation.SIP.server;

import com.ceridwen.circulation.SIP.messages.ACSStatus;
import com.ceridwen.circulation.SIP.messages.CheckInResponse;
import com.ceridwen.circulation.SIP.messages.CheckOutResponse;
import com.ceridwen.circulation.SIP.messages.EndSessionResponse;
import com.ceridwen.circulation.SIP.messages.FeePaidResponse;
import com.ceridwen.circulation.SIP.messages.HoldResponse;
import com.ceridwen.circulation.SIP.messages.ItemInformationResponse;
import com.ceridwen.circulation.SIP.messages.ItemStatusUpdateResponse;
import com.ceridwen.circulation.SIP.messages.LoginResponse;
import com.ceridwen.circulation.SIP.messages.PatronEnableResponse;
import com.ceridwen.circulation.SIP.messages.PatronInformationResponse;
import com.ceridwen.circulation.SIP.messages.PatronStatusRequest;
import com.ceridwen.circulation.SIP.messages.PatronStatusResponse;
import com.ceridwen.circulation.SIP.messages.RenewAllResponse;
import com.ceridwen.circulation.SIP.messages.RenewResponse;
import com.ceridwen.circulation.SIP.messages.SCStatus;

public class MessageHandlerDummyImpl implements MessageHandler {

	@Override
	public ACSStatus Status(SCStatus msg) {
		// TODO Auto-generated method stub
		return new ACSStatus();
	}

	@Override
	public PatronStatusResponse BlockPatron(
			com.ceridwen.circulation.SIP.messages.BlockPatron msg) {
		// TODO Auto-generated method stub
		return new PatronStatusResponse();
	}

	@Override
	public CheckInResponse CheckIn(
			com.ceridwen.circulation.SIP.messages.CheckIn msg) {
		// TODO Auto-generated method stub
		return new CheckInResponse();
	}

	@Override
	public CheckOutResponse CheckOut(
			com.ceridwen.circulation.SIP.messages.CheckOut msg) {
		// TODO Auto-generated method stub
		return new CheckOutResponse();
	}

	@Override
	public EndSessionResponse EndPatronSession(
			com.ceridwen.circulation.SIP.messages.EndPatronSession msg) {
		// TODO Auto-generated method stub
		return new EndSessionResponse();
	}

	@Override
	public FeePaidResponse FeePaid(
			com.ceridwen.circulation.SIP.messages.FeePaid msg) {
		// TODO Auto-generated method stub
		return new FeePaidResponse();
	}

	@Override
	public HoldResponse Hold(com.ceridwen.circulation.SIP.messages.Hold msg) {
		// TODO Auto-generated method stub
		return new HoldResponse();
	}

	@Override
	public ItemInformationResponse ItemInformation(
			com.ceridwen.circulation.SIP.messages.ItemInformation msg) {
		// TODO Auto-generated method stub
		return new ItemInformationResponse();
	}

	@Override
	public ItemStatusUpdateResponse ItemStatusUpdate(
			com.ceridwen.circulation.SIP.messages.ItemStatusUpdate msg) {
		// TODO Auto-generated method stub
		return new ItemStatusUpdateResponse();
	}

	@Override
	public LoginResponse Login(com.ceridwen.circulation.SIP.messages.Login msg) {
		// TODO Auto-generated method stub
		return new LoginResponse();
	}

	@Override
	public PatronEnableResponse PatronEnable(
			com.ceridwen.circulation.SIP.messages.PatronEnable msg) {
		// TODO Auto-generated method stub
		return new PatronEnableResponse();
	}

	@Override
	public PatronInformationResponse PatronInformation(
			com.ceridwen.circulation.SIP.messages.PatronInformation msg) {
		// TODO Auto-generated method stub
		return new PatronInformationResponse();
	}

	@Override
	public PatronStatusResponse PatronStatus(PatronStatusRequest msg) {
		// TODO Auto-generated method stub
		return new PatronStatusResponse();
	}

	@Override
	public RenewResponse Renew(com.ceridwen.circulation.SIP.messages.Renew msg) {
		// TODO Auto-generated method stub
		return new RenewResponse();
	}

	@Override
	public RenewAllResponse RenewAll(
			com.ceridwen.circulation.SIP.messages.RenewAll msg) {
		// TODO Auto-generated method stub
		return new RenewAllResponse();
	}

}

/* 
 * Copyright (C) 2020 Ceridwen Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ceridwen.circulation.SIP.server;

import com.ceridwen.circulation.SIP.messages.ACSStatus;
import com.ceridwen.circulation.SIP.messages.BlockPatron;
import com.ceridwen.circulation.SIP.messages.CheckIn;
import com.ceridwen.circulation.SIP.messages.CheckInResponse;
import com.ceridwen.circulation.SIP.messages.CheckOut;
import com.ceridwen.circulation.SIP.messages.CheckOutResponse;
import com.ceridwen.circulation.SIP.messages.EndPatronSession;
import com.ceridwen.circulation.SIP.messages.EndSessionResponse;
import com.ceridwen.circulation.SIP.messages.FeePaid;
import com.ceridwen.circulation.SIP.messages.FeePaidResponse;
import com.ceridwen.circulation.SIP.messages.Hold;
import com.ceridwen.circulation.SIP.messages.HoldResponse;
import com.ceridwen.circulation.SIP.messages.ItemInformation;
import com.ceridwen.circulation.SIP.messages.ItemInformationResponse;
import com.ceridwen.circulation.SIP.messages.ItemStatusUpdate;
import com.ceridwen.circulation.SIP.messages.ItemStatusUpdateResponse;
import com.ceridwen.circulation.SIP.messages.Login;
import com.ceridwen.circulation.SIP.messages.LoginResponse;
import com.ceridwen.circulation.SIP.messages.PatronEnable;
import com.ceridwen.circulation.SIP.messages.PatronEnableResponse;
import com.ceridwen.circulation.SIP.messages.PatronInformation;
import com.ceridwen.circulation.SIP.messages.PatronInformationResponse;
import com.ceridwen.circulation.SIP.messages.PatronStatusRequest;
import com.ceridwen.circulation.SIP.messages.PatronStatusResponse;
import com.ceridwen.circulation.SIP.messages.Renew;
import com.ceridwen.circulation.SIP.messages.RenewAll;
import com.ceridwen.circulation.SIP.messages.RenewAllResponse;
import com.ceridwen.circulation.SIP.messages.RenewResponse;
import com.ceridwen.circulation.SIP.messages.SCStatus;

@Deprecated
public interface MessageHandler {
    public ACSStatus Status(SCStatus msg);

    public PatronStatusResponse BlockPatron(BlockPatron msg);

    public CheckInResponse CheckIn(CheckIn msg);

    public CheckOutResponse CheckOut(CheckOut msg);

    public EndSessionResponse EndPatronSession(EndPatronSession msg);

    public FeePaidResponse FeePaid(FeePaid msg);

    public HoldResponse Hold(Hold msg);

    public ItemInformationResponse ItemInformation(ItemInformation msg);

    public ItemStatusUpdateResponse ItemStatusUpdate(ItemStatusUpdate msg);

    public LoginResponse Login(Login msg);

    public PatronEnableResponse PatronEnable(PatronEnable msg);

    public PatronInformationResponse PatronInformation(PatronInformation msg);

    public PatronStatusResponse PatronStatus(PatronStatusRequest msg);

    public RenewResponse Renew(Renew msg);

    public RenewAllResponse RenewAll(RenewAll msg);
}

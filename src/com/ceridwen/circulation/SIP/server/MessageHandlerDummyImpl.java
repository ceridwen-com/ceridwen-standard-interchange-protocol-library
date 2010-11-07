/*******************************************************************************
 * Copyright (c) 2010 Matthew J. Dovey (www.ceridwen.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at 
 * <http://www.gnu.org/licenses/>
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     Matthew J. Dovey (www.ceridwen.com) - initial API and implementation
 ******************************************************************************/
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
import com.ceridwen.circulation.SIP.types.flagfields.SupportedMessages;

public class MessageHandlerDummyImpl implements MessageHandler {

    @Override
    public ACSStatus Status(SCStatus msg) {
        ACSStatus response = new ACSStatus();
        response.getSupportedMessages().set(SupportedMessages.BLOCK_PATRON);
        response.getSupportedMessages().set(SupportedMessages.CHECK_IN);
        response.getSupportedMessages().set(SupportedMessages.CHECK_OUT);
        response.getSupportedMessages().set(SupportedMessages.END_PATRON_SESSION);
        response.getSupportedMessages().set(SupportedMessages.FEE_PAID);
        response.getSupportedMessages().set(SupportedMessages.HOLD);
        response.getSupportedMessages().set(SupportedMessages.ITEM_INFORMATION);
        response.getSupportedMessages().set(SupportedMessages.ITEM_STATUS_UPDATE);
        response.getSupportedMessages().set(SupportedMessages.LOGIN);
        response.getSupportedMessages().set(SupportedMessages.PATRON_ENABLE);
        response.getSupportedMessages().set(SupportedMessages.PATRON_INFORMATION);
        response.getSupportedMessages().set(SupportedMessages.PATRON_STATUS_REQUEST);
        response.getSupportedMessages().set(SupportedMessages.RENEW);
        response.getSupportedMessages().set(SupportedMessages.RENEW_ALL);
        response.getSupportedMessages().set(SupportedMessages.REQUEST_SC_ACS_RESEND);
        response.getSupportedMessages().set(SupportedMessages.SC_ACS_STATUS);
        return response;
    }

    @Override
    public PatronStatusResponse BlockPatron(
            com.ceridwen.circulation.SIP.messages.BlockPatron msg) {
        return new PatronStatusResponse();
    }

    @Override
    public CheckInResponse CheckIn(
            com.ceridwen.circulation.SIP.messages.CheckIn msg) {
        return new CheckInResponse();
    }

    @Override
    public CheckOutResponse CheckOut(
            com.ceridwen.circulation.SIP.messages.CheckOut msg) {
        return new CheckOutResponse();
    }

    @Override
    public EndSessionResponse EndPatronSession(
            com.ceridwen.circulation.SIP.messages.EndPatronSession msg) {
        return new EndSessionResponse();
    }

    @Override
    public FeePaidResponse FeePaid(
            com.ceridwen.circulation.SIP.messages.FeePaid msg) {
        return new FeePaidResponse();
    }

    @Override
    public HoldResponse Hold(com.ceridwen.circulation.SIP.messages.Hold msg) {
        return new HoldResponse();
    }

    @Override
    public ItemInformationResponse ItemInformation(
            com.ceridwen.circulation.SIP.messages.ItemInformation msg) {
        return new ItemInformationResponse();
    }

    @Override
    public ItemStatusUpdateResponse ItemStatusUpdate(
            com.ceridwen.circulation.SIP.messages.ItemStatusUpdate msg) {
        return new ItemStatusUpdateResponse();
    }

    @Override
    public LoginResponse Login(com.ceridwen.circulation.SIP.messages.Login msg) {
        return new LoginResponse();
    }

    @Override
    public PatronEnableResponse PatronEnable(
            com.ceridwen.circulation.SIP.messages.PatronEnable msg) {
        return new PatronEnableResponse();
    }

    @Override
    public PatronInformationResponse PatronInformation(
            com.ceridwen.circulation.SIP.messages.PatronInformation msg) {
        return new PatronInformationResponse();
    }

    @Override
    public PatronStatusResponse PatronStatus(PatronStatusRequest msg) {
        return new PatronStatusResponse();
    }

    @Override
    public RenewResponse Renew(com.ceridwen.circulation.SIP.messages.Renew msg) {
        return new RenewResponse();
    }

    @Override
    public RenewAllResponse RenewAll(
            com.ceridwen.circulation.SIP.messages.RenewAll msg) {
        return new RenewAllResponse();
    }

}

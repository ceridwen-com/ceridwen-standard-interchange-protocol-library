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
package com.ceridwen.circulation.SIP.samples.netty;

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
import com.ceridwen.circulation.SIP.netty.server.driver.AbstractDriver;
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

/**
 *
 * @author Matthew
 */
public class DummyDriver extends AbstractDriver
  implements  BlockPatronOperation,
              CheckInOperation,
              CheckOutOperation,
              EndPatronSessionOperation,
              FeePaidOperation,
              HoldOperation,
              ItemInformationOperation,
              ItemStatusUpdateOperation,
              LoginOperation,
              PatronEnableOperation,
              PatronInformationOperation,
              PatronStatusOperation,
              RenewAllOperation,
              RenewOperation
{

  @Override
  public ACSStatus Status(ACSStatus status, SCStatus msg) {
    status.setACSRenewalPolicy(false);
    status.setCheckInOk(true);
    status.setCheckOutOk(true);
    status.setOfflineOk(false);
    status.setStatusUpdateOk(true);
    return status;
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

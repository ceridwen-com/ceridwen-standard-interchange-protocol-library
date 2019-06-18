/* 
 * Copyright (C) 2019 Ceridwen Limited
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
package com.ceridwen.circulation.SIP.util;

import com.ceridwen.circulation.SIP.exceptions.InvalidFieldLength;
import com.ceridwen.circulation.SIP.exceptions.MandatoryFieldOmitted;
import com.ceridwen.circulation.SIP.exceptions.MessageNotUnderstood;
import com.ceridwen.circulation.SIP.messages.ACSStatus;
import com.ceridwen.circulation.SIP.messages.CheckIn;
import com.ceridwen.circulation.SIP.messages.CheckOut;
import com.ceridwen.circulation.SIP.messages.Message;

/**
 *
 * @author Matthew.Dovey
 */
public class MessageValidator {
  public enum condition {
    MESSAGE_VALIDATED,
    MESSAGE_NOT_SUPPORTED,
    CHECKOUT_DISABLED,
    CHECKIN_DISABLED,
    OFFLINE_NOT_SUPPORTED,
    PATRON_STATUS_UPDATE_NOT_SUPPORTED,
    RENEWALS_NOT_SUPPORTED,
    MISSING_MANDATORY_FIELDS, 
    INVALID_FIELD_LENGTH,
    UNKNOWN_MESSAGE 
  }
  
  
  private ACSStatus status;
  
  public MessageValidator(ACSStatus status) {
    this.status = status;
  }
  
  public condition isMessageValid(Message message) {
    condition cond = isMessageSupported(message.getClass());
    
    if (cond == condition.MESSAGE_VALIDATED) {
      try {
        String test = message.encode();
      } catch (MandatoryFieldOmitted ex) {
        return condition.MISSING_MANDATORY_FIELDS;
      } catch (InvalidFieldLength ex) {
        return condition.INVALID_FIELD_LENGTH;
      } catch (MessageNotUnderstood ex) {
        return condition.UNKNOWN_MESSAGE;
      }

      if (!status.isOfflineOk()) {
        if (message instanceof CheckIn) {
          if (((CheckIn)message).isNoBlock()) {
            return condition.OFFLINE_NOT_SUPPORTED;
          }
        }
        if (message instanceof CheckOut) {
          if (((CheckOut)message).isNoBlock()) {
            return condition.OFFLINE_NOT_SUPPORTED;
          }
        }
      }
      return cond;
    } else {
      return cond;
    }
  }
  
  public condition isMessageSupported(Class<? extends Message> clazz) {    
    switch (clazz.getName()) {
      case "ACSResend":
      case "SCResend":
        return status.getSupportedMessages().isRequestScAcsResend()?condition.MESSAGE_VALIDATED:condition.MESSAGE_NOT_SUPPORTED;
      case "ACSStatus":
      case "SCStatus":
        return status.getSupportedMessages().isScAcsStatus()?condition.MESSAGE_VALIDATED:condition.MESSAGE_NOT_SUPPORTED;
      case "BlockPatron":
        return status.getSupportedMessages().isBlockPatron()?status.isStatusUpdateOk()?condition.MESSAGE_VALIDATED:condition.PATRON_STATUS_UPDATE_NOT_SUPPORTED:condition.MESSAGE_NOT_SUPPORTED;
      case "CheckIn":
      case "CheckInResponse":
        return status.getSupportedMessages().isCheckIn()?status.isCheckInOk()?condition.MESSAGE_VALIDATED:condition.CHECKIN_DISABLED:condition.MESSAGE_NOT_SUPPORTED;
      case "CheckOut":
      case "CheckOutResponse":
        return status.getSupportedMessages().isCheckOut()?status.isCheckOutOk()?condition.MESSAGE_VALIDATED:condition.CHECKOUT_DISABLED:condition.MESSAGE_VALIDATED;
      case "EndPatronSession":
      case "EndSessionResponse":
        return status.getSupportedMessages().isEndPatronSession()?condition.MESSAGE_VALIDATED:condition.MESSAGE_NOT_SUPPORTED;
      case "FeePaid":
      case "FeePaidResponse":
        return status.getSupportedMessages().isFeePaid()?condition.MESSAGE_VALIDATED:condition.MESSAGE_NOT_SUPPORTED;
      case "Hold":
      case "HoldResponse":
        return status.getSupportedMessages().isHold()?condition.MESSAGE_VALIDATED:condition.MESSAGE_NOT_SUPPORTED;
      case "ItemInformation":
      case "ItemInformationResponse":
        return status.getSupportedMessages().isItemInformation()?condition.MESSAGE_VALIDATED:condition.MESSAGE_NOT_SUPPORTED;
      case "ItemStatusUpdate":
      case "ItemStatusUpdateResponse":
        return status.getSupportedMessages().isItemStatusUpdate()?condition.MESSAGE_VALIDATED:condition.MESSAGE_NOT_SUPPORTED;
      case "Login":
      case "LoginResponse":
        return status.getSupportedMessages().isLogin()?condition.MESSAGE_VALIDATED:condition.MESSAGE_NOT_SUPPORTED;
      case "PatronEnable":
      case "PatronEnableResponse":
        return status.getSupportedMessages().isPatronEnable()?condition.MESSAGE_VALIDATED:condition.MESSAGE_NOT_SUPPORTED;
      case "PatronInformation":
      case "PatronInformationResponse":
        return status.getSupportedMessages().isPatronInformation()?status.isStatusUpdateOk()?condition.MESSAGE_VALIDATED:condition.PATRON_STATUS_UPDATE_NOT_SUPPORTED:condition.MESSAGE_NOT_SUPPORTED;
      case "PatronStatusRequest":
        return status.getSupportedMessages().isPatronStatusRequest()?condition.MESSAGE_VALIDATED:condition.MESSAGE_NOT_SUPPORTED;
      case "PatronStatusResponse":
        return status.getSupportedMessages().isBlockPatron() || status.getSupportedMessages().isPatronStatusRequest()?condition.MESSAGE_VALIDATED:condition.MESSAGE_NOT_SUPPORTED;
      case "Renew":
      case "RenewResponse":
        return status.getSupportedMessages().isRenew() && status.isCheckOutOk()?condition.MESSAGE_VALIDATED:condition.MESSAGE_NOT_SUPPORTED;
      case "RenewAll":
      case "RenewAllResponse":
        return status.getSupportedMessages().isRenewAll() && status.isCheckOutOk()?condition.MESSAGE_VALIDATED:condition.MESSAGE_NOT_SUPPORTED;
    }
    return condition.UNKNOWN_MESSAGE;
  }
  
  
 
  
}

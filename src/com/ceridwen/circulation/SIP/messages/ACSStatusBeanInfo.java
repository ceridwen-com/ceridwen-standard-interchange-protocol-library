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
/**
 * <p>Title: Self Issue</p>
 * <p>Description: Self Issue Client</p>
 * <p>Copyright: 2004,</p>
 * <p>Company: ceridwen.com</p>
 * @author Matthew J. Dovey
 * @version 2.1
 */

package com.ceridwen.circulation.SIP.messages;

import java.beans.*;

import com.ceridwen.circulation.SIP.types.descriptors.PositionedFieldDescriptor;

public class ACSStatusBeanInfo extends MessageBeanInfo {
  Class<ACSStatus> beanClass = ACSStatus.class;

  public ACSStatusBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptorsInternal()  throws IntrospectionException {
      PropertyDescriptor _checkInOk = new PropertyDescriptor("checkInOk", beanClass, "isCheckInOk", "setCheckInOk");
      PropertyDescriptor _checkOutOk = new PropertyDescriptor("checkOutOk", beanClass, "isCheckOutOk", "setCheckOutOk");
      PropertyDescriptor _dateTimeSync = new PropertyDescriptor("dateTimeSync", beanClass, "getDateTimeSync", "setDateTimeSync");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _libraryName = new PropertyDescriptor("libraryName", beanClass, "getLibraryName", "setLibraryName");
      PropertyDescriptor _offlineOk = new PropertyDescriptor("offlineOk", beanClass, "isOfflineOk", "setOfflineOk");
      PropertyDescriptor _onLineStatus = new PropertyDescriptor("onlineStatus", beanClass, "isOnlineStatus", "setOnlineStatus");
      PropertyDescriptor _printLine = new PropertyDescriptor("printLine", beanClass, "getPrintLine", "setPrintLine");
      PropertyDescriptor _protocolVersion = new PropertyDescriptor("protocolVersion", beanClass, "getProtocolVersion", "setProtocolVersion");
      PropertyDescriptor _renewalPolicy = new PropertyDescriptor("ACSRenewalPolicy", beanClass, "isACSRenewalPolicy", "setACSRenewalPolicy");
      PropertyDescriptor _retriesAllowed = new PropertyDescriptor("retriesAllowed", beanClass, "getRetriesAllowed", "setRetriesAllowed");
      PropertyDescriptor _screenMessage = new PropertyDescriptor("screenMessage", beanClass, "getScreenMessage", "setScreenMessage");
      PropertyDescriptor _statusUpdateOk = new PropertyDescriptor("statusUpdateOk", beanClass, "isStatusUpdateOk", "setStatusUpdateOk");
      PropertyDescriptor _supportedMessages = new PropertyDescriptor("supportedMessages", beanClass, "getSupportedMessages", "setSupportedMessages");
      PropertyDescriptor _terminalLocation = new PropertyDescriptor("terminalLocation", beanClass, "getTerminalLocation", "setTerminalLocation");
      PropertyDescriptor _timeoutPeriod = new PropertyDescriptor("timeoutPeriod", beanClass, "getTimeoutPeriod", "setTimeoutPeriod");

      _onLineStatus.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2,2));
      _checkInOk.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(3,3));
      _checkOutOk.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(4,4));
      _renewalPolicy.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(5,5));
      _statusUpdateOk.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(6,6));
      _offlineOk.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(7,7));
      _timeoutPeriod.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(8,10));
      _retriesAllowed.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(11,13));
      _dateTimeSync.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(14,31));
      _protocolVersion.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(32,35));

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _checkInOk,
        _checkOutOk,
        _dateTimeSync,
        _institutionId,
        _libraryName,
        _offlineOk,
        _onLineStatus,
        _printLine,
        _protocolVersion,
        _renewalPolicy,
        _retriesAllowed,
        _screenMessage,
        _statusUpdateOk,
        _supportedMessages,
        _terminalLocation,
        _timeoutPeriod};
      return pds;
  }
}

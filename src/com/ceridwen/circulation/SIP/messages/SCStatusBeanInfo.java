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
package com.ceridwen.circulation.SIP.messages;

import java.beans.*;

import com.ceridwen.circulation.SIP.types.descriptors.PositionedFieldDescriptor;


/**
 * <p>Title: RTSI</p>
 * <p>Description: Real Time Self Issue</p>
 * <p>Copyright: </p>

 * @author Matthew J. Dovey
 * @version 1.0
 */

public class SCStatusBeanInfo extends MessageBeanInfo {
  Class<SCStatus> beanClass = SCStatus.class;
  public SCStatusBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
      PropertyDescriptor _maxPrintWidth = new PropertyDescriptor("maxPrintWidth", beanClass, "getMaxPrintWidth", "setMaxPrintWidth");
      PropertyDescriptor _protocolVersion = new PropertyDescriptor("protocolVersion", beanClass, "getProtocolVersion", "setProtocolVersion");
      PropertyDescriptor _statusCode = new PropertyDescriptor("statusCode", beanClass, "getStatusCode", "setStatusCode");

      _statusCode.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2,2));
      _maxPrintWidth.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(3,5));
      _protocolVersion.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(6,9));

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _maxPrintWidth,
        _protocolVersion,
        _statusCode};
      return pds;
  }
}

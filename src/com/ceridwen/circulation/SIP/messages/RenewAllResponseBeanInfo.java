/*******************************************************************************
 * Copyright (c) 2010 Matthew J. Dovey.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * <http://www.gnu.org/licenses/>.
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
 *     Matthew J. Dovey - initial API and implementation
 ******************************************************************************/
package com.ceridwen.circulation.SIP.messages;

import java.beans.*;

import com.ceridwen.circulation.SIP.types.descriptors.PositionedFieldDescriptor;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class RenewAllResponseBeanInfo extends MessageBeanInfo {
  Class<RenewAllResponse> beanClass = RenewAllResponse.class;
  public RenewAllResponseBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
      PropertyDescriptor _ok = new PropertyDescriptor("ok", beanClass, "getOk", "setOk");
      PropertyDescriptor _renewedCount = new PropertyDescriptor("renewedCount", beanClass, "getRenewedCount", "setRenewedCount");
      PropertyDescriptor _unrenewedCount = new PropertyDescriptor("unrenewedCount", beanClass, "getUnrenewedCount", "setUnrenewedCount");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _screenMessage = new PropertyDescriptor("screenMessage", beanClass, "getScreenMessage", "setScreenMessage");
      PropertyDescriptor _printLine = new PropertyDescriptor("printLine", beanClass, "getPrintLine", "setPrintLine");

      _ok.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2,2));
      _renewedCount.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(3,6));
      _unrenewedCount.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(7,10));
      _transactionDate.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(11,28));

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _ok,
        _renewedCount,
        _unrenewedCount,
        _transactionDate,
        _institutionId,
        _screenMessage,
        _printLine};
      return pds;
  }
}

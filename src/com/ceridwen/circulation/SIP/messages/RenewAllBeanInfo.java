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
import com.ceridwen.circulation.SIP.types.descriptors.TaggedFieldDescriptor;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class RenewAllBeanInfo extends MessageBeanInfo {
  Class<RenewAll> beanClass = RenewAll.class;
  public RenewAllBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", beanClass, "getPatronIdentifier", "setPatronIdentifier");
      PropertyDescriptor _patronPassword = new PropertyDescriptor("patronPassword", beanClass, "getPatronPassword", "setPatronPassword");
      PropertyDescriptor _terminalPassword = new PropertyDescriptor("terminalPassword", beanClass, "getTerminalPassword", "setTerminalPassword");
      PropertyDescriptor _feeAcknowledged = new PropertyDescriptor("feeAcknowledged", beanClass, "getFeeAcknowledged", "setFeeAcknowledged");

      _transactionDate.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2,19));

      _terminalPassword.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));      

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _transactionDate,
        _institutionId,
        _patronIdentifier,
        _patronPassword,
        _terminalPassword,
        _feeAcknowledged};
      return pds;
  }
}

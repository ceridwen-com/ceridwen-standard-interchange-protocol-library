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
import com.ceridwen.circulation.SIP.types.descriptors.TaggedFieldDescriptor;

public class CheckOutBeanInfo extends MessageBeanInfo {
  Class<CheckOut> beanClass = CheckOut.class;
  public CheckOutBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
      PropertyDescriptor _cancel = new PropertyDescriptor("cancel", beanClass, "getCancel", "setCancel");
      PropertyDescriptor _feeAcknowledged = new PropertyDescriptor("feeAcknowledged", beanClass, "getFeeAcknowledged", "setFeeAcknowledged");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _itemIdentifier = new PropertyDescriptor("itemIdentifier", beanClass, "getItemIdentifier", "setItemIdentifier");
      PropertyDescriptor _itemProperties = new PropertyDescriptor("itemProperties", beanClass, "getItemProperties", "setItemProperties");
      PropertyDescriptor _nbDueDate = new PropertyDescriptor("nbDueDate", beanClass, "getNbDueDate", "setNbDueDate");
      PropertyDescriptor _noBlock = new PropertyDescriptor("noBlock", beanClass, "getNoBlock", "setNoBlock");
      PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", beanClass, "getPatronIdentifier", "setPatronIdentifier");
      PropertyDescriptor _patronPassword = new PropertyDescriptor("patronPassword", beanClass, "getPatronPassword", "setPatronPassword");
      PropertyDescriptor _renewalPolicy = new PropertyDescriptor("renewalPolicy", beanClass, "getRenewalPolicy", "setRenewalPolicy");
      PropertyDescriptor _terminalPassword = new PropertyDescriptor("terminalPassword", beanClass, "getTerminalPassword", "setTerminalPassword");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");

      _renewalPolicy.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2,2));
      _noBlock.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(3,3));
      _transactionDate.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(4,21));
      _nbDueDate.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(22,39));
      
      _terminalPassword.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(true));

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _cancel,
        _feeAcknowledged,
        _institutionId,
        _itemIdentifier,
        _itemProperties,
        _nbDueDate,
        _noBlock,
        _patronIdentifier,
        _patronPassword,
        _renewalPolicy,
        _terminalPassword,
        _transactionDate};
      return pds;
  }
}
  

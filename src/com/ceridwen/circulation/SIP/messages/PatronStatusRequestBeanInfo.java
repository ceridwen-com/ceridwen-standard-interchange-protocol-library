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
import com.ceridwen.circulation.SIP.types.descriptors.TaggedFieldDescriptor;

/**
 * <p>Title: RTSI</p>
 * <p>Description: Real Time Self Issue</p>
 * <p>Copyright: </p>

 * @author Matthew J. Dovey
 * @version 1.0
 */

public class PatronStatusRequestBeanInfo extends MessageBeanInfo {
  Class<PatronStatusRequest> beanClass = PatronStatusRequest.class;
  public PatronStatusRequestBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _language = new PropertyDescriptor("language", beanClass, "getLanguage", "setLanguage");
      PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", beanClass, "getPatronIdentifier", "setPatronIdentifier");
      PropertyDescriptor _patronPassword = new PropertyDescriptor("patronPassword", beanClass, "getPatronPassword", "setPatronPassword");
      PropertyDescriptor _terminalPassword = new PropertyDescriptor("terminalPassword", beanClass, "getTerminalPassword", "setTerminalPassword");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");

      _language.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2,4));
      _transactionDate.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(5,22));
      
      _patronIdentifier.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(true));            
      _patronPassword.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(true));
      _terminalPassword.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(true));      
      
      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _institutionId,
        _language,
        _patronIdentifier,
        _patronPassword,
        _terminalPassword,
        _transactionDate};
      return pds;
  }
}

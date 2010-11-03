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

public class PatronStatusResponseBeanInfo extends MessageBeanInfo {
  Class<PatronStatusResponse> beanClass = PatronStatusResponse.class;
  public PatronStatusResponseBeanInfo() {
  }

  public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
      PropertyDescriptor _currencyType = new PropertyDescriptor("currencyType", beanClass, "getCurrencyType", "setCurrencyType");
      PropertyDescriptor _feeAmount = new PropertyDescriptor("feeAmount", beanClass, "getFeeAmount", "setFeeAmount");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _language = new PropertyDescriptor("language", beanClass, "getLanguage", "setLanguage");
      PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", beanClass, "getPatronIdentifier", "setPatronIdentifier");
      PropertyDescriptor _patronStatus = new PropertyDescriptor("patronStatus", beanClass, "getPatronStatus", "setPatronStatus");
      PropertyDescriptor _personalName = new PropertyDescriptor("personalName", beanClass, "getPersonalName", "setPersonalName");
      PropertyDescriptor _printLine = new PropertyDescriptor("printLine", beanClass, "getPrintLine", "setPrintLine");
      PropertyDescriptor _screenMessage = new PropertyDescriptor("screenMessage", beanClass, "getScreenMessage", "setScreenMessage");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");
      PropertyDescriptor _validPatron = new PropertyDescriptor("validPatron", beanClass, "getValidPatron", "setValidPatron");
      PropertyDescriptor _validPatronPassword = new PropertyDescriptor("validPatronPassword", beanClass, "getValidPatronPassword", "setValidPatronPassword");

      _patronStatus.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2, 15));
      _language.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(16,18));
      _transactionDate.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(19,36));
      
      _currencyType.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
      _feeAmount.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(false));
      _patronIdentifier.setValue("SIPFieldDescriptor", new TaggedFieldDescriptor(true));


      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _currencyType,
        _feeAmount,
        _institutionId,
        _language,
        _patronIdentifier,
        _patronStatus,
        _personalName,
        _printLine,
        _screenMessage,
        _transactionDate,
        _validPatron,
        _validPatronPassword};
      return pds;
  }
}

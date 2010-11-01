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

public class CheckInResponseBeanInfo extends MessageBeanInfo {
  Class<CheckInResponse> beanClass = CheckInResponse.class;

  public CheckInResponseBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
      PropertyDescriptor _alert = new PropertyDescriptor("alert", beanClass, "getAlert", "setAlert");
      PropertyDescriptor _institutionId = new PropertyDescriptor("institutionId", beanClass, "getInstitutionId", "setInstitutionId");
      PropertyDescriptor _itemIdentifier = new PropertyDescriptor("itemIdentifier", beanClass, "getItemIdentifier", "setItemIdentifier");
      PropertyDescriptor _itemProperties = new PropertyDescriptor("itemProperties", beanClass, "getItemProperties", "setItemProperties");
      PropertyDescriptor _magneticMedia = new PropertyDescriptor("magneticMedia", beanClass, "getMagneticMedia", "setMagneticMedia");
      PropertyDescriptor _mediaType = new PropertyDescriptor("mediaType", beanClass, "getMediaType", "setMediaType");
      PropertyDescriptor _ok = new PropertyDescriptor("ok", beanClass, "getOk", "setOk");
      PropertyDescriptor _patronIdentifier = new PropertyDescriptor("patronIdentifier", beanClass, "getPatronIdentifier", "setPatronIdentifier");
      PropertyDescriptor _permanentLocation = new PropertyDescriptor("permanentLocation", beanClass, "getPermanentLocation", "setPermanentLocation");
      PropertyDescriptor _printLine = new PropertyDescriptor("printLine", beanClass, "getPrintLine", "setPrintLine");
      PropertyDescriptor _resensitize = new PropertyDescriptor("resensitize", beanClass, "getResensitize", "setResensitize");
      PropertyDescriptor _screenMessage = new PropertyDescriptor("screenMessage", beanClass, "getScreenMessage", "setScreenMessage");
      PropertyDescriptor _sortBin = new PropertyDescriptor("sortBin", beanClass, "getSortBin", "setSortBin");
      PropertyDescriptor _titleIdentifier = new PropertyDescriptor("titleIdentifier", beanClass, "getTitleIdentifier", "setTitleIdentifier");
      PropertyDescriptor _transactionDate = new PropertyDescriptor("transactionDate", beanClass, "getTransactionDate", "setTransactionDate");

      _ok.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2,2));
      _resensitize.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(3,3));
      _magneticMedia.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(4,4));
      _alert.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(5,5));
      _transactionDate.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(6,23));

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _alert,
        _institutionId,
        _itemIdentifier,
        _itemProperties,
        _magneticMedia,
        _mediaType,
        _ok,
        _patronIdentifier,
        _permanentLocation,
        _printLine,
        _resensitize,
        _screenMessage,
        _sortBin,
        _titleIdentifier,
        _transactionDate};
      return pds;
  }
}

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
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2003</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */

public class LoginBeanInfo extends MessageBeanInfo {
  Class<Login> beanClass = Login.class;
  public LoginBeanInfo() {
  }
  public PropertyDescriptor[] getPropertyDescriptorsInternal() throws IntrospectionException {
      PropertyDescriptor _UIDAlgorithm = new PropertyDescriptor("UIDAlgorithm", beanClass, "getUIDAlgorithm", "setUIDAlgorithm");
      PropertyDescriptor _PWDAlgorithm = new PropertyDescriptor("PWDAlgorithm", beanClass, "getPWDAlgorithm", "setPWDAlgorithm");
      PropertyDescriptor _loginUserId = new PropertyDescriptor("loginUserId", beanClass, "getLoginUserId", "setLoginUserId");
      PropertyDescriptor _loginPassword = new PropertyDescriptor("loginPassword", beanClass, "getLoginPassword", "setLoginPassword");
      PropertyDescriptor _locationCode = new PropertyDescriptor("locationCode", beanClass, "getLocationCode", "setLocationCode");

      _UIDAlgorithm.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(2,2));
      _PWDAlgorithm.setValue("SIPFieldDescriptor", new PositionedFieldDescriptor(3,3));

      PropertyDescriptor[] pds = new PropertyDescriptor[] {
        _UIDAlgorithm,
        _PWDAlgorithm,
        _loginUserId,
        _loginPassword,
        _locationCode};
      return pds;
  }
}

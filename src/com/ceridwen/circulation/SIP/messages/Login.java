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

public class Login extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = -5732581787865741081L;
private String UIDAlgorithm;
  private String PWDAlgorithm;
  private String loginUserId;
  private String loginPassword;
  private String locationCode;
  public String getCommand() {
    return "93";
  }
  public String getUIDAlgorithm() {
    return UIDAlgorithm;
  }
  public void setUIDAlgorithm(String UIDAlgorithm) {
    this.UIDAlgorithm = UIDAlgorithm;
  }
  public String getPWDAlgorithm() {
    return PWDAlgorithm;
  }
  public void setPWDAlgorithm(String PWDAlgorithm) {
    this.PWDAlgorithm = PWDAlgorithm;
  }
  public String getLoginUserId() {
    return loginUserId;
  }
  public void setLoginUserId(String loginUserId) {
    this.loginUserId = loginUserId;
  }
  public String getLoginPassword() {
    return loginPassword;
  }
  public void setLoginPassword(String loginPassword) {
    this.loginPassword = loginPassword;
  }
  public String getLocationCode() {
    return locationCode;
  }
  public void setLocationCode(String locationCode) {
    this.locationCode = locationCode;
  }


}

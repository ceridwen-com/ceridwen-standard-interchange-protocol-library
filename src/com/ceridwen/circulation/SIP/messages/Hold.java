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

import com.ceridwen.circulation.SIP.types.enumerations.HoldMode;
import com.ceridwen.circulation.SIP.types.enumerations.HoldType;

public class Hold extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = -6526613321625525740L;
private HoldMode holdMode = HoldMode.CHANGE;
  private java.util.Date transactionDate = new java.util.Date();
  private java.util.Date expirationDate;
  private String pickupLocation;
  private HoldType holdType = HoldType.OTHER;
  private String institutionId;
  private String patronIdentifier;
  private String patronPassword;
  private String itemIdentifier;
  private String titleIdentifier;
  private String terminalPassword;
  private Boolean feeAcknowledged;
  public String getCommand() {
    return "15";
  }
  public HoldMode getHoldMode() {
    return holdMode;
  }
  public void setHoldMode(HoldMode holdMode) {
    this.holdMode = holdMode;
  }
  public java.util.Date getTransactionDate() {
    return transactionDate;
  }
  public void setTransactionDate(java.util.Date transactionDate) {
    this.transactionDate = transactionDate;
  }
  public java.util.Date getExpirationDate() {
    return expirationDate;
  }
  public void setExpirationDate(java.util.Date expirationDate) {
    this.expirationDate = expirationDate;
  }
  public String getPickupLocation() {
    return pickupLocation;
  }
  public void setPickupLocation(String pickupLocation) {
    this.pickupLocation = pickupLocation;
  }
  public HoldType getHoldType() {
    return holdType;
  }
  public void setHoldType(HoldType holdType) {
    this.holdType = holdType;
  }
  public String getInstitutionId() {
    return institutionId;
  }
  public void setInstitutionId(String institutionId) {
    this.institutionId = institutionId;
  }
  public String getPatronIdentifier() {
    return patronIdentifier;
  }
  public void setPatronIdentifier(String patronIdentifier) {
    this.patronIdentifier = patronIdentifier;
  }
  public String getPatronPassword() {
    return patronPassword;
  }
  public void setPatronPassword(String patronPassword) {
    this.patronPassword = patronPassword;
  }
  public String getItemIdentifier() {
    return itemIdentifier;
  }
  public void setItemIdentifier(String itemIdentifier) {
    this.itemIdentifier = itemIdentifier;
  }
  public String getTitleIdentifier() {
    return titleIdentifier;
  }
  public void setTitleIdentifier(String titleIdentifier) {
    this.titleIdentifier = titleIdentifier;
  }
  public String getTerminalPassword() {
    return terminalPassword;
  }
  public void setTerminalPassword(String terminalPassword) {
    this.terminalPassword = terminalPassword;
  }
  public Boolean getFeeAcknowledged() {
    return feeAcknowledged;
  }
  public void setFeeAcknowledged(Boolean feeAcknowledged) {
    this.feeAcknowledged = feeAcknowledged;
  }
}

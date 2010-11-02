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

public class HoldResponse extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = 2267131763722749419L;
	private Boolean ok;
	private Boolean available;
	private java.util.Date transactionDate;
	private java.util.Date expirationDate;
	private Integer queuePosition;
	private String pickupLocation;
	private String institutionId;
	private String patronIdentifier;
	private String itemIdentifier;
	private String titleIdentifier;
	private String screenMessage;
	private String printLine;
	
  public String getCommand() {
    return "16";
  }
  public Boolean getOk() {
    return ok;
  }
  public void setOk(Boolean ok) {
    this.ok = ok;
  }
  public Boolean getAvailable() {
    return available;
  }
  public void setAvailable(Boolean available) {
    this.available = available;
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
  public Integer getQueuePosition() {
    return queuePosition;
  }
  public void setQueuePosition(Integer queuePosition) {
    this.queuePosition = queuePosition;
  }
  public String getPickupLocation() {
    return pickupLocation;
  }
  public void setPickupLocation(String pickupLocation) {
    this.pickupLocation = pickupLocation;
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
  public String getScreenMessage() {
    return screenMessage;
  }
  public void setScreenMessage(String screenMessage) {
    this.screenMessage = screenMessage;
  }
  public String getPrintLine() {
    return printLine;
  }
  public void setPrintLine(String printLine) {
    this.printLine = printLine;
  }
}

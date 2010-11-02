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

import java.util.Date;

public class CheckIn extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = -7321140594135175919L;
	private Boolean noBlock;
	private Date transactionDate;
	private Date returnDate;
	private String currentLocation;
	private String institutionId;
	private String itemIdentifier;
	private String terminalPassword;
	private String itemProperties;
	private Boolean cancel;

  public String getCommand() {
    return "09";
  }
  public Boolean getCancel() {
    return cancel;
  }
  public String getCurrentLocation() {
    return currentLocation;
  }
  public String getInstitutionId() {
    return institutionId;
  }
  public String getItemIdentifier() {
    return itemIdentifier;
  }
  public String getItemProperties() {
    return itemProperties;
  }
  public Boolean getNoBlock() {
    return noBlock;
  }
  public Date getReturnDate() {
    return returnDate;
  }
  public String getTerminalPassword() {
    return terminalPassword;
  }
  public Date getTransactionDate() {
    return transactionDate;
  }
  public void setTransactionDate(Date transactionDate) {
    this.transactionDate = transactionDate;
  }
  public void setTerminalPassword(String terminalPassword) {
    this.terminalPassword = terminalPassword;
  }
  public void setReturnDate(Date returnDate) {
    this.returnDate = returnDate;
  }
  public void setNoBlock(Boolean noBlock) {
    this.noBlock = noBlock;
  }
  public void setItemProperties(String itemProperties) {
    this.itemProperties = itemProperties;
  }
  public void setItemIdentifier(String itemIdentifier) {
    this.itemIdentifier = itemIdentifier;
  }
  public void setInstitutionId(String institutionId) {
    this.institutionId = institutionId;
  }
  public void setCurrentLocation(String currentLocation) {
    this.currentLocation = currentLocation;
  }
  public void setCancel(Boolean cancel) {
    this.cancel = cancel;
  }
}

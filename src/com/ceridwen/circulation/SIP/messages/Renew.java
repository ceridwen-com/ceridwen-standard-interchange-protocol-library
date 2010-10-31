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

public class Renew extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = 158409818027250051L;
private Boolean thirdPartyAllowed;
  private Boolean noBlock;
  private java.util.Date transactionDate = new java.util.Date();
  private java.util.Date noBlockDueDate;
  private String institutionId;
  private String patronIdentifier;
  private String patronPassword;
  private String itemIdentifier;
  private String titleIdentifier;
  private String terminalPassword;
  private String itemProperties;
  private Boolean feeAcknowledged;
  public String getCommand() {
    return "29";
  }
  public Boolean getThirdPartyAllowed() {
    return thirdPartyAllowed;
  }
  public void setThirdPartyAllowed(Boolean thirdPartyAllowed) {
    this.thirdPartyAllowed = thirdPartyAllowed;
  }
  public Boolean getNoBlock() {
    return noBlock;
  }
  public void setNoBlock(Boolean noBlock) {
    this.noBlock = noBlock;
  }
  public java.util.Date getTransactionDate() {
    return transactionDate;
  }
  public void setTransactionDate(java.util.Date transactionDate) {
    this.transactionDate = transactionDate;
  }
  public java.util.Date getNoBlockDueDate() {
    return noBlockDueDate;
  }
  public void setNoBlockDueDate(java.util.Date noBlockDueDate) {
    this.noBlockDueDate = noBlockDueDate;
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
  public String getItemProperties() {
    return itemProperties;
  }
  public void setItemProperties(String itemProperties) {
    this.itemProperties = itemProperties;
  }
  public Boolean getFeeAcknowledged() {
    return feeAcknowledged;
  }
  public void setFeeAcknowledged(Boolean feeAcknowledged) {
    this.feeAcknowledged = feeAcknowledged;
  }
}

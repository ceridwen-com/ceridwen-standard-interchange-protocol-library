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

public class ItemStatusUpdate extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = -2127793191374183987L;
	private java.util.Date transactionDate;
	private String institutionId;
	private String itemIdentifier;
	private String terminalPassword;
	private String itemProperties;
	
  public String getCommand() {
    return "19";
  }
  public java.util.Date getTransactionDate() {
    return transactionDate;
  }
  public void setTransactionDate(java.util.Date transactionDate) {
    this.transactionDate = transactionDate;
  }
  public String getInstitutionId() {
    return institutionId;
  }
  public void setInstitutionId(String institutionId) {
    this.institutionId = institutionId;
  }
  public String getItemIdentifier() {
    return itemIdentifier;
  }
  public void setItemIdentifier(String itemIdentifier) {
    this.itemIdentifier = itemIdentifier;
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
}

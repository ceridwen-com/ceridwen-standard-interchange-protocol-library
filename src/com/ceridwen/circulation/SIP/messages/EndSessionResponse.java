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

public class EndSessionResponse extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = 8955079727656656773L;
private Boolean endSession;
  private String institutionId;
  private String patronIdentifier;
  private String screenMessage;
  private String printLine;
  private java.util.Date transactionDate = new java.util.Date();
  public String getCommand() {
    return "36";
  }
  public Boolean getEndSession() {
    return endSession;
  }
  public void setEndSession(Boolean endSession) {
    this.endSession = endSession;
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
  public String getPatronIdentifier() {
    return patronIdentifier;
  }
  public void setPatronIdentifier(String patronIdentifier) {
    this.patronIdentifier = patronIdentifier;
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

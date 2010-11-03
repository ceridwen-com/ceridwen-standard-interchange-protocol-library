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

import java.util.Date;

import com.ceridwen.circulation.SIP.types.enumerations.Language;

/**
 * <p>Title: RTSI</p>
 * <p>Description: Real Time Self Issue</p>
 * <p>Copyright: </p>

 * @author Matthew J. Dovey
 * @version 1.0
 */

public class PatronStatusRequest extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = -4867507215519281871L;
	private Language language;
	private Date transactionDate;
	private String institutionId;
	private String patronIdentifier;
	private String terminalPassword;
	private String patronPassword;

  public String getCommand() {
    return "23";
  }
  public String getInstitutionId() {
    return institutionId;
  }
  public Language getLanguage() {
    return language;
  }
  public String getPatronIdentifier() {
    return patronIdentifier;
  }
  public String getPatronPassword() {
    return patronPassword;
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
  public void setPatronPassword(String patronPassword) {
    this.patronPassword = patronPassword;
  }
  public void setPatronIdentifier(String patronIdentifier) {
    this.patronIdentifier = patronIdentifier;
  }
  public void setLanguage(Language language) {
    this.language = language;
  }
  public void setInstitutionId(String institutionId) {
    this.institutionId = institutionId;
  }
}

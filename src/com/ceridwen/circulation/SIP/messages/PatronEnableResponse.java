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

import com.ceridwen.circulation.SIP.types.enumerations.Language;
import com.ceridwen.circulation.SIP.types.flagfields.PatronStatus;

public class PatronEnableResponse extends Message {
    /**
	 * 
	 */
    private static final long serialVersionUID = 5941325479001778479L;
    private PatronStatus patronStatus = new PatronStatus();
    private Language language;
    private java.util.Date transactionDate;
    private String institutionId;
    private String patronIdentifier;
    private String personalName;
    private Boolean validPatronPassword;
    private String screenMessage;
    private String printLine;
    private Boolean validPatron;

    @Override
    public String getCommand() {
        return "26";
    }

    public PatronStatus getPatronStatus() {
        return this.patronStatus;
    }

    /**
     * Use getPatronStatus().set(PatronStatus.FIELD)
     * getPatronStatus().unset(PatronStatus.FIELD) getPatronStatus().unsetAll()
     * 
     * @param summary
     */
    @Deprecated
    public void setPatronStatus(PatronStatus patronStatus) {
        this.patronStatus = patronStatus;
    }

    public Language getLanguage() {
        return this.language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public java.util.Date getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(java.util.Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getInstitutionId() {
        return this.institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getPatronIdentifier() {
        return this.patronIdentifier;
    }

    public void setPatronIdentifier(String patronIdentifier) {
        this.patronIdentifier = patronIdentifier;
    }

    public String getPersonalName() {
        return this.personalName;
    }

    public void setPersonalName(String personalName) {
        this.personalName = personalName;
    }

    public Boolean isValidPatron() {
        return this.validPatron;
    }

    public void setValidPatron(Boolean validPatron) {
        this.validPatron = validPatron;
    }

    public Boolean isValidPatronPassword() {
        return this.validPatronPassword;
    }

    public void setValidPatronPassword(Boolean validPatronPassword) {
        this.validPatronPassword = validPatronPassword;
    }

    public String getScreenMessage() {
        return this.screenMessage;
    }

    public void setScreenMessage(String screenMessage) {
        this.screenMessage = screenMessage;
    }

    public String getPrintLine() {
        return this.printLine;
    }

    public void setPrintLine(String printLine) {
        this.printLine = printLine;
    }
}

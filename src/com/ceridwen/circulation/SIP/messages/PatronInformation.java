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

import com.ceridwen.circulation.SIP.annotations.Command;
import com.ceridwen.circulation.SIP.annotations.PositionedField;
import com.ceridwen.circulation.SIP.annotations.TaggedField;
import com.ceridwen.circulation.SIP.annotations.TestCaseDefault;
import com.ceridwen.circulation.SIP.annotations.TestCasePopulated;
import com.ceridwen.circulation.SIP.fields.FieldPolicy;
import com.ceridwen.circulation.SIP.types.enumerations.Language;
import com.ceridwen.circulation.SIP.types.flagfields.Summary;

@Command("63")
@TestCaseDefault("6300019700101    010000          AA|AO|")
@TestCasePopulated("6302719700101    010000      Y   AApatronIdentifier|ACterminalPassword|ADpatronPassword|AOinstitutionId|BP123456789|BQ123456789|")
public class PatronInformation extends Message {
    /**
	 * 
	 */
    private static final long serialVersionUID = 4603960140773936894L;
    @PositionedField(start = 2, end = 4)
    private Language language;
    @PositionedField(start = 5, end = 22)
    private Date transactionDate;
    @PositionedField(start = 23, end = 32)
    private Summary summary = new Summary();
    @TaggedField
    private String institutionId;
    @TaggedField(FieldPolicy.REQUIRED)
    private String patronIdentifier;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String terminalPassword;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String patronPassword;
    @TaggedField
    private Integer startItem;
    @TaggedField
    private Integer endItem;

    public Integer getEndItem() {
        return this.endItem;
    }

    public String getInstitutionId() {
        return this.institutionId;
    }

    public Language getLanguage() {
        return this.language;
    }

    public String getPatronIdentifier() {
        return this.patronIdentifier;
    }

    public String getPatronPassword() {
        return this.patronPassword;
    }

    public Integer getStartItem() {
        return this.startItem;
    }

    public Summary getSummary() {
        return this.summary;
    }

    public String getTerminalPassword() {
        return this.terminalPassword;
    }

    public Date getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTerminalPassword(String terminalPassword) {
        this.terminalPassword = terminalPassword;
    }

    /**
     * Use getSummary().set(Summary.FIELD) getSummary().unset(Summary.FIELD)
     * getSummary().unsetAll()
     * 
     * @param summary
     */
    @Deprecated
    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public void setStartItem(Integer startItem) {
        this.startItem = startItem;
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

    public void setEndItem(Integer endItem) {
        this.endItem = endItem;
    }
}

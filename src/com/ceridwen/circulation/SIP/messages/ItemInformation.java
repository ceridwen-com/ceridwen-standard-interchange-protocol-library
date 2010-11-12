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

@Command("17")
@TestCaseDefault("1719700101    010000AB|AO|")
@TestCasePopulated("1719700101    010000ABitemIdentifier|ACterminalPassword|AOinstitutionId|")
public class ItemInformation extends Message {
    private static final long serialVersionUID = 7398126890693645623L;
    @PositionedField(start = 2, end = 19)
    private Date transactionDate;
    @TaggedField
    private String institutionId;
    @TaggedField(FieldPolicy.REQUIRED)
    private String itemIdentifier;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String terminalPassword;

    public String getInstitutionId() {
        return this.institutionId;
    }

    public String getItemIdentifier() {
        return this.itemIdentifier;
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

    public void setItemIdentifier(String itemIdentifier) {
        this.itemIdentifier = itemIdentifier;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }
}

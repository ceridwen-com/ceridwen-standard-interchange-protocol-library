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

import com.ceridwen.circulation.SIP.annotations.Command;
import com.ceridwen.circulation.SIP.annotations.PositionedField;
import com.ceridwen.circulation.SIP.annotations.TaggedField;
import com.ceridwen.circulation.SIP.annotations.TestCaseDefault;
import com.ceridwen.circulation.SIP.annotations.TestCasePopulated;
import com.ceridwen.circulation.SIP.fields.FieldPolicy;
import com.ceridwen.circulation.SIP.types.enumerations.HoldMode;
import com.ceridwen.circulation.SIP.types.enumerations.HoldType;

@Command("15")
@TestCaseDefault("15*19700101    010000AA|AO|")
@TestCasePopulated("15-19700101    010000AApatronIdentifier|ABitemIdentifier|ACterminalPassword|ADpatronPassword|AJtitleIdentifier|AOinstitutionId|BOY|BSpickupLocation|BW19700101    010000|BY4|")
public class Hold extends Message {
    private static final long serialVersionUID = -6526613321625525740L;
    @PositionedField(start = 2, end = 2)
    private HoldMode holdMode;
    @PositionedField(start = 3, end = 20)
    private java.util.Date transactionDate;
    @TaggedField
    private java.util.Date expirationDate;
    @TaggedField
    private String pickupLocation;
    @TaggedField
    private HoldType holdType;
    @TaggedField
    private String institutionId;
    @TaggedField(FieldPolicy.REQUIRED)
    private String patronIdentifier;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String patronPassword;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String itemIdentifier;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String titleIdentifier;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String terminalPassword;
    @TaggedField
    private Boolean feeAcknowledged;

    public HoldMode getHoldMode() {
        return this.holdMode;
    }

    public void setHoldMode(HoldMode holdMode) {
        this.holdMode = holdMode;
    }

    public java.util.Date getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(java.util.Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public java.util.Date getExpirationDate() {
        return this.expirationDate;
    }

    public void setExpirationDate(java.util.Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getPickupLocation() {
        return this.pickupLocation;
    }

    public void setPickupLocation(String pickupLocation) {
        this.pickupLocation = pickupLocation;
    }

    public HoldType getHoldType() {
        return this.holdType;
    }

    public void setHoldType(HoldType holdType) {
        this.holdType = holdType;
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

    public String getPatronPassword() {
        return this.patronPassword;
    }

    public void setPatronPassword(String patronPassword) {
        this.patronPassword = patronPassword;
    }

    public String getItemIdentifier() {
        return this.itemIdentifier;
    }

    public void setItemIdentifier(String itemIdentifier) {
        this.itemIdentifier = itemIdentifier;
    }

    public String getTitleIdentifier() {
        return this.titleIdentifier;
    }

    public void setTitleIdentifier(String titleIdentifier) {
        this.titleIdentifier = titleIdentifier;
    }

    public String getTerminalPassword() {
        return this.terminalPassword;
    }

    public void setTerminalPassword(String terminalPassword) {
        this.terminalPassword = terminalPassword;
    }

    public Boolean isFeeAcknowledged() {
        return this.feeAcknowledged;
    }

    public void setFeeAcknowledged(Boolean feeAcknowledged) {
        this.feeAcknowledged = feeAcknowledged;
    }
}

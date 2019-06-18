/* 
 * Copyright (C) 2019 Ceridwen Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ceridwen.circulation.SIP.messages;

import com.ceridwen.circulation.SIP.annotations.Command;
import com.ceridwen.circulation.SIP.annotations.PositionedField;
import com.ceridwen.circulation.SIP.annotations.TaggedField;
import com.ceridwen.circulation.SIP.annotations.TestCaseDefault;
import com.ceridwen.circulation.SIP.annotations.TestCasePopulated;
import com.ceridwen.circulation.SIP.fields.FieldPolicy;

@Command("01")
@TestCaseDefault("01N19700101    010000AA|AC|AL|AO|")
@TestCasePopulated("01Y19700101    010000AApatronIdentifier|ACterminalPassword|ALblockedCardMessage|AOinstitutionId|")
public class BlockPatron extends Message {
    private static final long serialVersionUID = 7336173091305475737L;
    @PositionedField(start = 2, end = 2)
    private Boolean cardRetained;
    @PositionedField(start = 3, end = 20)
    private java.util.Date transactionDate;
    @TaggedField
    private String institutionId;
    @TaggedField
    private String blockedCardMessage;
    @TaggedField(FieldPolicy.REQUIRED)
    private String patronIdentifier;
    @TaggedField(FieldPolicy.REQUIRED)
    private String terminalPassword;

    public Boolean isCardRetained() {
        return this.cardRetained;
    }

    public void setCardRetained(Boolean cardRetained) {
        this.cardRetained = cardRetained;
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

    public String getBlockedCardMessage() {
        return this.blockedCardMessage;
    }

    public void setBlockedCardMessage(String blockedCardMessage) {
        this.blockedCardMessage = blockedCardMessage;
    }

    public String getPatronIdentifier() {
        return this.patronIdentifier;
    }

    public void setPatronIdentifier(String patronIdentifier) {
        this.patronIdentifier = patronIdentifier;
    }

    public String getTerminalPassword() {
        return this.terminalPassword;
    }

    public void setTerminalPassword(String terminalPassword) {
        this.terminalPassword = terminalPassword;
    }

}

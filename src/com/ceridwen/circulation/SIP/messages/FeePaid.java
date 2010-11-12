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
import com.ceridwen.circulation.SIP.types.enumerations.CurrencyType;
import com.ceridwen.circulation.SIP.types.enumerations.FeeType;
import com.ceridwen.circulation.SIP.types.enumerations.PaymentType;

@Command("37")
@TestCaseDefault("3719700101    0100000100USDAA|AO|BV|")
@TestCasePopulated("3719700101    0100000902GBPAApatronIdentifier|ACterminalPassword|ADpatronPassword|AOinstitutionId|BKtransactionId|BVfeeAmount|CGfeeIdentifier|")
public class FeePaid extends Message {
    private static final long serialVersionUID = -5641260852799759246L;
    @PositionedField(start = 2, end = 19)
    private java.util.Date transactionDate;
    @PositionedField(start = 20, end = 21, policy = FieldPolicy.REQUIRED)
    private FeeType feeType;
    @PositionedField(start = 22, end = 23)
    private PaymentType paymentType;
    @PositionedField(start = 24, end = 26, policy = FieldPolicy.REQUIRED)
    private CurrencyType currencyType;
    @TaggedField(FieldPolicy.REQUIRED)
    private String feeAmount;
    @TaggedField
    private String institutionId;
    @TaggedField(FieldPolicy.REQUIRED)
    private String patronIdentifier;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String terminalPassword;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String patronPassword;
    @TaggedField
    private String feeIdentifier;
    @TaggedField
    private String transactionId;

    public java.util.Date getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(java.util.Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public FeeType getFeeType() {
        return this.feeType;
    }

    public void setFeeType(FeeType feeType) {
        this.feeType = feeType;
    }

    public PaymentType getPaymentType() {
        return this.paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    public CurrencyType getCurrencyType() {
        return this.currencyType;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public String getFeeAmount() {
        return this.feeAmount;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
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

    public String getTerminalPassword() {
        return this.terminalPassword;
    }

    public void setTerminalPassword(String terminalPassword) {
        this.terminalPassword = terminalPassword;
    }

    public String getPatronPassword() {
        return this.patronPassword;
    }

    public void setPatronPassword(String patronPassword) {
        this.patronPassword = patronPassword;
    }

    public String getFeeIdentifier() {
        return this.feeIdentifier;
    }

    public void setFeeIdentifier(String feeIdentifier) {
        this.feeIdentifier = feeIdentifier;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }
}

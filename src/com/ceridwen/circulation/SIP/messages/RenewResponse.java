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
import com.ceridwen.circulation.SIP.types.enumerations.MediaType;

@Command("30")
@TestCaseDefault("300NUN19700101    010000AA|AB|AH|AJ|AO|")
@TestCasePopulated("301YYY19700101    010000AApatronIdentifier|ABitemIdentifier|AFscreenMessage|AGprintLine|AHdueDate|AJtitleIdentifier|AOinstitutionId|BHGBP|BKtransactionId|BT09|BVfeeAmount|CHitemProperties|CIY|CK010|")
public class RenewResponse extends Message {
    private static final long serialVersionUID = 434658072913047721L;
    @PositionedField(start = 2, end = 2)
    private Boolean ok;
    @PositionedField(start = 3, end = 3)
    private Boolean renewalOk;
    @PositionedField(start = 4, end = 4)
    private Boolean magneticMedia;
    @PositionedField(start = 5, end = 5)
    private Boolean desensitize;
    @PositionedField(start = 6, end = 23)
    private java.util.Date transactionDate;
    @TaggedField
    private String institutionId;
    @TaggedField(FieldPolicy.REQUIRED)
    private String patronIdentifier;
    @TaggedField(FieldPolicy.REQUIRED)
    private String itemIdentifier;
    @TaggedField(FieldPolicy.REQUIRED)
    private String titleIdentifier;
    @TaggedField(FieldPolicy.REQUIRED)
    private String dueDate;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private FeeType feeType;
    @TaggedField
    private Boolean securityInhibit;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private CurrencyType currencyType;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String feeAmount;
    @TaggedField
    private MediaType mediaType;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String itemProperties;
    @TaggedField
    private String transactionId;
    @TaggedField
    private String screenMessage;
    @TaggedField
    private String printLine;

    public Boolean isOk() {
        return this.ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public Boolean isRenewalOk() {
        return this.renewalOk;
    }

    public void setRenewalOk(Boolean renewalOk) {
        this.renewalOk = renewalOk;
    }

    public Boolean isMagneticMedia() {
        return this.magneticMedia;
    }

    public void setMagneticMedia(Boolean magneticMedia) {
        this.magneticMedia = magneticMedia;
    }

    public Boolean isDesensitize() {
        return this.desensitize;
    }

    public void setDesensitize(Boolean desensitize) {
        this.desensitize = desensitize;
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

    public String getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public FeeType getFeeType() {
        return this.feeType;
    }

    public void setFeeType(FeeType feeType) {
        this.feeType = feeType;
    }

    public Boolean isSecurityInhibit() {
        return this.securityInhibit;
    }

    public void setSecurityInhibit(Boolean securityInhibit) {
        this.securityInhibit = securityInhibit;
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

    public MediaType getMediaType() {
        return this.mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public String getItemProperties() {
        return this.itemProperties;
    }

    public void setItemProperties(String itemProperties) {
        this.itemProperties = itemProperties;
    }

    public String getTransactionId() {
        return this.transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
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

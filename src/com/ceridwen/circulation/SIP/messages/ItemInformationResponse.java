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
import com.ceridwen.circulation.SIP.types.enumerations.CirculationStatus;
import com.ceridwen.circulation.SIP.types.enumerations.CurrencyType;
import com.ceridwen.circulation.SIP.types.enumerations.FeeType;
import com.ceridwen.circulation.SIP.types.enumerations.MediaType;
import com.ceridwen.circulation.SIP.types.enumerations.SecurityMarker;

@Command("18")
@TestCaseDefault("1801000119700101    010000AB|AJ|")
@TestCasePopulated("1813030919700101    010000ABitemIdentifier|AFscreenMessage|AGprintLine|AHdueDate|AJtitleIdentifier|APcurrentLocation|AQpermanentLocation|BGowner|BHGBP|BVfeeAmount|CF123456789|CHitemProperties|CJ19700101    010000|CK010|CM19700101    010000|")
public class ItemInformationResponse extends Message {
    private static final long serialVersionUID = 6408854778106704492L;
    @PositionedField(start = 2, end = 3)
    private CirculationStatus circulationStatus;
    @PositionedField(start = 4, end = 5)
    private SecurityMarker securityMarker;
    @PositionedField(start = 6, end = 7, policy=FieldPolicy.REQUIRED)
    private FeeType feeType;
    @PositionedField(start = 8, end = 25)
    private Date transactionDate;
    @TaggedField
    private Integer holdQueueLength;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String dueDate;
    @TaggedField
    private Date recallDate;
    @TaggedField
    private Date holdPickupDate;
    @TaggedField(FieldPolicy.REQUIRED)
    private String itemIdentifier;
    @TaggedField(FieldPolicy.REQUIRED)
    private String titleIdentifier;
    @TaggedField
    private String owner;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private CurrencyType currencyType;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String feeAmount;
    @TaggedField
    private MediaType mediaType;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String permanentLocation;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String currentLocation;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String itemProperties;
    @TaggedField
    private String screenMessage;
    @TaggedField
    private String printLine;

    public CirculationStatus getCirculationStatus() {
        return this.circulationStatus;
    }

    public CurrencyType getCurrencyType() {
        return this.currencyType;
    }

    public String getCurrentLocation() {
        return this.currentLocation;
    }

    public String getDueDate() {
        return this.dueDate;
    }

    public String getFeeAmount() {
        return this.feeAmount;
    }

    public FeeType getFeeType() {
        return this.feeType;
    }

    public Date getHoldPickupDate() {
        return this.holdPickupDate;
    }

    public Integer getHoldQueueLength() {
        return this.holdQueueLength;
    }

    public String getItemIdentifier() {
        return this.itemIdentifier;
    }

    public String getItemProperties() {
        return this.itemProperties;
    }

    public MediaType getMediaType() {
        return this.mediaType;
    }

    public String getOwner() {
        return this.owner;
    }

    public String getPermanentLocation() {
        return this.permanentLocation;
    }

    public String getPrintLine() {
        return this.printLine;
    }

    public Date getRecallDate() {
        return this.recallDate;
    }

    public String getScreenMessage() {
        return this.screenMessage;
    }

    public SecurityMarker getSecurityMarker() {
        return this.securityMarker;
    }

    public String getTitleIdentifier() {
        return this.titleIdentifier;
    }

    public Date getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setTitleIdentifier(String titleIdentifier) {
        this.titleIdentifier = titleIdentifier;
    }

    public void setSecurityMarker(SecurityMarker securityMarker) {
        this.securityMarker = securityMarker;
    }

    public void setScreenMessage(String screenMessage) {
        this.screenMessage = screenMessage;
    }

    public void setRecallDate(Date recallDate) {
        this.recallDate = recallDate;
    }

    public void setPrintLine(String printLine) {
        this.printLine = printLine;
    }

    public void setPermanentLocation(String permanentLocation) {
        this.permanentLocation = permanentLocation;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public void setItemProperties(String itemProperties) {
        this.itemProperties = itemProperties;
    }

    public void setItemIdentifier(String itemIdentifier) {
        this.itemIdentifier = itemIdentifier;
    }

    public void setHoldQueueLength(Integer holdQueueLength) {
        this.holdQueueLength = holdQueueLength;
    }

    public void setHoldPickupDate(Date holdPickupDate) {
        this.holdPickupDate = holdPickupDate;
    }

    public void setFeeType(FeeType feeType) {
        this.feeType = feeType;
    }

    public void setFeeAmount(String feeAmount) {
        this.feeAmount = feeAmount;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void setCurrencyType(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }

    public void setCirculationStatus(CirculationStatus circulationStatus) {
        this.circulationStatus = circulationStatus;
    }
}

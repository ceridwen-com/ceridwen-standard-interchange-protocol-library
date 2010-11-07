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

import com.ceridwen.circulation.SIP.types.enumerations.CirculationStatus;
import com.ceridwen.circulation.SIP.types.enumerations.CurrencyType;
import com.ceridwen.circulation.SIP.types.enumerations.FeeType;
import com.ceridwen.circulation.SIP.types.enumerations.MediaType;
import com.ceridwen.circulation.SIP.types.enumerations.SecurityMarker;

public class ItemInformationResponse extends Message {
    /**
	 * 
	 */
    private static final long serialVersionUID = 6408854778106704492L;
    private CirculationStatus circulationStatus;
    private SecurityMarker securityMarker;
    private FeeType feeType;
    private Date transactionDate;
    private Integer holdQueueLength;
    private String dueDate;
    private Date recallDate;
    private Date holdPickupDate;
    private String itemIdentifier;
    private String titleIdentifier;
    private String owner;
    private CurrencyType currencyType;
    private String feeAmount;
    private MediaType mediaType;
    private String permanentLocation;
    private String currentLocation;
    private String itemProperties;
    private String screenMessage;
    private String printLine;

    @Override
    public String getCommand() {
        return "18";
    }

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

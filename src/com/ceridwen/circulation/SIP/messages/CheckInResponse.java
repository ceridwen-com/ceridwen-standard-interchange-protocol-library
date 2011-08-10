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
import com.ceridwen.circulation.SIP.types.enumerations.MediaType;

@Command("10")
@TestCaseDefault("100NUN19700101    010000AB|AO|AQ|")
@TestCasePopulated("101YYY19700101    010000AApatronIdentifier|ABitemIdentifier|AFscreenMessage|AGprintLine|AJtitleIdentifier|AOinstitutionId|AQpermanentLocation|CHitemProperties|CK010|CLsortBin|")
public class CheckInResponse extends Message {
    private static final long serialVersionUID = -3403534383487215711L;
    @PositionedField(start = 2, end = 2)
    private Boolean ok;
    @PositionedField(start = 3, end = 3)
    private Boolean resensitize;
    @PositionedField(start = 4, end = 4)
    private Boolean magneticMedia;
    @PositionedField(start = 5, end = 5)
    private Boolean alert;
    @PositionedField(start = 6, end = 23)
    private Date transactionDate;
    @TaggedField
    private String institutionId;
    @TaggedField(FieldPolicy.REQUIRED)
    private String itemIdentifier;
    @TaggedField(FieldPolicy.REQUIRED)
    private String permanentLocation;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String titleIdentifier;
    @TaggedField
    private String sortBin;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String patronIdentifier;
    @TaggedField
    private MediaType mediaType;
    @TaggedField(FieldPolicy.NOT_REQUIRED)
    private String itemProperties;
    @TaggedField
    private String screenMessage;
    @TaggedField
    private String printLine;

    public Boolean isAlert() {
        return this.alert;
    }

    public String getInstitutionId() {
        return this.institutionId;
    }

    public String getItemIdentifier() {
        return this.itemIdentifier;
    }

    public String getItemProperties() {
        return this.itemProperties;
    }

    public Boolean isMagneticMedia() {
        return this.magneticMedia;
    }

    public MediaType getMediaType() {
        return this.mediaType;
    }

    public Boolean isOk() {
        return this.ok;
    }

    public String getPatronIdentifier() {
        return this.patronIdentifier;
    }

    public String getPermanentLocation() {
        return this.permanentLocation;
    }

    public String getPrintLine() {
        return this.printLine;
    }

    public Boolean isResensitize() {
        return this.resensitize;
    }

    public String getScreenMessage() {
        return this.screenMessage;
    }

    public String getSortBin() {
        return this.sortBin;
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

    public void setSortBin(String sortBin) {
        this.sortBin = sortBin;
    }

    public void setScreenMessage(String screenMessage) {
        this.screenMessage = screenMessage;
    }

    public void setResensitize(Boolean resensitize) {
        this.resensitize = resensitize;
    }

    public void setPrintLine(String printLine) {
        this.printLine = printLine;
    }

    public void setPermanentLocation(String permanentLocation) {
        this.permanentLocation = permanentLocation;
    }

    public void setPatronIdentifier(String patronIdentifier) {
        this.patronIdentifier = patronIdentifier;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public void setMagneticMedia(Boolean magneticMedia) {
        this.magneticMedia = magneticMedia;
    }

    public void setItemProperties(String itemProperties) {
        this.itemProperties = itemProperties;
    }

    public void setItemIdentifier(String itemIdentifier) {
        this.itemIdentifier = itemIdentifier;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public void setAlert(Boolean alert) {
        this.alert = alert;
    }
}

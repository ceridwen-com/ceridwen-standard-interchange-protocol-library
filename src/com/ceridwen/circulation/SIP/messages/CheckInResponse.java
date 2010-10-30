/*******************************************************************************
 * Copyright (c) 2010 Matthew J. Dovey.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * <http://www.gnu.org/licenses/>.
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
 *     Matthew J. Dovey - initial API and implementation
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

import com.ceridwen.circulation.SIP.types.enumerations.MediaType;

public class CheckInResponse extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = -3403534383487215711L;
private Boolean ok;
  private Boolean resensitize;
  private Boolean magenticMedia;
  private Boolean alert;
  private Date transactionDate = new java.util.Date();
  private String institutionId;
  private String itemIdentifier;
  private String permanentLocation;
  private String titleIdentifier;
  private String sortBin;
  private String patronIdentifier;
  private MediaType mediaType = MediaType.OTHER;
  private String itemProperties;
  private String screenMessage;
  private String printLine;

  public String getCommand() {
    return "10";
  }
  public Boolean getAlert() {
    return alert;
  }
  public String getInstitutionId() {
    return institutionId;
  }
  public String getItemIdentifier() {
    return itemIdentifier;
  }
  public String getItemProperties() {
    return itemProperties;
  }
  public Boolean getMagenticMedia() {
    return magenticMedia;
  }
  public MediaType getMediaType() {
    return mediaType;
  }
  public Boolean getOk() {
    return ok;
  }
  public String getPatronIdentifier() {
    return patronIdentifier;
  }
  public String getPermanentLocation() {
    return permanentLocation;
  }
  public String getPrintLine() {
    return printLine;
  }
  public Boolean getResensitize() {
    return resensitize;
  }
  public String getScreenMessage() {
    return screenMessage;
  }
  public String getSortBin() {
    return sortBin;
  }
  public String getTitleIdentifier() {
    return titleIdentifier;
  }
  public Date getTransactionDate() {
    return transactionDate;
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
  public void setMagenticMedia(Boolean magenticMedia) {
    this.magenticMedia = magenticMedia;
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

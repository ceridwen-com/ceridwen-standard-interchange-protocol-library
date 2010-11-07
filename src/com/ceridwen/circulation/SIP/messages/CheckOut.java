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

public class CheckOut extends Message {
    /**
	 * 
	 */
    private static final long serialVersionUID = 8454866593857815453L;
    private Boolean SCRenewalPolicy;
    private Boolean noBlock;
    private Date transactionDate;
    private Date nbDueDate;
    private String institutionId;
    private String patronIdentifier;
    private String itemIdentifier;
    private String terminalPassword;
    private String itemProperties;
    private String patronPassword;
    private Boolean feeAcknowledged;
    private Boolean cancel;

    @Override
    public String getCommand() {
        return "11";
    }

    public Boolean isCancel() {
        return this.cancel;
    }

    public Boolean isFeeAcknowledged() {
        return this.feeAcknowledged;
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

    public Date getNbDueDate() {
        return this.nbDueDate;
    }

    public Boolean isNoBlock() {
        return this.noBlock;
    }

    public String getPatronIdentifier() {
        return this.patronIdentifier;
    }

    public String getPatronPassword() {
        return this.patronPassword;
    }

    public Boolean isSCRenewalPolicy() {
        return this.SCRenewalPolicy;
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

    public void setSCRenewalPolicy(Boolean SCRenewalPolicy) {
        this.SCRenewalPolicy = SCRenewalPolicy;
    }

    public void setPatronPassword(String patronPassword) {
        this.patronPassword = patronPassword;
    }

    public void setPatronIdentifier(String patronIdentifier) {
        this.patronIdentifier = patronIdentifier;
    }

    public void setNoBlock(Boolean noBlock) {
        this.noBlock = noBlock;
    }

    public void setNbDueDate(Date nbDueDate) {
        this.nbDueDate = nbDueDate;
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

    public void setFeeAcknowledged(Boolean feeAcknowledged) {
        this.feeAcknowledged = feeAcknowledged;
    }

    public void setCancel(Boolean cancel) {
        this.cancel = cancel;
    }
}

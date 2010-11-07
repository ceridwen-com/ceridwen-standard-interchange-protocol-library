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

public class RenewAllResponse extends Message {
    /**
	 * 
	 */
    private static final long serialVersionUID = 5428582577226346891L;
    private Boolean ok;
    private Integer renewedCount;
    private Integer unrenewedCount;
    private java.util.Date transactionDate;
    private String institutionId;
    private String screenMessage;
    private String printLine;

    @Override
    public String getCommand() {
        return "66";
    }

    public Boolean isOk() {
        return this.ok;
    }

    public void setOk(Boolean ok) {
        this.ok = ok;
    }

    public Integer getRenewedCount() {
        return this.renewedCount;
    }

    public void setRenewedCount(Integer renewedCount) {
        this.renewedCount = renewedCount;
    }

    public Integer getUnrenewedCount() {
        return this.unrenewedCount;
    }

    public void setUnrenewedCount(Integer unrenewedCount) {
        this.unrenewedCount = unrenewedCount;
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

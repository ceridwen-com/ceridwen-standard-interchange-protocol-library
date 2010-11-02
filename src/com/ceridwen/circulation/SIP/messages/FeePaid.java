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
package com.ceridwen.circulation.SIP.messages;

import com.ceridwen.circulation.SIP.types.enumerations.CurrencyType;
import com.ceridwen.circulation.SIP.types.enumerations.FeeType;
import com.ceridwen.circulation.SIP.types.enumerations.PaymentType;

public class FeePaid extends Message {
  /**
	 * 
	 */
	private static final long serialVersionUID = -5641260852799759246L;
	private java.util.Date transactionDate;
	private FeeType feeType;
	private PaymentType paymentType;
	private CurrencyType currencyType;
	private String feeAmount;
	private String institutionId;
	private String patronIdentifier;
	private String terminalPassword;
	private String patronPassword;
	private String feeIdentifier;
	private String transactionId;
	
  public String getCommand() {
    return "37";
  }
  public java.util.Date getTransactionDate() {
    return transactionDate;
  }
  public void setTransactionDate(java.util.Date transactionDate) {
    this.transactionDate = transactionDate;
  }
  public FeeType getFeeType() {
    return feeType;
  }
  public void setFeeType(FeeType feeType) {
    this.feeType = feeType;
  }
  public PaymentType getPaymentType() {
    return paymentType;
  }
  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }
  public CurrencyType getCurrencyType() {
    return currencyType;
  }
  public void setCurrencyType(CurrencyType currencyType) {
    this.currencyType = currencyType;
  }
  public String getFeeAmount() {
    return feeAmount;
  }
  public void setFeeAmount(String feeAmount) {
    this.feeAmount = feeAmount;
  }
  public String getInstitutionId() {
    return institutionId;
  }
  public void setInstitutionId(String institutionId) {
    this.institutionId = institutionId;
  }
  public String getPatronIdentifier() {
    return patronIdentifier;
  }
  public void setPatronIdentifier(String patronIdentifier) {
    this.patronIdentifier = patronIdentifier;
  }
  public String getTerminalPassword() {
    return terminalPassword;
  }
  public void setTerminalPassword(String terminalPassword) {
    this.terminalPassword = terminalPassword;
  }
  public String getPatronPassword() {
    return patronPassword;
  }
  public void setPatronPassword(String patronPassword) {
    this.patronPassword = patronPassword;
  }
  public String getFeeIdentifier() {
    return feeIdentifier;
  }
  public void setFeeIdentifier(String feeIdentifier) {
    this.feeIdentifier = feeIdentifier;
  }
  public String getTransactionId() {
    return transactionId;
  }
  public void setTransactionId(String transactionId) {
    this.transactionId = transactionId;
  }
}

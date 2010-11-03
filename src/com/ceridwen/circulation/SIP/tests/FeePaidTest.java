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
package com.ceridwen.circulation.SIP.tests;

import com.ceridwen.circulation.SIP.messages.FeePaid;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.enumerations.CurrencyType;
import com.ceridwen.circulation.SIP.types.enumerations.FeeType;
import com.ceridwen.circulation.SIP.types.enumerations.PaymentType;

public class FeePaidTest extends AbstractMessageTest<FeePaid> {
	@Override
	public Message getDefaultMessage() {
		FeePaid m = new FeePaid();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "3719700101    0100000100USDAA|AO|BV|";
	}

	@Override
	public Message getMessage() {
		FeePaid m = new FeePaid();
		
		m.setCurrencyType(CurrencyType.UK_POUNDS);
		m.setFeeAmount("feeAmount");
		m.setFeeIdentifier("feeIdentifier");
		m.setFeeType(FeeType.REPLACEMENT);
		m.setInstitutionId("institutionId");
		m.setPatronIdentifier("patronIdentifier");
		m.setPatronPassword("patronPassword");
		m.setPaymentType(PaymentType.VISA);
		m.setTerminalPassword("terminalPassword");
		m.setTransactionDate(new java.util.Date(0));
		m.setTransactionId("transactionId");

		return m;
	}

	@Override
	public String getEncoding() {
		return "3719700101    0100000701GBPAApatronIdentifier|ACterminalPassword|ADpatronPassword|AOinstitutionId|BKtransactionId|BVfeeAmount|CGfeeIdentifier|";
	}
}


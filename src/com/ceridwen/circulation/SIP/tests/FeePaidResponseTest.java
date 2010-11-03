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

import com.ceridwen.circulation.SIP.messages.FeePaidResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class FeePaidResponseTest extends AbstractMessageTest<FeePaidResponse> {

	@Override
	public Message getDefaultMessage() {
		FeePaidResponse m = new FeePaidResponse();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "38N19700101    010000AA|AO|";
	}

	@Override
	public Message getMessage() {
		FeePaidResponse m = new FeePaidResponse();

		m.setInstitutionId("institutionId");
		m.setPatronIdentifier("patronIdentifier");
		m.setPaymentAccepted(true);
		m.setPrintLine("printLine");
		m.setScreenMessage("screenMessage");
		m.setTransactionDate(new java.util.Date(0));
		m.setTransactionId("transactionId");

		return m;
	}

	@Override
	public String getEncoding() {
		return "38Y19700101    010000AApatronIdentifier|AFscreenMessage|AGprintLine|AOinstitutionId|BKtransactionId|";
	}
}


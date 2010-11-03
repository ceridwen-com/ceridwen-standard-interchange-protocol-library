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

import com.ceridwen.circulation.SIP.messages.PatronEnableResponse;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.enumerations.Language;
import com.ceridwen.circulation.SIP.types.flagfields.PatronStatus;

public class PatronEnableResponseTest extends AbstractMessageTest<PatronEnableResponse> {
	@Override
	public Message getDefaultMessage() {
		PatronEnableResponse m = new PatronEnableResponse();

		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "26              00019700101    010000AA|AE|AO|";
	}

	@Override
	public Message getMessage() {
		PatronEnableResponse m = new PatronEnableResponse();
		
		m.setInstitutionId("institutionId");
		m.setLanguage(Language.UNITED_KINGDOM);
		m.setPatronIdentifier("patronIdentifier");
		m.getPatronStatus().set(PatronStatus.CARD_REPORTED_LOST);
		m.getPatronStatus().set(PatronStatus.CHARGE_PRIVILEGES_DENIED);
		m.getPatronStatus().set(PatronStatus.EXCESSIVE_OUTSTANDING_FEES);
		m.getPatronStatus().set(PatronStatus.EXCESSIVE_OUTSTANDING_FINES);
		m.getPatronStatus().set(PatronStatus.HOLD_PRIVILIGES_DENIED);
		m.getPatronStatus().set(PatronStatus.RECALL_OVERDUE);
		m.getPatronStatus().set(PatronStatus.RECALL_PRIVILIGES_DENIED);
		m.getPatronStatus().set(PatronStatus.RENEWAL_PRIVILIGES_DENIED);
		m.getPatronStatus().set(PatronStatus.TOO_MANY_CLAIMS_OF_ITEMS_RETURNED);
		m.getPatronStatus().set(PatronStatus.TOO_MANY_ITEMS_BILLED);
		m.getPatronStatus().set(PatronStatus.TOO_MANY_ITEMS_CHARGED);
		m.getPatronStatus().set(PatronStatus.TOO_MANY_ITEMS_LOST);
		m.getPatronStatus().set(PatronStatus.TOO_MANY_ITEMS_OVERDUE);
		m.getPatronStatus().set(PatronStatus.TOO_MANY_RENEWALS);
		m.setPersonalName("personalName");
		m.setPrintLine("printLine");
		m.setScreenMessage("screenMessage");
		m.setTransactionDate(new java.util.Date(0));
		m.setValidPatron(true);
		m.setValidPatronPassword(true);

		return m;
	}

	@Override
	public String getEncoding() {
		return "26YYYYYYYYYYYYYY02419700101    010000AApatronIdentifier|AEpersonalName|AFscreenMessage|AGprintLine|AOinstitutionId|BLY|CQY|";
	}
}


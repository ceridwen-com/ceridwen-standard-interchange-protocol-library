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

import com.ceridwen.circulation.SIP.messages.PatronInformationResponse;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.enumerations.CurrencyType;
import com.ceridwen.circulation.SIP.types.enumerations.Language;
import com.ceridwen.circulation.SIP.types.flagfields.PatronStatus;

public class PatronInformationResponseTest extends AbstractMessageTest<PatronInformationResponse> {

	@Override
	public Message getDefaultMessage() {
		PatronInformationResponse m = new PatronInformationResponse();

		m.setTransactionDate(new java.util.Date(0));
		
		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "64              00019700101    010000                        AA|AE|AO|";
	}

	@Override
	public Message getMessage() {
		PatronInformationResponse m = new PatronInformationResponse();

		m.setChargedItems(new String[]{"chargedItems1", "chargedItems2"});
		m.setChargedItemsCount(1234);
		m.setChargedItemsLimit(12);
		m.setCurrencyType(CurrencyType.UK_POUNDS);
		m.setEMailAddress("eMailAddress");
		m.setFeeAmount("feeAmount");
		m.setFeeLimit("feeLimit");
		m.setFineItems(new String[]{"fineItems1", "fineItems2"});
		m.setFineItemsCount(12);
		m.setHoldItems(new String[]{"holdItems1", "holdItems2"});
		m.setHoldItemsCount(12);
		m.setHoldItemsLimit(123);
		m.setHomeAddress("homeAddress");
		m.setHomePhoneNumber("homePhoneNumber");
		m.setInstitutionId("institutionId");
		m.setLanguage(Language.UNITED_KINGDOM);
		m.setOverdueItems(new String[]{"overdueItems1", "overdueItems2"});
		m.setOverdueItemsCount(1234);
		m.setOverdueItemsLimit(1234);
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
		m.setRecallItems(new String[]{"recallItems1", "recallItems2"});
		m.setRecallItemsCount(1234);
		m.setScreenMessage("screenMessage");
		m.setTransactionDate(new java.util.Date(0));
		m.setUnavailableHoldItems(new String[]{"unavailableHoldItems1", "unavailableHoldItems2"});
		m.setUnavailableHoldsCount(1234);
		m.setValidPatron(true);
		m.setValidPatronPassword(true);		
		
		return m;
	}

	@Override
	public String getEncoding() {
		return "64YYYYYYYYYYYYYY02419700101    010000001212341234001212341234AApatronIdentifier|AEpersonalName|AFscreenMessage|AGprintLine|AOinstitutionId|ASholdItems1|ASholdItems2|AToverdueItems1|AToverdueItems2|AUchargedItems1|AUchargedItems2|AVfineItems1|AVfineItems2|BDhomeAddress|BEeMailAddress|BFhomePhoneNumber|BHGBP|BLY|BUrecallItems1|BUrecallItems2|BVfeeAmount|BZ0123|CA1234|CB0012|CCfeeLimit|CDunavailableHoldItems1|CDunavailableHoldItems2|CQY|";
	}
}


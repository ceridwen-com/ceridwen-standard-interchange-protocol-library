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

import com.ceridwen.circulation.SIP.messages.Hold;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.enumerations.HoldMode;
import com.ceridwen.circulation.SIP.types.enumerations.HoldType;

public class HoldTest extends AbstractMessageTest<Hold> {
	@Override
	public Message getDefaultMessage() {
		Hold m = new Hold();
		
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "15*19700101    010000AA|AO|";
	}

	@Override
	public Message getMessage() {
		Hold m = new Hold();
		
		m.setExpirationDate(new java.util.Date(0));
		m.setFeeAcknowledged(true);
		m.setHoldMode(HoldMode.DELETE);		
		m.setHoldType(HoldType.SUBLOCATION_COPY);
		m.setInstitutionId("institutionId");
		m.setItemIdentifier("itemIdentifier");
		m.setPatronIdentifier("patronIdentifier");
		m.setPatronPassword("patronPassword");
		m.setPickupLocation("pickupLocation");
		m.setTerminalPassword("terminalPassword");
		m.setTitleIdentifier("titleIdentifier");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "15-19700101    010000AApatronIdentifier|ABitemIdentifier|ACterminalPassword|ADpatronPassword|AJtitleIdentifier|AOinstitutionId|BOY|BSpickupLocation|BW19700101    010000|BY4|";
	}
}


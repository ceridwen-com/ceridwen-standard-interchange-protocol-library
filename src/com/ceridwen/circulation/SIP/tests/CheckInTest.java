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

import com.ceridwen.circulation.SIP.messages.CheckIn;
import com.ceridwen.circulation.SIP.messages.Message;

public class CheckInTest extends AbstractMessageTest<CheckIn> {
	@Override
	public Message getDefaultMessage() {
		CheckIn m = new CheckIn();
		
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "09N19700101    010000                  AB|AC|AO|AP|";
	}

	@Override
	public Message getMessage() {
		CheckIn m = new CheckIn();
		
		m.setCancel(true);
		m.setCurrentLocation("currentLocation");
		m.setInstitutionId("institutionId");
		m.setItemIdentifier("itemIdentifier");
		m.setInstitutionId("institutionId");
		m.setItemIdentifier("itemIdentifier");
		m.setItemProperties("itemProperties");
		m.setNoBlock(true);
		m.setReturnDate(new java.util.Date(0));
		m.setTerminalPassword("terminalPassword");
		m.setTransactionDate(new java.util.Date(0));

		return m;
	}

	@Override
	public String getEncoding() {
		return "09Y19700101    01000019700101    010000ABitemIdentifier|ACterminalPassword|AOinstitutionId|APcurrentLocation|BIY|CHitemProperties|";
	}
}


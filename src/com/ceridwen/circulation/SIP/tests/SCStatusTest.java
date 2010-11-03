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

import com.ceridwen.circulation.SIP.messages.SCStatus;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.enumerations.ProtocolVersion;
import com.ceridwen.circulation.SIP.types.enumerations.StatusCode;

public class SCStatusTest extends AbstractMessageTest<SCStatus> {
	@Override
	public Message getDefaultMessage() {
		SCStatus m = new SCStatus();

		return m;
	}

	@Override
	public String getDefaultEncoding() {
		return "9900002.00";
	}

	@Override
	public Message getMessage() {
		SCStatus m = new SCStatus();
		
		m.setMaxPrintWidth(123);
		m.setProtocolVersion(ProtocolVersion.VERSION_2_00);
		m.setStatusCode(StatusCode.OUT_OF_PAPER);

		return m;
	}

	@Override
	public String getEncoding() {
		return "9911232.00";
	}
}


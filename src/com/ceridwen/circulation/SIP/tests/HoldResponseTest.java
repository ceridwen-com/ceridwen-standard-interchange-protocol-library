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

import com.ceridwen.circulation.SIP.messages.HoldResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class HoldResponseTest extends AbstractMessageTest<HoldResponse> {
    @Override
    public Message getDefaultMessage() {
        HoldResponse m = new HoldResponse();

        m.setTransactionDate(new java.util.Date(0));

        return m;
    }

    @Override
    public String getDefaultEncoding() {
        return "160N19700101    010000AA|AO|";
    }

    @Override
    public Message getMessage() {
        HoldResponse m = new HoldResponse();

        m.setAvailable(true);
        m.setExpirationDate(new java.util.Date(0));
        m.setInstitutionId("institutionId");
        m.setItemIdentifier("itemIdentifier");
        m.setOk(true);
        m.setPatronIdentifier("patronIdentifier");
        m.setPickupLocation("pickupLocation");
        m.setPrintLine("printLine");
        m.setQueuePosition(12345);
        m.setScreenMessage("screenMessage");
        m.setTitleIdentifier("titleIdentifier");
        m.setTransactionDate(new java.util.Date(0));

        return m;
    }

    @Override
    public String getEncoding() {
        return "161Y19700101    010000AApatronIdentifier|ABitemIdentifier|AFscreenMessage|AGprintLine|AJtitleIdentifier|AOinstitutionId|BR12345|BSpickupLocation|BW19700101    010000|";
    }
}

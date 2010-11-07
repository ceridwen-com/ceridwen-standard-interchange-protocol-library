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

import com.ceridwen.circulation.SIP.messages.CheckInResponse;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.types.enumerations.MediaType;

public class CheckInResponseTest extends AbstractMessageTest<CheckInResponse> {
    @Override
    public Message getDefaultMessage() {
        CheckInResponse m = new CheckInResponse();

        m.setTransactionDate(new java.util.Date(0));

        return m;
    }

    @Override
    public String getDefaultEncoding() {
        return "100NUN19700101    010000AB|AO|AQ|";
    }

    @Override
    public Message getMessage() {
        CheckInResponse m = new CheckInResponse();

        m.setAlert(true);
        m.setInstitutionId("institutionId");
        m.setItemIdentifier("itemIdentifier");
        m.setItemProperties("itemProperties");
        m.setMagneticMedia(true);
        m.setMediaType(MediaType.CD);
        m.setOk(true);
        m.setPatronIdentifier("patronIdentifier");
        m.setPermanentLocation("permanentLocation");
        m.setPrintLine("printLine");
        m.setResensitize(true);
        m.setScreenMessage("screenMessage");
        m.setSortBin("sortBin");
        m.setTitleIdentifier("titleIdentifier");
        m.setTransactionDate(new java.util.Date(0));

        return m;
    }

    @Override
    public String getEncoding() {
        return "101YYY19700101    010000AApatronIdentifier|ABitemIdentifier|AFscreenMessage|AGprintLine|AJtitleIdentifier|AOinstitutionId|AQpermanentLocation|CHitemProperties|CK006|CLsortBin|";
    }
}

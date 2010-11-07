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

import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.messages.PatronStatusRequest;
import com.ceridwen.circulation.SIP.types.enumerations.Language;

public class PatronStatusRequestTest extends AbstractMessageTest<PatronStatusRequest> {

    @Override
    public Message getDefaultMessage() {
        PatronStatusRequest m = new PatronStatusRequest();

        m.setTransactionDate(new java.util.Date(0));

        return m;
    }

    @Override
    public String getDefaultEncoding() {
        return "2300019700101    010000AA|AC|AD|AO|";
    }

    @Override
    public Message getMessage() {
        PatronStatusRequest m = new PatronStatusRequest();

        m.setInstitutionId("institutionId");
        m.setLanguage(Language.UNITED_KINGDOM);
        m.setPatronIdentifier("patronIdentifier");
        m.setPatronPassword("patronPassword");
        m.setTerminalPassword("terminalPassword");
        m.setTransactionDate(new java.util.Date(0));

        return m;
    }

    @Override
    public String getEncoding() {
        return "2302419700101    010000AApatronIdentifier|ACterminalPassword|ADpatronPassword|AOinstitutionId|";
    }
}

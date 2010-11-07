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

import com.ceridwen.circulation.SIP.messages.ItemInformation;
import com.ceridwen.circulation.SIP.messages.Message;

public class ItemInformationTest extends AbstractMessageTest<ItemInformation> {
    @Override
    public Message getDefaultMessage() {
        ItemInformation m = new ItemInformation();

        m.setTransactionDate(new java.util.Date(0));

        return m;
    }

    @Override
    public String getDefaultEncoding() {
        return "1719700101    010000AB|AO|";
    }

    @Override
    public Message getMessage() {
        ItemInformation m = new ItemInformation();

        m.setInstitutionId("institution");
        m.setItemIdentifier("item");
        m.setTerminalPassword("password");
        m.setTransactionDate(new java.util.Date(0));

        return m;
    }

    @Override
    public String getEncoding() {
        return "1719700101    010000ABitem|ACpassword|AOinstitution|";
    }

}

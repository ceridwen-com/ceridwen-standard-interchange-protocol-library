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
package com.ceridwen.circulation.SIP.messages;

import com.ceridwen.circulation.SIP.annotations.Command;
import com.ceridwen.circulation.SIP.annotations.TestCaseDefault;
import com.ceridwen.circulation.SIP.annotations.TestCasePopulated;

@Command("97")
@TestCaseDefault("97AZFEF5")
@TestCasePopulated("97AZFEF5")
public class ACSResend extends Message {
    private static final long serialVersionUID = 1455544775405713654L;
    
    @Override
    protected String addChecksum(String command, Character sequence) {
        StringBuffer check = new StringBuffer();
        check.append("AZ");
        try {
            check.append(Message.calculateChecksum(command + check.toString()));
            return command + check.toString();
        } catch (Exception e) {
            return command;
        }
    }

}

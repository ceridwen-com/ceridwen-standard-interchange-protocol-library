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
package com.ceridwen.circulation.SIP.types.flagfields;

public class SupportedMessages extends AbstractFlagField {
    private static final long serialVersionUID = -7794339322282396820L;
    public static final int PATRON_STATUS_REQUEST = 0;
    public static final int CHECK_OUT = 1;
    public static final int CHECK_IN = 2;
    public static final int BLOCK_PATRON = 3;
    public static final int SC_ACS_STATUS = 4;
    public static final int REQUEST_SC_ACS_RESEND = 5;
    public static final int LOGIN = 6;
    public static final int PATRON_INFORMATION = 7;
    public static final int END_PATRON_SESSION = 8;
    public static final int FEE_PAID = 9;
    public static final int ITEM_INFORMATION = 10;
    public static final int ITEM_STATUS_UPDATE = 11;
    public static final int PATRON_ENABLE = 12;
    public static final int HOLD = 13;
    public static final int RENEW = 14;
    public static final int RENEW_ALL = 15;

    public SupportedMessages(String flags) {
        super(flags);
    }

    public SupportedMessages() {
        super("");
    }

    @Override
    protected int getLength() {
        return 16;
    }

    @Override
    protected char[] getValid() {
        return new char[] { 'N', 'Y' };
    }

    public static void main(String[] args) {
        SupportedMessages test = new SupportedMessages("");

        System.out.println("*012345678901234567890*");
        System.out.println("*" + test.toString() + "*");
        test.set(SupportedMessages.RENEW_ALL);
        test.set(SupportedMessages.LOGIN);
        System.out.println("*" + test.toString() + "*");
        test.unset(SupportedMessages.LOGIN);
        System.out.println("*" + test.toString() + "*");
    }
}

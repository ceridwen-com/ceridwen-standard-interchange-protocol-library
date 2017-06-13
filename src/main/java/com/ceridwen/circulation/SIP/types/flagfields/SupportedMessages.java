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
    private static final int PATRON_STATUS_REQUEST = 0;
    private static final int CHECK_OUT = 1;
    private static final int CHECK_IN = 2;
    private static final int BLOCK_PATRON = 3;
    private static final int SC_ACS_STATUS = 4;
    private static final int REQUEST_SC_ACS_RESEND = 5;
    private static final int LOGIN = 6;
    private static final int PATRON_INFORMATION = 7;
    private static final int END_PATRON_SESSION = 8;
    private static final int FEE_PAID = 9;
    private static final int ITEM_INFORMATION = 10;
    private static final int ITEM_STATUS_UPDATE = 11;
    private static final int PATRON_ENABLE = 12;
    private static final int HOLD = 13;
    private static final int RENEW = 14;
    private static final int RENEW_ALL = 15;

    public SupportedMessages(String flags) {
        super(flags);
    }

    public SupportedMessages() {
        super("");
    }

    public boolean isPatronStatusRequest() {
      return this.isSet(PATRON_STATUS_REQUEST);
    }
    public void setPatronStatusRequest(boolean flag) {
      this.set(PATRON_STATUS_REQUEST, flag);
    }
    public boolean isCheckOut() {
      return this.isSet(CHECK_OUT);
    }
    public void setCheckOut(boolean flag) {
      this.set(CHECK_OUT, flag);
    }
    public boolean isCheckIn() {
      return this.isSet(CHECK_IN);
    }
    public void setCheckIn(boolean flag) {
      this.set(CHECK_IN, flag);
    }
    public boolean isBlockPatron() {
      return this.isSet(BLOCK_PATRON);
    }
    public void setBlockPatron(boolean flag) {
      this.set(BLOCK_PATRON, flag);
    }
    public boolean isScAcsStatus() {
      return this.isSet(SC_ACS_STATUS);
    }
    public void setScAcsStatus(boolean flag) {
      this.set(SC_ACS_STATUS, flag);
    }
    public boolean isRequestScAcsResent() {
      return this.isSet(REQUEST_SC_ACS_RESEND);
    }
    public void setRequestScAcsResend(boolean flag) {
      this.set(REQUEST_SC_ACS_RESEND, flag);
    }
    public boolean isLogin() {
      return this.isSet(LOGIN);
    }
    public void setLogin(boolean flag) {
      this.set(LOGIN, flag);
    }
    public boolean isPatronInformation() {
      return this.isSet(PATRON_INFORMATION);
    }
    public void setPatronInformation(boolean flag) {
      this.set(PATRON_INFORMATION, flag);
    }
    public boolean isEndPatronSession() {
      return this.isSet(END_PATRON_SESSION);
    }
    public void setEndPatronSession(boolean flag) {
      this.set(END_PATRON_SESSION, flag);
    }
    public boolean isFeePaid() {
      return this.isSet(FEE_PAID);
    }
    public void setFeePaid(boolean flag) {
      this.set(FEE_PAID, flag);
    }
    public boolean isItemInformation() {
      return this.isSet(ITEM_INFORMATION);
    }
    public void setItemInformation(boolean flag) {
      this.set(ITEM_INFORMATION, flag);
    }
    public boolean isItemStatusUpdate() {
      return this.isSet(ITEM_STATUS_UPDATE);
    }
    public void setItemStatusUpdate(boolean flag) {
      this.set(ITEM_STATUS_UPDATE, flag);
    }
    public boolean isPatronEnable() {
      return this.isSet(PATRON_ENABLE);
    }
    public void setPatronEnable(boolean flag) {
      this.set(PATRON_ENABLE, flag);
    }
    public boolean isHold() {
      return this.isSet(HOLD);
    }
    public void setHold(boolean flag) {
      this.set(HOLD, flag);
    }
    public boolean isRenew() {
      return this.isSet(RENEW);
    }
    public void setRenew(boolean flag) {
      this.set(RENEW, flag);
    }
    public boolean isRenewAll() {
      return this.isSet(RENEW_ALL);
    }
    public void setRenewAll(boolean flag) {
      this.set(RENEW_ALL, flag);
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
        test.setRenewAll(true);
        test.setLogin(true);
        System.out.println("*" + test.toString() + "*");
        test.setLogin(false);
        System.out.println("*" + test.toString() + "*");
    }
}

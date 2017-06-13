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

public class PatronStatus extends AbstractFlagField {
    private static final long serialVersionUID = -1160351918609471912L;
    public static final int CHARGE_PRIVILEGES_DENIED = 0;
    public static final int RENEWAL_PRIVILIGES_DENIED = 1;
    public static final int RECALL_PRIVILIGES_DENIED = 2;
    public static final int HOLD_PRIVILIGES_DENIED = 3;
    public static final int CARD_REPORTED_LOST = 4;
    public static final int TOO_MANY_ITEMS_CHARGED = 5;
    public static final int TOO_MANY_ITEMS_OVERDUE = 6;
    public static final int TOO_MANY_RENEWALS = 7;
    public static final int TOO_MANY_CLAIMS_OF_ITEMS_RETURNED = 8;
    public static final int TOO_MANY_ITEMS_LOST = 9;
    public static final int EXCESSIVE_OUTSTANDING_FINES = 10;
    public static final int EXCESSIVE_OUTSTANDING_FEES = 11;
    public static final int RECALL_OVERDUE = 12;
    public static final int TOO_MANY_ITEMS_BILLED = 13;

    public PatronStatus(String flags) {
        super(flags);
    }

    public PatronStatus() {
        super("");
    }
    
    public boolean isChargePrivilegesDenied() {
      return this.isSet(CHARGE_PRIVILEGES_DENIED);
    }
    public void setChargePrivilegesDenied(boolean flag) {
      this.set(CHARGE_PRIVILEGES_DENIED);
    }
    public boolean isRenewalPrivilegesDenied() {
      return this.isSet(RENEWAL_PRIVILIGES_DENIED);
    }
    public void setRenewalPrivilegesDenied(boolean flag) {
      this.set(RENEWAL_PRIVILIGES_DENIED);
    }
    public boolean isRecallPrivilegesDenied() {
      return this.isSet(RECALL_PRIVILIGES_DENIED);
    }
    public void setRecallPrivilegesDenied(boolean flag) {
      this.set(RECALL_PRIVILIGES_DENIED);
    }
    public boolean isHoldPrivilegesDenied() {
      return this.isSet(HOLD_PRIVILIGES_DENIED);
    }
    public void setHoldPrivilegesDenied(boolean flag) {
      this.set(HOLD_PRIVILIGES_DENIED);
    }
    public boolean isCardReportedLost() {
      return this.isSet(CARD_REPORTED_LOST);
    }
    public void setCardReportedLost(boolean flag) {
      this.set(CARD_REPORTED_LOST);
    }
    public boolean isTooManyItemsCharged() {
      return this.isSet(TOO_MANY_ITEMS_CHARGED);
    }
    public void setTooManyItemsCharged(boolean flag) {
      this.set(TOO_MANY_ITEMS_CHARGED);
    }
/**
    public boolean isChargePrivilegesDenied() {
      return this.isSet(CHARGE_PRIVILEGES_DENIED);
    }
    public void setChargePrivilegesDenied(boolean flag) {
      this.set(CHARGE_PRIVILEGES_DENIED);
    }
    public boolean isChargePrivilegesDenied() {
      return this.isSet(CHARGE_PRIVILEGES_DENIED);
    }
    public void setChargePrivilegesDenied(boolean flag) {
      this.set(CHARGE_PRIVILEGES_DENIED);
    }
    public boolean isChargePrivilegesDenied() {
      return this.isSet(CHARGE_PRIVILEGES_DENIED);
    }
    public void setChargePrivilegesDenied(boolean flag) {
      this.set(CHARGE_PRIVILEGES_DENIED);
    }
    public boolean isChargePrivilegesDenied() {
      return this.isSet(CHARGE_PRIVILEGES_DENIED);
    }
    public void setChargePrivilegesDenied(boolean flag) {
      this.set(CHARGE_PRIVILEGES_DENIED);
    }
    public boolean isChargePrivilegesDenied() {
      return this.isSet(CHARGE_PRIVILEGES_DENIED);
    }
    public void setChargePrivilegesDenied(boolean flag) {
      this.set(CHARGE_PRIVILEGES_DENIED);
    }
    public boolean isChargePrivilegesDenied() {
      return this.isSet(CHARGE_PRIVILEGES_DENIED);
    }
    public void setChargePrivilegesDenied(boolean flag) {
      this.set(CHARGE_PRIVILEGES_DENIED);
    }
    public boolean isChargePrivilegesDenied() {
      return this.isSet(CHARGE_PRIVILEGES_DENIED);
    }
    public void setChargePrivilegesDenied(boolean flag) {
      this.set(CHARGE_PRIVILEGES_DENIED);
    }
    public boolean isChargePrivilegesDenied() {
      return this.isSet(CHARGE_PRIVILEGES_DENIED);
    }
    public void setChargePrivilegesDenied(boolean flag) {
      this.set(CHARGE_PRIVILEGES_DENIED);
    }
**/    

    @Override
    protected int getLength() {
        return 14;
    }

    @Override
    protected char[] getValid() {
        return new char[] { ' ', 'Y' };
    }

    public static void main(String[] args) {
        PatronStatus test = new PatronStatus("");

        System.out.println("*012345678901234567890*");
        System.out.println("*" + test.toString() + "*");
        test.set(PatronStatus.TOO_MANY_ITEMS_BILLED);
        test.set(PatronStatus.CARD_REPORTED_LOST);
        System.out.println("*" + test.toString() + "*");
        test.unset(PatronStatus.CARD_REPORTED_LOST);
        System.out.println("*" + test.toString() + "*");
    }

}

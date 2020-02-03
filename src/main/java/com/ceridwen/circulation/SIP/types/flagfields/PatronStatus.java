/* 
 * Copyright (C) 2020 Ceridwen Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ceridwen.circulation.SIP.types.flagfields;

public class PatronStatus extends AbstractFlagField {
    private static final long serialVersionUID = -1160351918609471912L;
    
    private static final int CHARGE_PRIVILEGES_DENIED = 0;
    private static final int RENEWAL_PRIVILIGES_DENIED = 1;
    private static final int RECALL_PRIVILIGES_DENIED = 2;
    private static final int HOLD_PRIVILIGES_DENIED = 3;
    private static final int CARD_REPORTED_LOST = 4;
    private static final int TOO_MANY_ITEMS_CHARGED = 5;
    private static final int TOO_MANY_ITEMS_OVERDUE = 6;
    private static final int TOO_MANY_RENEWALS = 7;
    private static final int TOO_MANY_CLAIMS_OF_ITEMS_RETURNED = 8;
    private static final int TOO_MANY_ITEMS_LOST = 9;
    private static final int EXCESSIVE_OUTSTANDING_FINES = 10;
    private static final int EXCESSIVE_OUTSTANDING_FEES = 11;
    private static final int RECALL_OVERDUE = 12;
    private static final int TOO_MANY_ITEMS_BILLED = 13;

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
      this.set(CHARGE_PRIVILEGES_DENIED, flag);
    }
    public boolean isRenewalPrivilegesDenied() {
      return this.isSet(RENEWAL_PRIVILIGES_DENIED);
    }
    public void setRenewalPrivilegesDenied(boolean flag) {
      this.set(RENEWAL_PRIVILIGES_DENIED, flag);
    }
    public boolean isRecallPrivilegesDenied() {
      return this.isSet(RECALL_PRIVILIGES_DENIED);
    }
    public void setRecallPrivilegesDenied(boolean flag) {
      this.set(RECALL_PRIVILIGES_DENIED, flag);
    }
    public boolean isHoldPrivilegesDenied() {
      return this.isSet(HOLD_PRIVILIGES_DENIED);
    }
    public void setHoldPrivilegesDenied(boolean flag) {
      this.set(HOLD_PRIVILIGES_DENIED, flag);
    }
    public boolean isCardReportedLost() {
      return this.isSet(CARD_REPORTED_LOST);
    }
    public void setCardReportedLost(boolean flag) {
      this.set(CARD_REPORTED_LOST, flag);
    }
    public boolean isTooManyItemsCharged() {
      return this.isSet(TOO_MANY_ITEMS_CHARGED);
    }
    public void setTooManyItemsCharged(boolean flag) {
      this.set(TOO_MANY_ITEMS_CHARGED, flag);
    }
   public boolean isTooManyItemsOverdue() {
      return this.isSet(TOO_MANY_ITEMS_OVERDUE);
    }
    public void setTooManyItemsOverdue(boolean flag) {
      this.set(TOO_MANY_ITEMS_OVERDUE, flag);
    }
    public boolean isTooManyRenewals() {
      return this.isSet(TOO_MANY_RENEWALS);
    }
    public void setTooManyRenewals(boolean flag) {
      this.set(TOO_MANY_RENEWALS, flag);
    }
    public boolean isTooManyClaimsOfItemsReturned() {
      return this.isSet(TOO_MANY_CLAIMS_OF_ITEMS_RETURNED);
    }
    public void setTooManyClaimsOfItemsReturned(boolean flag) {
      this.set(TOO_MANY_CLAIMS_OF_ITEMS_RETURNED, flag);
    }
    public boolean isTooManyItemsLost() {
      return this.isSet(TOO_MANY_ITEMS_LOST);
    }
    public void setTooManyItemsLost(boolean flag) {
      this.set(TOO_MANY_ITEMS_LOST, flag);
    }
    public boolean isExcessiveOutstandingFines() {
      return this.isSet(EXCESSIVE_OUTSTANDING_FINES);
    }
    public void setExcessiveOutstandingFines(boolean flag) {
      this.set(EXCESSIVE_OUTSTANDING_FINES, flag);
    }
    public boolean isExcessiveOutstandingFees() {
      return this.isSet(EXCESSIVE_OUTSTANDING_FEES);
    }
    public void setExcessiveOutstandingFees(boolean flag) {
      this.set(EXCESSIVE_OUTSTANDING_FEES, flag);
    }
    public boolean isRecallOverdue() {
      return this.isSet(RECALL_OVERDUE);
    }
    public void setRecallOverdue(boolean flag) {
      this.set(RECALL_OVERDUE, flag);
    }
    public boolean isTooManyItemsBilled() {
      return this.isSet(TOO_MANY_ITEMS_BILLED);
    }
    public void setTooManyItemsBilled(boolean flag) {
      this.set(TOO_MANY_ITEMS_BILLED, flag);
    }    

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
        test.setTooManyItemsBilled(true);
        test.setCardReportedLost(true);
        System.out.println("*" + test.toString() + "*");
        test.setCardReportedLost(false);
        System.out.println("*" + test.toString() + "*");
    }

}

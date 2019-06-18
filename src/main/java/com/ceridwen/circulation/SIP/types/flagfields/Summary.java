/* 
 * Copyright (C) 2019 Ceridwen Limited
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

public class Summary extends AbstractFlagField {
    private static final long serialVersionUID = 5874238608719119875L;
    private static final int HOLD_ITEMS = 0;
    private static final int OVERDUE_ITEMS = 1;
    private static final int CHARGED_ITEMS = 2;
    private static final int FINE_ITEMS = 3;
    private static final int RECALL_ITEMS = 4;
    private static final int UNAVAILABLE_HOLDS = 5;
    private static final int FEE_ITEMS = 6;

    public Summary(String flags) {
        super(flags);
    }

    public Summary() {
        super("");
    }
    
    public boolean isHoldItems() {
      return this.isSet(HOLD_ITEMS);
    }
    public void setHoldItems(boolean flag) {
      this.set(HOLD_ITEMS, flag);
    }
    public boolean isOverdueItems() {
      return this.isSet(OVERDUE_ITEMS);
    }
    public void setOverdueItems(boolean flag) {
      this.set(OVERDUE_ITEMS, flag);
    }
    public boolean isChargedItems() {
      return this.isSet(CHARGED_ITEMS);
    }
    public void setChargedItems(boolean flag) {
      this.set(CHARGED_ITEMS, flag);
    }
    public boolean isFineItems() {
      return this.isSet(FINE_ITEMS);
    }
    public void setFineItems(boolean flag) {
      this.set(FINE_ITEMS, flag);
    }
    public boolean isRecallItems() {
      return this.isSet(RECALL_ITEMS);
    }
    public void setRecallItems(boolean flag) {
      this.set(RECALL_ITEMS, flag);
    }
    public boolean isUnavaibleHolds() {
      return this.isSet(UNAVAILABLE_HOLDS);
    }
    public void setUnavaibleHolds(boolean flag) {
      this.set(UNAVAILABLE_HOLDS, flag);
    }
    public boolean isFeeItems() {
      return this.isSet(FEE_ITEMS);
    }
    public void setFeeItems(boolean flag) {
      this.set(FEE_ITEMS, flag);
    }

    @Override
    protected int getLength() {
        return 7;
    }

    @Override
    protected char[] getValid() {
        return new char[] { ' ', 'Y' };
    }

    @Override
    protected void set(int field, boolean flag) {
      if (flag) {
        super.clear();
      }
      super.set(field, flag);
    }

    public static void main(String[] args) {
        Summary test = new Summary("");

        System.out.println("*012345678901234567890*");
        System.out.println("*" + test.toString() + "*");
        test.setFeeItems(true);
        System.out.println("*" + test.toString() + "*");
        test.setRecallItems(true);
        System.out.println("*" + test.toString() + "*");
        test.setRecallItems(false);
        System.out.println("*" + test.toString() + "*");
        test.setRecallItems(true);
        System.out.println("*" + test.toString() + "*");
        test.clear();
        System.out.println("*" + test.toString() + "*");
    }
}

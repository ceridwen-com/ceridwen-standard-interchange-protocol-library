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

	protected int getLength() {
		return 14;
	}

	protected char[] getValid() {
		return new char[]{' ', 'Y'};
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

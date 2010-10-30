package com.ceridwen.circulation.SIP.types.flagfields;

public class PatronStatus extends AbstractFlagField {
	private static final long serialVersionUID = -1160351918609471912L;
	public static final int CHARGEPRIVILEGESDENIED = 0;
	public static final int RENEWALPRIVILIGESDENIED = 1;
	public static final int RECALLPRIVILIGESDENIED = 2;
	public static final int HOLDPRIVILIGESDENIED = 3;
	public static final int CARDREPORTEDLOST = 4;
	public static final int TOOMANYITEMSCHARGED = 5;
	public static final int TOOMANYITEMSOVERDUE = 6;
	public static final int TOOMANYRENEWALS = 7;
	public static final int TOOMANYCLAIMSOFITEMSRETURNED = 8;
	public static final int TOOMANYITEMSLOST = 9;
	public static final int EXCESSIVEOUTSTANDINGFINES = 10;
	public static final int EXCESSIVEOUTSTANDINGFEES = 11;
	public static final int RECALLOVERDUE = 12;
	public static final int TOOMANYITEMSBILLED = 13;
	
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
		test.set(PatronStatus.TOOMANYITEMSBILLED);
		test.set(PatronStatus.CARDREPORTEDLOST);
		System.out.println("*" + test.toString() + "*");
		test.unset(PatronStatus.CARDREPORTEDLOST);
		System.out.println("*" + test.toString() + "*");
	}

}

package com.ceridwen.circulation.SIP.types.flagfields;

public class Summary extends AbstractFlagField {
	private static final long serialVersionUID = 5874238608719119875L;
	public static final int HOLDITEMS  = 0;
	public static final int OVERDUEITEMS = 1;
	public static final int CHARGEDITEMS = 2;
	public static final int FINEITEMS = 3;
	public static final int RECALLITEMS = 4;
	public static final int UNAVAILABLEHOLDS = 5;
	public static final int FEEITEMS = 6;
	public static final int SUMMARIESONLY = -1;
	
	public Summary(String flags) {
		super(flags);
	}

	public Summary() {
		super("");
	}

	protected int getLength() {
		return 7;
	}

	protected char[] getValid() {
		return new char[]{' ', 'Y'};
	}
	
	public void set(int field) {
		this.flags = "";
		if (field < 0) {
			super.unsetAll();
		} else {
			super.set(field);
		}
	}

	public static void main(String[] args) {
		Summary test = new Summary("");
		
		System.out.println("*012345678901234567890*");
		System.out.println("*" + test.toString() + "*");
		test.set(Summary.FEEITEMS);
		test.set(Summary.RECALLITEMS);
		System.out.println("*" + test.toString() + "*");
		test.unset(Summary.RECALLITEMS);
		System.out.println("*" + test.toString() + "*");
		test.set(Summary.RECALLITEMS);
		System.out.println("*" + test.toString() + "*");
		test.set(Summary.SUMMARIESONLY);
		System.out.println("*" + test.toString() + "*");
	}
}

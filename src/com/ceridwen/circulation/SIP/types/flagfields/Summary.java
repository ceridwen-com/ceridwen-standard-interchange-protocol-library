package com.ceridwen.circulation.SIP.types.flagfields;

public class Summary extends AbstractFlagField {
	private static final long serialVersionUID = 5874238608719119875L;
	public static final int HOLD_ITEMS  = 0;
	public static final int OVERDUE_ITEMS = 1;
	public static final int CHARGED_ITEMS = 2;
	public static final int FINE_ITEMS = 3;
	public static final int RECALL_ITEMS = 4;
	public static final int UNAVAILABLE_HOLDS = 5;
	public static final int FEE_ITEMS = 6;
	
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
		super.unsetAll();
		super.set(field);
	}

	public static void main(String[] args) {
		Summary test = new Summary("");
		
		System.out.println("*012345678901234567890*");
		System.out.println("*" + test.toString() + "*");
		test.set(Summary.FEE_ITEMS);
		System.out.println("*" + test.toString() + "*");
		test.set(Summary.RECALL_ITEMS);
		System.out.println("*" + test.toString() + "*");
		test.unset(Summary.RECALL_ITEMS);
		System.out.println("*" + test.toString() + "*");
		test.set(Summary.RECALL_ITEMS);
		System.out.println("*" + test.toString() + "*");
		test.unsetAll();
		System.out.println("*" + test.toString() + "*");
	}
}

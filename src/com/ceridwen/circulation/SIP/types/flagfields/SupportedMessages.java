package com.ceridwen.circulation.SIP.types.flagfields;

public class SupportedMessages extends AbstractFlagField {
	private static final long serialVersionUID = -7794339322282396820L;
	public static final int PATRONSTATUSREQUEST = 0;
	public static final int CHECKOUT = 1;
	public static final int CHECKIN = 2;
	public static final int BLOCKPATRON = 3;
	public static final int SCACSSTATUS = 4;
	public static final int REQUESTSCACSRESENT = 5;
	public static final int LOGIN = 6;
	public static final int PATRONINFORMATION = 7;
	public static final int ENDPATRONSESSION = 8;
	public static final int FEEPAID = 9;
	public static final int ITEMINFORMATION = 10;
	public static final int ITEMSTATUSUPDATE = 11;
	public static final int PATRONENABLE = 12;
	public static final int HOLD = 13;
	public static final int RENEW = 14;
	public static final int RENEWALL = 15;

	public SupportedMessages(String flags) {
		super(flags);
	}
	
	public SupportedMessages() {
		super("");
	}

	protected int getLength() {
		return 16;
	}

	protected char[] getValid() {
		return new char[]{'N', 'Y'};
	}
	
	public static void main(String[] args) {
		SupportedMessages test = new SupportedMessages("");
		
		System.out.println("*012345678901234567890*");
		System.out.println("*" + test.toString() + "*");
		test.set(SupportedMessages.RENEWALL);
		test.set(SupportedMessages.LOGIN);
		System.out.println("*" + test.toString() + "*");
		test.unset(SupportedMessages.LOGIN);
		System.out.println("*" + test.toString() + "*");
	}
}

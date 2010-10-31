package com.ceridwen.circulation.SIP.tests;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(CheckOutResponseTest.class);
		suite.addTestSuite(EndSessionResponseTest.class);
		suite.addTestSuite(PatronStatusResponseTest.class);
		suite.addTestSuite(ItemStatusUpdateResponseTest.class);
		suite.addTestSuite(PatronEnableResponseTest.class);
		suite.addTestSuite(CheckOutTest.class);
		suite.addTestSuite(PatronInformationResponseTest.class);
		suite.addTestSuite(HoldResponseTest.class);
		suite.addTestSuite(FeePaidTest.class);
		suite.addTestSuite(RenewAllTest.class);
		suite.addTestSuite(SCStatusTest.class);
		suite.addTestSuite(CheckInResponseTest.class);
		suite.addTestSuite(ItemInformationTest.class);
		suite.addTestSuite(RenewAllResponseTest.class);
		suite.addTestSuite(PatronInformationTest.class);
		suite.addTestSuite(LoginResponseTest.class);
		suite.addTestSuite(ItemStatusUpdateTest.class);
		suite.addTestSuite(ItemInformationResponseTest.class);
		suite.addTestSuite(BlockPatronTest.class);
		suite.addTestSuite(RenewResponseTest.class);
		suite.addTestSuite(FeePaidResponseTest.class);
		suite.addTestSuite(SCResendTest.class);
		suite.addTestSuite(PatronEnableTest.class);
		suite.addTestSuite(RenewTest.class);
		suite.addTestSuite(ACSResendTest.class);
		suite.addTestSuite(HoldTest.class);
		suite.addTestSuite(LoginTest.class);
		suite.addTestSuite(EndPatronSessionTest.class);
		suite.addTestSuite(PatronStatusRequestTest.class);
		suite.addTestSuite(ACSStatusTest.class);
		suite.addTestSuite(CheckInTest.class);
		//$JUnit-END$
		return suite;
	}

}

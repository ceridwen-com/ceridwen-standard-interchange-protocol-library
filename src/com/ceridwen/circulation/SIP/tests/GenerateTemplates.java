package com.ceridwen.circulation.SIP.tests;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class GenerateTemplates {

	static String template = "" +
"package com.ceridwen.circulation.SIP.tests;\r\n" +
"\r\n" +
"import com.ceridwen.circulation.SIP.messages.%1$s;\r\n" +
"import com.ceridwen.circulation.SIP.messages.Message;\r\n" +
"\r\n" +
"public class %1$sTest extends AbstractMessageTest<%1$s> {\r\n" +
"\r\n" +
"	@Override\r\n" +
"	public Message getMessage() {\r\n" +
"		%1$s m = new %1$s();\r\n" +
"\r\n" +
"		return m;\r\n" +
"	}\r\n" +
"\r\n" +
"	@Override\r\n" +
"	public String getEncoding() {\r\n" +
"		return \"\";\r\n" +
"	}\r\n" +
"}\r\n";

	static String cl[] = {
			"ACSResend",
			"ACSStatus",
			"BlockPatron",
			"CheckIn",
			"CheckInResponse",
			"CheckOut",
			"CheckOutResponse",
			"EndPatronSession",
			"EndSessionResponse",
			"FeePaid",
			"FeePaidResponse",
			"Hold",
			"HoldResponse",
			"ItemInformation",
			"ItemInformationResponse",
			"ItemStatusUpdate",
			"ItemStatusUpdateResponse",
			"Login",
			"LoginResponse",
			"PatronEnable",
			"PatronEnableResponse",
			"PatronInformation",
			"PatronInformationResponse",
			"PatronStatusRequest",
			"PatronStatusResponse",
			"Renew",
			"RenewAll",
			"RenewAllBeanInfo",
			"RenewAllResponse",
			"RenewResponse",
			"SCResend",
			"SCStatus"
	};
	
	public static void main(String[] args) {
		FileOutputStream out; // declare a file output object
        PrintStream p; // declare a print stream object

		for (String c: cl) {
		       try
		        {
		                // Create a new file output stream
		                // connected to "myfile.txt"
		                out = new FileOutputStream("c:/temp/" + c + "Test.java");

		                // Connect print stream to the output stream

		    			p = new PrintStream( out );

		                p.println (String.format(template, c));

		                p.close();
		                out.close();
		        }
		        catch (Exception e)
		        {
		        	e.printStackTrace();
		                System.err.println ("Error writing to file");
		        }
		}
	}

}

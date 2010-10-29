package com.ceridwen.circulation.SIP;

import com.ceridwen.circulation.SIP.exceptions.ChecksumError;
import com.ceridwen.circulation.SIP.exceptions.MandatoryFieldOmitted;
import com.ceridwen.circulation.SIP.exceptions.SequenceError;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.messages.PatronInformationResponse;

public class testmessages {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		PatronInformationResponse test = new PatronInformationResponse();
		
		test.setEMailAddress("test@test");
		test.setLanguage("ENG");
		test.setHoldItems(new String[]{"Test1", "Test2"});
		try {
			String msg = test.encode('A');
			System.out.println(msg);
			Message resp = PatronInformationResponse.decode(msg, 'A', true);
			resp.xmlEncode(System.out);
			
			
			
		} catch (MandatoryFieldOmitted e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ChecksumError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SequenceError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}

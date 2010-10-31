package com.ceridwen.circulation.SIP;

import com.ceridwen.circulation.SIP.exceptions.ChecksumError;
import com.ceridwen.circulation.SIP.exceptions.MandatoryFieldOmitted;
import com.ceridwen.circulation.SIP.exceptions.MessageNotUnderstood;
import com.ceridwen.circulation.SIP.exceptions.SequenceError;
import com.ceridwen.circulation.SIP.messages.CheckOutResponse;
import com.ceridwen.circulation.SIP.messages.Message;

public class testmessages {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		CheckOutResponse test = new CheckOutResponse();
				
//		test.setEMailAddress("test@test");
//		test.getSupportedMessages().set(SupportedMessages.LOGIN);
//		test.setCurrencyType(CurrencyType.UK_POUNDS); 
//		test.setHoldItems(new String[]{"Test1", "Test2"});
		try {
			String msg = test.encode('0');
			System.out.println(msg);
			test.xmlEncode(System.out);
			Message resp = Message.decode(msg, '0', true);
			System.out.println(((CheckOutResponse)resp).getCurrencyType());
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
		} catch (MessageNotUnderstood e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}

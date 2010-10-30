package com.ceridwen.circulation.SIP.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.ceridwen.circulation.SIP.exceptions.MandatoryFieldOmitted;
import com.ceridwen.circulation.SIP.messages.ACSResend;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.messages.SCResend;

public class MessageBroker {
	private MessageHandler handler;
	private boolean strictChecksumChecking = false;
	private Message lastMessage;
	  	
	public MessageBroker(MessageHandler handler)
	{
		this.handler = handler;
	}
	public void setStrictChecksumChecking(boolean flag) {
	  this.strictChecksumChecking = flag;
	}
	public boolean getStrictChecksumChecking() {
	  return this.strictChecksumChecking;
	}
	
	public Message process(Message request) {
		Class<MessageHandler> handlerInterface = MessageHandler.class;
		
		Method[] handlerMethods = handlerInterface.getMethods();
		
		for (int i=0; i<handlerMethods.length; i++) {			
			Class<?> types[] = handlerMethods[i].getParameterTypes();
			if (types.length == 1) {
				if (request.getClass() == types[0]) {
					try {
						return (Message)handlerMethods[i].invoke(handler, new Object[]{request});
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}				
			}
		}		
		return null;
	}
	
	public String process(String request) {
		try {
			Message requestMessage = Message.decode(request, null, this.strictChecksumChecking); 
			if (!(requestMessage instanceof ACSResend)) {
				lastMessage = requestMessage;
			}
			return process(lastMessage).encode(lastMessage.getSequenceCharacter());
		} catch (Exception e) {
			e.printStackTrace();
			try {
				return new SCResend().encode(null); // Do a resend properly
			} catch (MandatoryFieldOmitted e1) {
				return "96AZFEF6"; // if all else fails hardcode!
			}
		}
	}		
}

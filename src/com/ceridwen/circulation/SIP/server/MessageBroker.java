package com.ceridwen.circulation.SIP.server;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceridwen.circulation.SIP.exceptions.MandatoryFieldOmitted;
import com.ceridwen.circulation.SIP.messages.ACSResend;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.messages.SCResend;

public class MessageBroker {
	private static Log logger = LogFactory.getLog(MessageBroker.class);
	
	private MessageHandler handler;
	private boolean strictChecksumChecking = false;
	private Message lastResponse;
	  	
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
	
	public Message process(Message request) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		Class<MessageHandler> handlerInterface = MessageHandler.class;
		
		Method[] handlerMethods = handlerInterface.getMethods();
		
		for (int i=0; i<handlerMethods.length; i++) {			
			Class<?> types[] = handlerMethods[i].getParameterTypes();
			if (types.length == 1) {
				if (request.getClass() == types[0]) {
					return (Message)handlerMethods[i].invoke(handler, new Object[]{request});
				}				
			}
		}		
		return null;
	}
	
	public String process(String request) {
		try {
			logger.info("Processing message: " + request);
			Message requestMessage = Message.decode(request, null, this.strictChecksumChecking); 
			if (requestMessage instanceof ACSResend) {
				logger.info("Resending response");
			} else {
				lastResponse = process(requestMessage);
			}
			String response = lastResponse.encode(requestMessage.getSequenceCharacter());
			logger.info("Sending response: " + response);
			return response;
		} catch (Exception e) {
			logger.warn("Error trying to process message: " + request, e);
			try {
				return new SCResend().encode(null); // Do a resend properly
			} catch (MandatoryFieldOmitted e1) {
				logger.error("Error creating SCResend message", e);
				return "96AZFEF6"; // if all else fails hardcode!
			}
		}
	}		
}

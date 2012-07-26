package com.ceridwen.circulation.SIP.transport;

import static org.junit.Assert.*;

import java.util.Date;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.ceridwen.circulation.SIP.exceptions.ChecksumError;
import com.ceridwen.circulation.SIP.exceptions.ConnectionFailure;
import com.ceridwen.circulation.SIP.exceptions.InvalidFieldLength;
import com.ceridwen.circulation.SIP.exceptions.MandatoryFieldOmitted;
import com.ceridwen.circulation.SIP.exceptions.MessageNotUnderstood;
import com.ceridwen.circulation.SIP.exceptions.RetriesExceeded;
import com.ceridwen.circulation.SIP.exceptions.SequenceError;
import com.ceridwen.circulation.SIP.messages.ACSStatus;
import com.ceridwen.circulation.SIP.messages.CheckOut;
import com.ceridwen.circulation.SIP.messages.CheckOutResponse;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.messages.SCStatus;
import com.ceridwen.circulation.SIP.server.MessageHandlerDummyImpl;
import com.ceridwen.circulation.SIP.server.SocketDaemon;
import com.ceridwen.circulation.SIP.types.enumerations.ProtocolVersion;
import com.ceridwen.circulation.SIP.types.flagfields.SupportedMessages;

public class TestSocketTransport {
    static SocketDaemon thread;

	
	@Before
	public void setUp() throws Exception {
        /**
         * Run simple socket server
         */

		TestSocketTransport.thread = new SocketDaemon("localhost", 12345, new MessageHandlerDummyImpl());
		TestSocketTransport.thread.setStrictChecksumChecking(true);
		TestSocketTransport.thread.start();		
	}

	@After
	public void tearDown() throws Exception {
        /**
         * Stop simple socket server
         */

		TestSocketTransport.thread.shutdown();		
	}

	@Test
	public void test() {
        /**
         * Now try basic client commands
         */
        Connection connection;
        Message request, response;

        connection = new SocketConnection();
        ((SocketConnection) connection).setHost("localhost");
        ((SocketConnection) connection).setPort(12345);
        ((SocketConnection) connection).setConnectionTimeout(30000);
        ((SocketConnection) connection).setIdleTimeout(30000);
        ((SocketConnection) connection).setRetryAttempts(2);
        ((SocketConnection) connection).setRetryWait(500);

        try {
            connection.connect();
        } catch (Exception e1) {
        	fail("Connection failed: " + e1.getMessage());
        	return;
        }

        /**
         * It is necessary to send a SC Status with protocol version 2.0 else
         * server will assume 1.0)
         */

        request = new SCStatus();
        ((SCStatus) request).setProtocolVersion(ProtocolVersion.VERSION_2_00);

        try {
            response = connection.send(request);
        } catch (RetriesExceeded e) {
        	Assert.fail("Retries exceeded: " + e.getMessage());
        	return;
        } catch (ConnectionFailure e) {
        	Assert.fail("Connection failure: " + e.getMessage());
        	return;
        } catch (MessageNotUnderstood e) {
        	Assert.fail("Message not understood: " + e.getMessage());
        	return;
        } catch (ChecksumError e) {
        	Assert.fail("Checksum error: " + e.getMessage());
        	return;
        } catch (SequenceError e) {
        	Assert.fail("Sequence error: " + e.getMessage());
        	return;
        } catch (MandatoryFieldOmitted e) {
        	Assert.fail("Mandatory Field Omitted: " + e.getMessage());
        	return;
        } catch (InvalidFieldLength e) {
        	Assert.fail("Invalid field length: " + e.getMessage());
        	return;
        }
        
        if (!(response instanceof ACSStatus)) {
            fail("Status Request did not return valid response from server.");
        	return;
        }


        /**
         * Check if the server can support checkout
         */
        if (!((ACSStatus) response).getSupportedMessages().isSet(SupportedMessages.CHECK_OUT)) {
        	fail("Check out not supported");
        	return;
        }

        request = new CheckOut();

        /**
         * The code below would be the normal way of creating the request
         */

        ((CheckOut) request).setPatronIdentifier("2000000");
        ((CheckOut) request).setItemIdentifier("300000000");
        ((CheckOut) request).setSCRenewalPolicy(Boolean.TRUE);
        ((CheckOut) request).setTransactionDate(new Date());

        try {
            response = connection.send(request);
        } catch (RetriesExceeded e) {
        	fail("Retries exceeded: " + e.getMessage());
        	return;
        } catch (ConnectionFailure e) {
        	fail("Connection failure: " + e.getMessage());
        	return;
        } catch (MessageNotUnderstood e) {
        	fail("Message not understood: " + e.getMessage());
        	return;
        } catch (ChecksumError e) {
        	fail("Checksum error: " + e.getMessage());
        	return;
        } catch (SequenceError e) {
        	fail("Sequence error: " + e.getMessage());
        	return;
        } catch (MandatoryFieldOmitted e) {
        	fail("Mandatory Field Omitted: " + e.getMessage());
        	return;
        } catch (InvalidFieldLength e) {
        	fail("Invalid field length: " + e.getMessage());
        	return;
        }

        if (!(response instanceof CheckOutResponse)) {
            fail("Error - CheckOut Request did not return valid response from server");
        	return;
        }
        
        try {
        	String testCase = response.encode('1');
        	Assert.assertTrue(testCase.startsWith("120NUN") && testCase.contains("AA|AB|AH|AJ|AO|AY1AZ")); // strip out components which may change (transaction date and checksum)
	    } catch (MessageNotUnderstood e) {
	    	fail("Message not understood: " + e.getMessage());
        	return;
        } catch (MandatoryFieldOmitted e) {
        	fail("Mandatory Field Omitted: " + e.getMessage());
        	return;
	    } catch (InvalidFieldLength e) {
	    	fail("Invalid field length: " + e.getMessage());
        	return;
	    }
	}
}

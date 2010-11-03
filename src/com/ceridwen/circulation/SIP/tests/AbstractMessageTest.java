package com.ceridwen.circulation.SIP.tests;

import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;

import org.junit.Assert;
import org.junit.Test;

import com.ceridwen.circulation.SIP.exceptions.ChecksumError;
import com.ceridwen.circulation.SIP.exceptions.InvalidFieldLength;
import com.ceridwen.circulation.SIP.exceptions.MandatoryFieldOmitted;
import com.ceridwen.circulation.SIP.exceptions.MessageNotUnderstood;
import com.ceridwen.circulation.SIP.exceptions.SequenceError;
import com.ceridwen.circulation.SIP.messages.Message;

public abstract class AbstractMessageTest<MSG extends Message> {
	public abstract Message getDefaultMessage();
	public abstract String getDefaultEncoding();
	public abstract Message getMessage();
	public abstract String getEncoding();
	
	@Test
	public void testEncode() {
		try {
			String t = this.getMessage().encode(null);
			Assert.assertEquals(this.getEncoding(), t);
		} catch (MandatoryFieldOmitted e) {
			fail("Mandatory Field Omitted: " + e.getMessage());
		} catch (InvalidFieldLength e) {
			fail("Field Wrong Size: " + e.getMessage());
		}
	}

	@Test
	public void testDefaultEncode() {
		try {
			String t = this.getDefaultMessage().encode(null);
			Assert.assertEquals(this.getDefaultEncoding(), t);
		} catch (MandatoryFieldOmitted e) {
			fail("Mandatory Field Omitted: " + e.getMessage());
		} catch (InvalidFieldLength e) {
			fail("Fixed Field Too Long: " + e.getMessage());
		}
	}

	@Test
	public void testDecode() {
		try {
			ByteArrayOutputStream stream = new ByteArrayOutputStream();
			Message m = MSG.decode(this.getEncoding(), null, false);
			m.xmlEncode(stream);
			String r = stream.toString();
			stream = new ByteArrayOutputStream();
			m = this.getMessage();
			m.xmlEncode(stream);
			String t = stream.toString();
			Assert.assertEquals(t, r);
		} catch (MandatoryFieldOmitted e) {
			fail("Mandatory Field Omitted");
		} catch (ChecksumError e) {
			fail("Checksum Error");
		} catch (SequenceError e) {
			fail("Sequence Error");
		} catch (MessageNotUnderstood e) {
			fail("Message Not Understood");
		}
	}
	
	@Test
	public void testRoundTrip() {
		try {
			String t = this.getMessage().encode('0');
			Message m;
			m = MSG.decode(t, '0', true);
			Assert.assertEquals(t, m.encode('0'));
		} catch (MandatoryFieldOmitted e) {
			fail("Mandatory Field Omitted: " + e.getMessage());
		} catch (InvalidFieldLength e) {
			fail("Fixed Field Too Long: " + e.getMessage());
		} catch (ChecksumError e) {
			fail("Checksum Error");
		} catch (SequenceError e) {
			fail("Sequence Error");
		} catch (MessageNotUnderstood e) {
			fail("Message Not Understood");
		}
	}
}
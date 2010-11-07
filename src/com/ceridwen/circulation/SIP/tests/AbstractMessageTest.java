/*******************************************************************************
 * Copyright (c) 2010 Matthew J. Dovey (www.ceridwen.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at 
 * <http://www.gnu.org/licenses/>
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Contributors:
 *     Matthew J. Dovey (www.ceridwen.com) - initial API and implementation
 ******************************************************************************/
package com.ceridwen.circulation.SIP.tests;

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
            Assert.fail("Mandatory Field Omitted: " + e.getMessage());
        } catch (InvalidFieldLength e) {
            Assert.fail("Field Wrong Size: " + e.getMessage());
        }
    }

    @Test
    public void testDefaultEncode() {
        try {
            String t = this.getDefaultMessage().encode(null);
            Assert.assertEquals(this.getDefaultEncoding(), t);
        } catch (MandatoryFieldOmitted e) {
            Assert.fail("Mandatory Field Omitted: " + e.getMessage());
        } catch (InvalidFieldLength e) {
            Assert.fail("Fixed Field Too Long: " + e.getMessage());
        }
    }

    @Test
    public void testDecode() {
        try {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            Message m = Message.decode(this.getEncoding(), null, false);
            m.xmlEncode(stream);
            String r = stream.toString();
            stream = new ByteArrayOutputStream();
            m = this.getMessage();
            m.xmlEncode(stream);
            String t = stream.toString();
            Assert.assertEquals(t, r);
        } catch (MandatoryFieldOmitted e) {
            Assert.fail("Mandatory Field Omitted");
        } catch (ChecksumError e) {
            Assert.fail("Checksum Error");
        } catch (SequenceError e) {
            Assert.fail("Sequence Error");
        } catch (MessageNotUnderstood e) {
            Assert.fail("Message Not Understood");
        }
    }

    @Test
    public void testRoundTrip() {
        try {
            String t = this.getMessage().encode('0');
            Message m;
            m = Message.decode(t, '0', true);
            Assert.assertEquals(t, m.encode('0'));
        } catch (MandatoryFieldOmitted e) {
            Assert.fail("Mandatory Field Omitted: " + e.getMessage());
        } catch (InvalidFieldLength e) {
            Assert.fail("Fixed Field Too Long: " + e.getMessage());
        } catch (ChecksumError e) {
            Assert.fail("Checksum Error");
        } catch (SequenceError e) {
            Assert.fail("Sequence Error");
        } catch (MessageNotUnderstood e) {
            Assert.fail("Message Not Understood");
        }
    }
}

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
package com.ceridwen.circulation.SIP.samples;

import java.util.Date;

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
import com.ceridwen.circulation.SIP.transport.Connection;
import com.ceridwen.circulation.SIP.transport.SocketConnection;
import com.ceridwen.circulation.SIP.types.enumerations.ProtocolVersion;
import com.ceridwen.circulation.SIP.types.flagfields.SupportedMessages;

/**
 * <p>Title: </p>
 * 
 * <p>Description: </p>
 * 
 * <p>Copyright: Copyright (c) 2004</p>
 * 
 * <p>Company: </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class Sample {
    static SocketDaemon thread;
    

    public static void startServer() {
        /**
         * Run simple socket server
         */

        Sample.thread = new SocketDaemon("localhost", 12345, new MessageHandlerDummyImpl());
        Sample.thread.setStrictChecksumChecking(true);
        Sample.thread.start();
    }

    public static void checkOut() {
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
            e1.printStackTrace();
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
            e.printStackTrace();
            return;
        } catch (ConnectionFailure e) {
            e.printStackTrace();
            return;
        } catch (MessageNotUnderstood e) {
            e.printStackTrace();
            return;
        } catch (ChecksumError e) {
            e.printStackTrace();
            return;
        } catch (SequenceError e) {
            e.printStackTrace();
            return;
        } catch (MandatoryFieldOmitted e) {
            e.printStackTrace();
            return;
        } catch (InvalidFieldLength e) {
            e.printStackTrace();
            return;
        }

        if (!(response instanceof ACSStatus)) {
            System.err.println("Error - Status Request did not return valid response from server.");
            return;
        }

        /**
         * For debugging XML handling code (but could be useful in Cocoon)
         */
        response.xmlEncode(System.out);

        /**
         * Check if the server can support checkout
         */
        if (!((ACSStatus) response).getSupportedMessages().isSet(SupportedMessages.CHECK_OUT)) {
            System.out.println("Check out not supported");
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
            e.printStackTrace();
            return;
        } catch (ConnectionFailure e) {
            e.printStackTrace();
            return;
        } catch (MessageNotUnderstood e) {
            e.printStackTrace();
            return;
        } catch (ChecksumError e) {
            e.printStackTrace();
            return;
        } catch (SequenceError e) {
            e.printStackTrace();
            return;
        } catch (MandatoryFieldOmitted e) {
            e.printStackTrace();
            return;
        } catch (InvalidFieldLength e) {
            e.printStackTrace();
            return;
        }

        if (!(response instanceof CheckOutResponse)) {
            System.err.println("Error - CheckOut Request did not return valid response from server");
            return;
        }
        response.xmlEncode(System.out);

        // System.out.println(((PatronInformationResponse)response).getPersonalName());
        // System.out.println(((PatronInformationResponse)response).getEMailAddress());

        connection.disconnect();
    }

    public static void stopServer() {
        /**
         * Stop simple socket server
         */

        Sample.thread.shutdown();
    }

    public static void main(String[] args) {
        System.setProperty("com.ceridwen.circulation.SIP.charset", "ISO8859_1");

        Sample.startServer();
        Sample.checkOut();
        Sample.stopServer();

    }
}

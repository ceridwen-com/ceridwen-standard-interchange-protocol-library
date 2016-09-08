/**
 * *****************************************************************************
 * Copyright (c) 2010 Matthew J. Dovey (www.ceridwen.com).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * <http://www.gnu.org/licenses/>
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * Contributors: Matthew J. Dovey (www.ceridwen.com) - initial API and
 * implementation
 * ****************************************************************************
 */
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
import com.ceridwen.circulation.SIP.netty.server.SIPDaemon;
import com.ceridwen.circulation.SIP.samples.netty.DummyDriverFactory;
import com.ceridwen.circulation.SIP.transport.SSLSocketConnection;
import com.ceridwen.circulation.SIP.transport.SocketConnection;
import com.ceridwen.circulation.SIP.types.enumerations.ProtocolVersion;
import com.ceridwen.circulation.SIP.types.flagfields.SupportedMessages;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sample {
  
  private static final boolean SSL = false;
  private static SelfSignedCertificate ssc;
  
  public static void main(String[] args) {
    try {
      System.setProperty("com.ceridwen.circulation.SIP.charset", "ISO8859_1");

      SIPDaemon server;

      // Run netty server
      if (SSL) {
        ssc = new SelfSignedCertificate();
        server = new SIPDaemon("Sample", "localhost", 12345, ssc.certificate(), ssc.privateKey(), new DummyDriverFactory(), true);
      } else {
        server = new SIPDaemon("Sample", "localhost", 12345, new DummyDriverFactory(), true);
      }
      server.start();

      // Do sample checkout
      Sample.checkOut();

      // Shut down netty server
      server.stop();
    } catch (Exception ex) {
      Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
    }
  }

  public static void checkOut() {
    /**
     * Now try basic client commands
     */
    SocketConnection connection;

    if (SSL) {
      connection = new SSLSocketConnection();
      ((SSLSocketConnection) connection).setServerCertificateCA(ssc.certificate());
    } else {
      connection = new SocketConnection();
    }
    connection.setHost("localhost");
    connection.setPort(12345);
    connection.setConnectionTimeout(30000);
    connection.setIdleTimeout(30000);
    connection.setRetryAttempts(2);
    connection.setRetryWait(500);

    try {
      connection.connect();
    } catch (Exception ex) {
      Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
      return;
    }

    /**
     * It is necessary to send a SC Status with protocol version 2.0 else server
     * will assume 1.0)
     */
    SCStatus scStatusRequest = new SCStatus();
    scStatusRequest.setProtocolVersion(ProtocolVersion.VERSION_2_00);

    Message scStatusResponse;

    try {
      scStatusResponse = connection.send(scStatusRequest);
    } catch (RetriesExceeded | ConnectionFailure | MessageNotUnderstood | ChecksumError | SequenceError | MandatoryFieldOmitted | InvalidFieldLength ex) {
      Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
      return;
    }

    if (!(scStatusResponse instanceof ACSStatus)) {
      Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, "Error - Status Request did not return valid response from server.");
      return;
    }

    /**
     * For debugging XML handling code (but could be useful in Cocoon)
     */
    scStatusResponse.xmlEncode(System.out);

    /**
     * Check if the server can support checkout
     */
    if (!((ACSStatus) scStatusResponse).getSupportedMessages().isSet(SupportedMessages.CHECK_OUT)) {
      Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, "Check out not supported");
      return;
    }

    CheckOut checkOutRequest = new CheckOut();

    /**
     * Now try a checkout request
     */
    checkOutRequest.setPatronIdentifier("2000000");
    checkOutRequest.setItemIdentifier("300000000");
    checkOutRequest.setSCRenewalPolicy(Boolean.TRUE);
    checkOutRequest.setTransactionDate(new Date());

    Message checkOutResponse;

    try {
      checkOutResponse = connection.send(checkOutRequest);
    } catch (RetriesExceeded | ConnectionFailure | MessageNotUnderstood | ChecksumError | SequenceError | MandatoryFieldOmitted | InvalidFieldLength ex) {
      Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, null, ex);
      return;
    }

    if (!(checkOutResponse instanceof CheckOutResponse)) {
      Logger.getLogger(Sample.class.getName()).log(Level.SEVERE, "Error - CheckOut Request did not return valid response from server");
      return;
    }
    checkOutResponse.xmlEncode(System.out);

    connection.disconnect();
  }

}

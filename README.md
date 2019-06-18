# Ceridwen 3M SIP Circulation Library for Java

3M SIP is an industry standard protocol by 3M to allow automatec check out terminals communicate with library systems.

The Ceridwen 3M SIP Circulation Library for Java is an Open Source (GPL v3) implementation of the 3M SIP version 2 protocol (also known as SIP2). It includes both client and server implementations and support both telnet and socket based communications.

### Problems and Issues

For general problems please contact [development@ceridwen.com](mailto:development@ceridwen.com). For bugs and feature requests, please use our [online issue tracker]().

### License

The Ceridwen Self Issue Client is available as open source under [GPL v3](http://www.gnu.org/licenses/gpl.html). Contact [development@ceridwen.com](mailto:development@ceridwen.com) for other licensing options.

### Sample Application

The following hava code demonstrates the use of the library. It starts up a simple server implementation, and then uses the client API to check out a book.

```java
public class Sample {

  public static void main(String[] args) {
    try {
      System.setProperty("com.ceridwen.circulation.SIP.charset", "ISO8859_1");

      SIPDaemon server;

      // Run netty server
      server = new SIPDaemon("Sample", "localhost", 12345, false, new DummyDriverFactory(), true);
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

    connection = new SocketConnection();
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
```

------

Copyright (C) 2019 Ceridwen Limited

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
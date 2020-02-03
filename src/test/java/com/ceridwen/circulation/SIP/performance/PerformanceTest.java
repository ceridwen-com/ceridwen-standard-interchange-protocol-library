/* 
 * Copyright (C) 2020 Ceridwen Limited
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.ceridwen.circulation.SIP.performance;

import com.ceridwen.circulation.SIP.exceptions.ChecksumError;
import com.ceridwen.circulation.SIP.exceptions.InvalidFieldLength;
import com.ceridwen.circulation.SIP.exceptions.MandatoryFieldOmitted;
import com.ceridwen.circulation.SIP.exceptions.MessageNotUnderstood;
import com.ceridwen.circulation.SIP.exceptions.RetriesExceeded;
import com.ceridwen.circulation.SIP.exceptions.SequenceError;
import com.ceridwen.circulation.SIP.messages.ACSStatus;
import com.ceridwen.circulation.SIP.messages.BlockPatron;
import com.ceridwen.circulation.SIP.messages.CheckIn;
import com.ceridwen.circulation.SIP.messages.CheckOut;
import com.ceridwen.circulation.SIP.messages.EndPatronSession;
import com.ceridwen.circulation.SIP.messages.FeePaid;
import com.ceridwen.circulation.SIP.messages.Hold;
import com.ceridwen.circulation.SIP.messages.ItemInformation;
import com.ceridwen.circulation.SIP.messages.ItemStatusUpdate;
import com.ceridwen.circulation.SIP.messages.Login;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.messages.PatronEnable;
import com.ceridwen.circulation.SIP.messages.PatronInformation;
import com.ceridwen.circulation.SIP.messages.PatronStatusRequest;
import com.ceridwen.circulation.SIP.messages.Renew;
import com.ceridwen.circulation.SIP.messages.RenewAll;
import com.ceridwen.circulation.SIP.messages.SCStatus;
import com.ceridwen.circulation.SIP.netty.server.SIPDaemon;
import com.ceridwen.circulation.SIP.samples.netty.DummyDriverFactory;
import com.ceridwen.circulation.SIP.transport.SSLSocketConnection;
import com.ceridwen.circulation.SIP.transport.SocketConnection;
import com.ceridwen.circulation.SIP.types.enumerations.ProtocolVersion;
import io.netty.handler.ssl.util.SelfSignedCertificate;
import java.io.File;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

class ThreadCounter {
  private int count;
  private int error;
  private int retries;

  ThreadCounter() {
    this.count = 0;
    this.error = 0;
    this.retries = 0;
  }
  
  synchronized void Enter() {
    count++;
  }
  
  synchronized void Leave() {
    count--;
  }

  synchronized void Error(Exception ex, String type) {
    error++;
    this.Leave();
  }

  synchronized void Retried() {
    retries++;
    this.Leave();
  }
  
  int getCount() {
    return count;
  }

  int getError() {
    return error;
  }
  
  int getRetries() {
    return retries;
  }
}

class ClientRunner extends Thread {
  File cert = null;
  Message msg;
  ThreadCounter counter;
  
  public ClientRunner(Message msg, File cert, ThreadCounter counter) {
    this.cert = cert;
    this.msg = msg;
    this.counter = counter;
  }

  @Override
  public void run() {
    counter.Enter();
    SocketConnection connection;

    if (cert != null) {
      connection = new SSLSocketConnection();
      ((SSLSocketConnection) connection).setServerCertificateCA(cert);
    } else {
      connection = new SocketConnection();
    }
    connection.setHost("localhost");
    connection.setPort(12345);
    connection.setConnectionTimeout(30000);
    connection.setIdleTimeout(30000);
    connection.setRetryAttempts(25);
    connection.setRetryWait(500);

    try {
      connection.connect();
    } catch (RetriesExceeded ex) {
      counter.Retried();
      return;
    } catch (Exception ex) {
      counter.Error(ex, "CONNECT");
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
    } catch (RetriesExceeded ex) {
      counter.Retried();
      return;
    } catch (MessageNotUnderstood | ChecksumError | SequenceError | MandatoryFieldOmitted | InvalidFieldLength ex1) {
      counter.Error(ex1, "STATUS");
      return;
    }

    if (!(scStatusResponse instanceof ACSStatus)) {
      counter.Error(new Exception("Invalid Status Response"), "STATUSCHECK");
      return;
    }

    Message response;
    
    try {
      response = connection.send(msg);
    } catch (RetriesExceeded ex) {
      counter.Retried();
      return;
    } catch (MessageNotUnderstood | ChecksumError | SequenceError | MandatoryFieldOmitted | InvalidFieldLength ex) {
      counter.Error(ex, "MESSAGE");
      return;
    }

    connection.disconnect();
    counter.Leave();
  }
  


  
}


/**
 *
 * @author Matthew.Dovey
 */
public class PerformanceTest {
  private static final boolean SSL = true;
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
      
      Scanner sc = new Scanner(System.in);
      
      while (true) {
        System.gc();

        System.out.println("***READY");

        boolean pause = true;
        while (sc.hasNextLine() && pause) {
          if (sc.next().startsWith("go")) {
            pause = false;
          }
        }

        System.out.println("***STARTED");

        ThreadCounter count = new ThreadCounter();
        
        for (int i = 0; i <2000; i++) {
          System.out.println("***CLIENT TEST INTERATION: " + i + " - ACTIVE THREADS: " + count.getCount());
          new ClientRunner(new BlockPatron(), ssc == null?null:ssc.certificate(), count).start();
          new ClientRunner(new CheckIn(), ssc == null?null:ssc.certificate(), count).start();
          new ClientRunner(new CheckOut(), ssc == null?null:ssc.certificate(), count).start();
          new ClientRunner(new EndPatronSession(), ssc == null?null:ssc.certificate(), count).start();
          new ClientRunner(new FeePaid(), ssc == null?null:ssc.certificate(), count).start();
          new ClientRunner(new Hold(), ssc == null?null:ssc.certificate(), count).start();
          new ClientRunner(new ItemInformation(), ssc == null?null:ssc.certificate(), count).start();
          new ClientRunner(new ItemStatusUpdate(), ssc == null?null:ssc.certificate(), count).start();
          new ClientRunner(new Login(), ssc == null?null:ssc.certificate(), count).start();
          new ClientRunner(new PatronEnable(), ssc == null?null:ssc.certificate(), count).start();
          new ClientRunner(new PatronInformation(), ssc == null?null:ssc.certificate(), count).start();
          new ClientRunner(new PatronStatusRequest(), ssc == null?null:ssc.certificate(), count).start();
          new ClientRunner(new Renew(), ssc == null?null:ssc.certificate(), count).start();
          new ClientRunner(new RenewAll(), ssc == null?null:ssc.certificate(), count).start();
        }

        System.out.println("***STOPPING");
        while (count.getCount() > 0) {
          System.out.println("***ACTIVE THREADS: " + count.getCount());
          Thread.sleep(1);
        }
        System.out.println("***STOPPED");
        System.out.println("*** THREADS ERRORED: " + count.getError());
        System.out.println("*** THREADS RETRIED: " + count.getRetries());
      }

//      server.stop();


    } catch (Exception ex) {
      Logger.getLogger(PerformanceTest.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
  
}

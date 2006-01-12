package com.ceridwen.circulation.SIP.transport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.ceridwen.circulation.SIP.exceptions.ConnectionFailure;


public class SocketConnection extends Connection {
  private static Log log = LogFactory.getLog(SocketConnection.class);

  private Socket socket;
  private BufferedReader in;
  private BufferedWriter out;

  protected boolean connect(int retryAttempts) {
    try {
      socket = new java.net.Socket();
      socket.connect(new InetSocketAddress(this.getHost(), this.getPort()), this.getConnectionTimeout());
      socket.setSoTimeout(this.getIdleTimeout());
      out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
      in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
      return true;
    }
    catch (Exception ex) {
      if (retryAttempts > 0) {
        try {
          Thread.sleep(this.getRetryWait());
        }
        catch (Exception ex1) {
          log.debug("Thread sleep error", ex1);
        }
        return connect(retryAttempts - 1);
      }
      else {
        return false;
      }
    }
  }

  public boolean isConnected() {
    return socket.isConnected();
  }
  public void disconnect() {
    try {
      socket.close();
    } catch (Exception ex) {

    }
  }

  protected void internalSend(String cmd) throws ConnectionFailure {
    try {
      out.write(cmd);
      out.newLine();
      out.flush();
    }
    catch (Exception ex) {
      throw new ConnectionFailure(ex);
    }
  }

  protected String internalWaitfor(String match) throws ConnectionFailure {
    StringBuffer message = new StringBuffer();
    char buffer[] = new char[2048];
    int len;

    try {
      do {
        len = in.read(buffer);
        message.append(new String(buffer, 0, len));
      }
      while ( (message.toString()).lastIndexOf(match) < 0);
    }
    catch (Exception ex) {
      throw new ConnectionFailure(ex);
    }

    String msg = message.toString();
    int cutoff = msg.lastIndexOf(match);
    String ret = msg.substring(0, cutoff);
    return ret;
  }
}

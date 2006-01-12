package com.ceridwen.circulation.SIP.transport;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.telnet.TelnetClient;
import com.ceridwen.circulation.SIP.exceptions.ConnectionFailure;
import com.ceridwen.util.net.TimeoutSocketFactory;


public class TelnetConnection extends Connection {
  private static Log log = LogFactory.getLog(TelnetConnection.class);

  private String username;
  private String password;
  private String loggedOnText;

  private TelnetClient client = new TelnetClient();
  private BufferedReader in;
  private BufferedWriter out;

  public void setUsername(String username) {
    this.username = username;
  }
  public String getUsername() {
    return username;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public String getPassword() {
    return password;
  }
  public void setLoggedOnText(String loggedOnText) {
    this.loggedOnText = loggedOnText;
  }
  public String getLoggedOnText() {
    return loggedOnText;
  }

  public boolean isConnected() {
    return client.isConnected();
  }

  protected boolean connect(int retry) {
    try {
      client.disconnect();
    } catch (Exception ex) {
    }
    log.debug("Attempting connection: " + retry);
    try {
      client.setSocketFactory(new TimeoutSocketFactory(this.getConnectionTimeout()));
      client.setDefaultTimeout(this.getIdleTimeout());
      client.connect(this.getHost(), this.getPort());
      client.setSoTimeout(this.getIdleTimeout());
      out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
      in = new BufferedReader(new InputStreamReader(client.getInputStream()));
    }
    catch (Exception e) {
      if (retry > 0) {
        try {
          Thread.sleep(this.getRetryWait());
        } catch (Exception ex) {
          log.debug("Thread sleep error", ex);
        }
        return connect(retry - 1);
      }
      else {
        return false;
      }
    }
    try {
      login(this.getUsername(), this.getPassword());
      waitfor(this.getLoggedOnText());
    }
    catch (Exception e) {
      this.disconnect();
      if (retry > 0) {
        try {
          Thread.sleep(this.getRetryWait());
        } catch (Exception ex) {
          log.debug("Thread sleep error", ex);
        }
        return connect(retry - 1);
      }
      else {
        return false;
      }
    }
    return true;
  }

  private void login(String user, String pass) throws ConnectionFailure {
    waitfor("login:");
    send(user);
    waitfor("Password:");
    send(pass);
  }

  protected void internalSend(String cmd) throws ConnectionFailure {
    try {
      out.write(cmd);
      out.newLine();
      out.flush();
    } catch (Exception ex) {
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
    } catch (Exception ex) {
      throw new ConnectionFailure(ex);
    }

    String msg = message.toString();
    int cutoff = msg.lastIndexOf(match);
    String ret = msg.substring(0, cutoff);
    return ret;
  }

  public synchronized void disconnect() {
    try {
      client.disconnect();
    } catch (Exception ex) {

    }
  }
}

package com.ceridwen.circulation.SIP.transport;

import org.apache.commons.net.telnet.*;
import java.io.*;
import org.apache.commons.logging.*;

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
      client.setDefaultTimeout(this.getConnectionTimeout());
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
      else
        return false;
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
      else
        return false;
    }
    return true;
  }

  private void login(String user, String pass) throws IOException {
    waitfor("login:");
    send(user);
    waitfor("Password:");
    send(pass);
  }

  protected void send(String cmd) throws IOException {
    out.write(cmd);
    out.newLine();
    out.flush();
  }

  protected String waitfor(String match) throws IOException {
    StringBuffer message = new StringBuffer();
    char buffer[] = new char[2048];
    int len;

    do {
      len = in.read(buffer);
      message.append(new String(buffer, 0, len));
    } while ((message.toString()).lastIndexOf(match) < 0);

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

package com.ceridwen.circulation.SIP.transport;

/**
 * <p>Title: RTSI</p>
 * <p>Description: Real Time Self Issue</p>
 * <p>Copyright: </p>

 * @author Matthew J. Dovey
 * @version 1.0
 */

import com.ceridwen.circulation.SIP.messages.*;
import com.ceridwen.circulation.SIP.exceptions.*;
import org.apache.commons.logging.*;
import java.net.Socket;
import java.util.TimerTask;
import java.util.Timer;

class KillConnectionTask extends TimerTask {
  private static Log log = LogFactory.getLog(TimerTask.class);
  private Connection connection;

  public KillConnectionTask(Connection conn) {
    this.connection = conn;
  }

  public void run() {
    try {
      log.info("Attempting to force close timed out connection");
      this.connection.disconnect();
    }
    catch (Exception ex) {
      log.info("Force closed timed out connection failed", ex);
    }
  }
}

public abstract class Connection {
  private static Log log = LogFactory.getLog(Connection.class);

  private char sequence = '0';

  private int connectionTimeout;
  private int idleTimeout;
  private int retryAttempts;
  private int retryWait;
  private String host;
  private int port;

  public void setHost(String host) {
    this.host = host;
  }
  public String getHost() {
    return host;
  }
  public void setPort(int port) {
    this.port = port;
  }
  public int getPort() {
    return port;
  }
  public void setConnectionTimeout(int connectionTimeout) {
    this.connectionTimeout = connectionTimeout;
  }
  public int getConnectionTimeout() {
    return connectionTimeout;
  }
  public void setIdleTimeout(int idleTimeout) {
    this.idleTimeout = idleTimeout;
  }
  public int getIdleTimeout() {
    return idleTimeout;
  }
  public void setRetryAttempts(int retryAttempts) {
    this.retryAttempts = retryAttempts;
  }
  public int getRetryAttempts() {
    return retryAttempts;
  }
  public void setRetryWait(int retryWait) {
    this.retryWait = retryWait;
  }
  public int getRetryWait() {
    return retryWait;
  }

  char getSequence() {
    char ret = sequence;
    sequence++;
    if (sequence > '9')
      sequence = '0';
    return ret;
  }

  protected String strim(String input) {
    String ret = input;

    while (ret.charAt(0) == 0 && ret.length() > 0) {
      ret = ret.substring(1);

    }
    return ret;
  }

  public synchronized boolean connect() {
    return connect(this.getRetryAttempts());
  }

  protected abstract boolean connect(int retryAttempts);
  public abstract boolean isConnected();
  public abstract void disconnect();

  protected abstract void send(String msg) throws ConnectionFailure;
  protected abstract String waitfor(String match) throws ConnectionFailure;

  public synchronized Message send(Message msg) throws ConnectionFailure, RetriesExceeded {
    String request, response = null;
    if (msg == null) {
      throw new RetriesExceeded(); //This will signal a corrupted data
    }
    try {
      boolean retry;
      int retries = 0;
      do {
        retry = false;
        Timer timer = null;
        try {
          request = msg.encode(new Character(getSequence()));
          log.debug(">>> " + request);
          long timeout = this.getIdleTimeout();
          if (timeout > 0) {
            timer = new Timer();
            timer.schedule(new KillConnectionTask(this), (long)(timeout));
          }
          send(request);
          response = waitfor("\r");
          if (timer != null) {
            timer.cancel();
          }
          response = strim(response);
          log.debug("<<< " + response);
          if (response.startsWith("96")) {
            throw new ConnectionFailure();
          }
        }
        catch (ConnectionFailure ex) {
          if (timer != null) {
            timer.cancel();
          }
          try {
            Thread.sleep(this.getRetryWait());
          }
          catch (Exception ex1) {
            log.debug("Thread sleep error", ex1);
          }
          retry = true;
          retries++;
          if (retries > this.getRetryAttempts()) {
            throw new RetriesExceeded();
          }
        }
      }
      while (retry);
      if (response == null) {
        throw new ConnectionFailure();
      }
      return Message.decode(response, null);
    }
    catch (RetriesExceeded e) {
      throw e;
    }
    catch (Exception e) {
      throw new ConnectionFailure();
    }
  }

}

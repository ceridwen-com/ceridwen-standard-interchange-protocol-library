package com.ceridwen.circulation.SIP.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SocketDaemon extends Thread{
  private static Log logger = LogFactory.getLog(SocketDaemon.class);
		
  private int port;
  private MessageBroker broker;
  private boolean running;
  private ServerSocket listener;
  
  public SocketDaemon(int port, MessageHandler handler)
  {
	  this.port = port;
	  this.broker = new MessageBroker(handler);
  }
  
  public void setStrictChecksumChecking(boolean flag) {
	  this.broker.setStrictChecksumChecking(flag);
  }
  
  public boolean getStrictChecksumChecking() {
	  return this.broker.getStrictChecksumChecking();
  }
  
  public void run () {
    try{
      running = true;
      listener = new ServerSocket(port);
      Socket server;

      logger.info("Server daemon listening on port " + port);
      
      while(running){
    	try {  
	        server = listener.accept();
	        ConnectionThread thread = new ConnectionThread(server, broker);
	        thread.start();
    	} catch (SocketException ex) {
    		// listener closed
    	}
      }
      
      logger.info("Server daemon shut down complete");
    } catch (IOException ioe) {
      logger.fatal("IOException on socket listen", ioe);	
    }
  }
  
  public void shutdown() {
      logger.info("Server daemon shutting down");
	  running = false;
      try {
		listener.close();
  	  } catch (IOException e) {
	  }
  }
}

class ConnectionThread extends Thread {
	private static Log logger = LogFactory.getLog(ConnectionThread.class);

	private Socket server;
    private MessageBroker broker;

    ConnectionThread(Socket server, MessageBroker broker) {
      this.broker = broker;
      this.server=server;
    }

    public void run () {
      try {
        logger.info("New connection from " + server.getInetAddress().toString());
        BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));
        PrintStream out = new PrintStream(server.getOutputStream());
        String input = in.readLine();
        do {
        	out.println(broker.process(input));
        	input = in.readLine();
        } while (input != null);
        server.close();
      } catch (IOException ioe) {
        System.out.println("IOException on socket listen: " + ioe);
        ioe.printStackTrace();
      }
    }
}
package com.ceridwen.circulation.SIP.server;

public class SocketServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	    SocketDaemon thread = new SocketDaemon(12345, new MessageHandlerDummyImpl());
	    thread.start();
	}

}

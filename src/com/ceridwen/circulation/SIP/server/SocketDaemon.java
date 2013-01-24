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
package com.ceridwen.circulation.SIP.server;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SocketDaemon extends Thread {
    private static Log logger = LogFactory.getLog(SocketDaemon.class);

    private String ipaddress;
    private int port;
    private MessageBroker broker;
    private boolean running;
    private ServerSocket listener;

    public SocketDaemon(String ipAddress, int port, MessageHandler handler) {
        this.ipaddress = ipAddress;
        this.port = port;
        this.broker = new MessageBroker(handler);
    }

    public void setStrictChecksumChecking(boolean flag) {
        this.broker.setStrictChecksumChecking(flag);
    }

    public boolean getStrictChecksumChecking() {
        return this.broker.getStrictChecksumChecking();
    }
        
    @Override
    public void run() {
        try {
            this.running = true;
            this.listener = new ServerSocket(this.port, 0, InetAddress.getByName(this.ipaddress));
            Socket server;

            SocketDaemon.logger.info("Server daemon listening on port " + this.port);

            while (this.running) {
                try {
                    server = this.listener.accept();
                    ConnectionThread thread = new ConnectionThread(server, this.broker);
                    thread.start();
                } catch (SocketException ex) {
                    // listener closed
                }
            }

            SocketDaemon.logger.info("Server daemon shut down complete");
        } catch (IOException ioe) {
            SocketDaemon.logger.fatal("IOException on socket listen", ioe);
        }
    }

    public void shutdown() {
        SocketDaemon.logger.info("Server daemon shutting down");
        this.running = false;
        try {
            this.listener.close();
        } catch (IOException e) {
        }
    }
}

class ConnectionThread extends Thread {
    private static final String PROP_CHARSET = "com.ceridwen.circulation.SIP.charset";
    private static final String PROP_DEFAULT_CHARSET = "Cp850";    
    private static Log logger = LogFactory.getLog(ConnectionThread.class);

    private Socket server;
    private MessageBroker broker;

    ConnectionThread(Socket server, MessageBroker broker) {
        this.broker = broker;
        this.server = server;
    }

    protected String getCharset() {
        return System.getProperty(PROP_CHARSET, PROP_DEFAULT_CHARSET);    	
    }

    @Override
    public void run() {
        try {
            ConnectionThread.logger.info("New connection from " + this.server.getInetAddress().toString());
            BufferedReader in = new BufferedReader(new InputStreamReader(this.server.getInputStream(), getCharset()));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(this.server.getOutputStream(), getCharset()));
            String input = in.readLine();
            do {
            	String resp = this.broker.process(input) + "\r";
                out.write(resp);
                out.flush();
                input = in.readLine();
            } while (input != null);
            this.server.close();
        } catch (IOException ioe) {
            logger.info("IOException on socket listen: ", ioe);
        }
    }
}

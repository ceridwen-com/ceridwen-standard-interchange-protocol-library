/* 
 * Copyright (C) 2019 Ceridwen Limited
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
import com.ceridwen.circulation.SIP.exceptions.RetriesExceeded;
import com.ceridwen.circulation.SIP.messages.Message;

public class SocketConnection extends Connection implements AutoCloseable {
    private static Log log = LogFactory.getLog(SocketConnection.class);

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    protected Socket getSocket() throws Exception {
      return new java.net.Socket();
    } 

    @Override
    protected void connect(int retryAttempts) throws Exception {
        try {
            this.socket = this.getSocket();
            this.socket.connect(new InetSocketAddress(this.getHost(), this.getPort()), this.getConnectionTimeout());
            this.socket.setSoTimeout(this.getIdleTimeout());
            this.out = new BufferedWriter(new OutputStreamWriter(this.socket.getOutputStream(), Message.getCharsetEncoding()));
            this.in = new BufferedReader(new InputStreamReader(this.socket.getInputStream(), Message.getCharsetEncoding()));
        } catch (Exception ex) {
            if (retryAttempts > 0) {
                try {
                    Thread.sleep(this.getRetryWait());
                } catch (Exception ex1) {
                    SocketConnection.log.debug("Thread sleep error", ex1);
                }
                this.connect(retryAttempts - 1);
            } else {
                throw new RetriesExceeded(ex);
            }
        }
    }

    @Override
    public boolean isConnected() {
        return this.socket.isConnected();
    }

    @Override
    public void disconnect() {
        try {
            this.socket.close();
        } catch (Exception ex) {

        }
    }

    @Override
    protected void internalSend(String cmd) throws ConnectionFailure {
        try {
            this.out.write(cmd);
            this.out.write('\r');
            this.out.flush();
        } catch (Exception ex) {
            throw new ConnectionFailure(ex);
        }
    }

    @Override
    protected String internalWaitfor(String match) throws ConnectionFailure {
        StringBuilder message = new StringBuilder();
        char buffer[] = new char[2048];
        int len;
        long giveup = System.currentTimeMillis() + this.getIdleTimeout();

        try {
            do {
                len = this.in.read(buffer);
                message.append(new String(buffer, 0, len));
            } while (message.lastIndexOf(match) < 0 && System.currentTimeMillis() < giveup);
        } catch (Exception ex) {
            throw new ConnectionFailure(ex);
        }

        String msg = message.toString();
        int cutoff = msg.lastIndexOf(match);
        String ret = msg.substring(0, cutoff);
        return ret;
    }

    @Override
    public void close() throws Exception {
        this.socket.close();
        this.in.close();
        this.out.close();
    }
}

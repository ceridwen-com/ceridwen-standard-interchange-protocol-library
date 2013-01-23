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
import com.ceridwen.circulation.SIP.messages.Message;

public class SocketConnection extends Connection {
    private static Log log = LogFactory.getLog(SocketConnection.class);

    private Socket socket;
    private BufferedReader in;
    private BufferedWriter out;

    @Override
    protected void connect(int retryAttempts) throws Exception {
        try {
            this.socket = new java.net.Socket();
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
                throw ex;
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
        StringBuffer message = new StringBuffer();
        char buffer[] = new char[2048];
        int len;

        try {
            do {
                len = this.in.read(buffer);
                message.append(new String(buffer, 0, len));
            } while ((message.toString()).lastIndexOf(match) < 0);
        } catch (Exception ex) {
            throw new ConnectionFailure(ex);
        }

        String msg = message.toString();
        int cutoff = msg.lastIndexOf(match);
        String ret = msg.substring(0, cutoff);
        return ret;
    }
}

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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.telnet.TelnetClient;

import com.ceridwen.circulation.SIP.exceptions.ConnectionFailure;
import com.ceridwen.circulation.SIP.messages.Message;
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
        return this.username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setLoggedOnText(String loggedOnText) {
        this.loggedOnText = loggedOnText;
    }

    public String getLoggedOnText() {
        return this.loggedOnText;
    }

    @Override
    public boolean isConnected() {
        return this.client.isConnected();
    }

    @Override
    protected void connect(int retry) throws Exception {
        try {
            this.client.disconnect();
        } catch (Exception ex) {
        }
        TelnetConnection.log.debug("Attempting connection: " + retry);
        try {
            this.client.setSocketFactory(new TimeoutSocketFactory(this.getConnectionTimeout()));
            this.client.setDefaultTimeout(this.getIdleTimeout());
            this.client.connect(this.getHost(), this.getPort());
            this.client.setSoTimeout(this.getIdleTimeout());
            this.out = new BufferedWriter(new OutputStreamWriter(this.client.getOutputStream(), Message.getCharsetEncoding()));
            this.in = new BufferedReader(new InputStreamReader(this.client.getInputStream(), Message.getCharsetEncoding()));
        } catch (Exception e) {
            if (retry > 0) {
                try {
                    Thread.sleep(this.getRetryWait());
                } catch (Exception ex) {
                    TelnetConnection.log.debug("Thread sleep error", ex);
                }
                this.connect(retry - 1);
            } else {
                throw e;
            }
        }
        try {
            this.login(this.getUsername(), this.getPassword());
            this.waitfor(this.getLoggedOnText());
        } catch (Exception e) {
            this.disconnect();
            if (retry > 0) {
                try {
                    Thread.sleep(this.getRetryWait());
                } catch (Exception ex) {
                    TelnetConnection.log.debug("Thread sleep error", ex);
                }
                this.connect(retry - 1);
            } else {
                throw e;
            }
        }
    }

    private void login(String user, String pass) throws ConnectionFailure {
        this.waitfor("login:");
        this.send(user);
        this.waitfor("Password:");
        this.send(pass);
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

    @Override
    public synchronized void disconnect() {
        try {
            this.client.disconnect();
        } catch (Exception ex) {

        }
    }
}

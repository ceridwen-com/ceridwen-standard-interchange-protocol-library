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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceridwen.circulation.SIP.exceptions.MessageNotUnderstood;
import com.ceridwen.circulation.SIP.messages.ACSResend;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.messages.SCResend;

public class MessageBroker {
    private static Log logger = LogFactory.getLog(MessageBroker.class);

    private MessageHandler handler;
    private boolean strictChecksumChecking = false;
    private String lastResponse;

    public MessageBroker(MessageHandler handler) {
        this.handler = handler;
    }

    public void setStrictChecksumChecking(boolean flag) {
        this.strictChecksumChecking = flag;
    }

    public boolean getStrictChecksumChecking() {
        return this.strictChecksumChecking;
    }

    public Message process(Message request) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, MessageNotUnderstood {
        Class<MessageHandler> handlerInterface = MessageHandler.class;

        Method[] handlerMethods = handlerInterface.getMethods();

        for (Method handlerMethod : handlerMethods) {
            Class<?> types[] = handlerMethod.getParameterTypes();
            if (types.length == 1) {
                if (request.getClass() == types[0]) {
                    return (Message) handlerMethod.invoke(this.handler, new Object[] { request });
                }
            }
        }
        throw new MessageNotUnderstood();
    }

    public String process(String request) {
        try {
            MessageBroker.logger.debug("Processing message: " + request);
            Message requestMessage = Message.decode(request, null, this.strictChecksumChecking);
            if (requestMessage instanceof ACSResend) {
                MessageBroker.logger.info("Resending response");
            } else {
                Message responseMessage = this.process(requestMessage);
                this.lastResponse = responseMessage.encode(requestMessage.getSequenceCharacter());
            }
            MessageBroker.logger.debug("Sending response: " + this.lastResponse);
            return this.lastResponse;
        } catch (Exception e) {
            MessageBroker.logger.warn("Error trying to process message: " + request, e);
            try {
                return new SCResend().encode(null); // Do a resend properly
            } catch (Exception e1) {
                MessageBroker.logger.error("Error creating SCResend message", e1);
                return "96AZFEF6"; // if all else fails hardcode!
            }
        }
    }
}

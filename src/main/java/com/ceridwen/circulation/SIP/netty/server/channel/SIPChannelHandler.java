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
package com.ceridwen.circulation.SIP.netty.server.channel;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.ceridwen.circulation.SIP.exceptions.MessageNotUnderstood;
import com.ceridwen.circulation.SIP.messages.ACSResend;
import com.ceridwen.circulation.SIP.messages.Message;
import com.ceridwen.circulation.SIP.messages.SCResend;
import com.ceridwen.circulation.SIP.netty.server.driver.DriverFactory;
import com.ceridwen.circulation.SIP.netty.server.driver.Driver;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
* Handles a server-side channel.
*/
@Sharable
public class SIPChannelHandler extends SimpleChannelInboundHandler<Message> {
    private static Log logger = LogFactory.getLog(SIPChannelHandler.class);

	private com.ceridwen.circulation.SIP.netty.server.driver.DriverFactory driverFactory;
	
	public SIPChannelHandler(DriverFactory driverFactory)
	{
		this.driverFactory = driverFactory;
	}

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        ctx.flush();
    }

    private Message process(Message request) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException, MessageNotUnderstood, InstantiationException {
        Driver driver = driverFactory.getDriver();

        Method[] handlerMethods = driver.getClass().getMethods();

        for (Method handlerMethod : handlerMethods) {
            Class<?> types[] = handlerMethod.getParameterTypes();
            if (types.length == 1) {
                if (request.getClass() == types[0]) {
                    return (Message) handlerMethod.invoke(driver, new Object[] { request });
                }
            }
        }
        throw new MessageNotUnderstood();
    }

    
	Message response = null;
    
    @Override
    public void channelRead0(ChannelHandlerContext ctx, Message request) throws Exception {
        if (!(request instanceof ACSResend)) {
        	response = process(request);
        } else if (response == null) {
        	response = new SCResend();
        }

        response.setSequenceCharacter(request.getSequenceCharacter());
        
        ChannelFuture future = ctx.write(response);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) {
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
    	if (cause instanceof java.io.IOException) {
    		logger.debug(cause.getMessage());
    	} else {
	    	logger.error("Transient communications error", cause);
//	        cause.printStackTrace();
	        try {
	            ctx.write(new SCResend().encode(null));
	            ctx.flush();
	        } catch (Exception e1) {
	        	logger.error("Transient communications error", e1);
	            ctx.close();
	        }
	    }
    }
}
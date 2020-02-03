/* 
 * Copyright (C) 2020 Ceridwen Limited
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
package com.ceridwen.circulation.SIP.netty.server;

import com.ceridwen.circulation.SIP.netty.codec.SIPMessageDecoder;
import com.ceridwen.circulation.SIP.netty.codec.SIPMessageEncoder;
import com.ceridwen.circulation.SIP.netty.server.channel.SIPChannelHandler;
import com.ceridwen.circulation.SIP.netty.server.driver.DriverFactory;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;


public class SIPServerInitializer extends ChannelInitializer<SocketChannel> {
	
    private final StringDecoder DECODER = new StringDecoder();
    private final StringEncoder ENCODER = new StringEncoder();
    private SIPMessageDecoder SIPDECODER;
    private final SIPMessageEncoder SIPENCODER = new SIPMessageEncoder();

    private SIPChannelHandler SERVER_HANDLER;

    private final SslContext sslCtx;

    private ByteBuf[] getDelimiters() {
        return new ByteBuf[] {
        		Unpooled.wrappedBuffer(new byte[] { '\r', '\n' }),
        		Unpooled.wrappedBuffer(new byte[] { '\r' }),
                Unpooled.wrappedBuffer(new byte[] { '\n' }),
        };    	
    }
    
    public SIPServerInitializer(DriverFactory driverFactory, boolean strictChecksumChecking, SslContext sslCtx) {
        this.sslCtx = sslCtx;
        SIPDECODER = new SIPMessageDecoder(strictChecksumChecking);
        SERVER_HANDLER = new SIPChannelHandler(driverFactory);
    }
    
    public SIPServerInitializer(DriverFactory driverFactory, boolean strictChecksumChecking) {
    	this.sslCtx = null;
      SIPDECODER = new SIPMessageDecoder(strictChecksumChecking);
      SERVER_HANDLER = new SIPChannelHandler(driverFactory);
    }

    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        if (sslCtx != null) {
            pipeline.addLast(sslCtx.newHandler(ch.alloc()));
        }        
        
        pipeline.addLast(new LoggingHandler(LogLevel.DEBUG));
        
        // Add the text line codec combination first,
        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, getDelimiters()));
        
        // Add encoders and decoders
        pipeline.addLast(DECODER);
        pipeline.addLast(ENCODER);
        pipeline.addLast(SIPDECODER);
        pipeline.addLast(SIPENCODER);
        
        // and then business logic.
        pipeline.addLast(SERVER_HANDLER);        
    }
}


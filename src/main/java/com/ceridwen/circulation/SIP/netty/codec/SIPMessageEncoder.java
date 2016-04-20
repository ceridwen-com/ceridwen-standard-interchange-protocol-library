package com.ceridwen.circulation.SIP.netty.codec;

import java.util.List;

import com.ceridwen.circulation.SIP.messages.Message;

import io.netty.channel.ChannelHandler.Sharable;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;

@Sharable
public class SIPMessageEncoder extends MessageToMessageEncoder<Message> {
	
	public SIPMessageEncoder() {}

	@Override
	protected void encode(ChannelHandlerContext ctx, Message msg, List<Object> out) throws Exception {
		out.add(msg.encode() + "\r");
	}
}


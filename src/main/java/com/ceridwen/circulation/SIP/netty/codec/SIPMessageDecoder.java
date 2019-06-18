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
package com.ceridwen.circulation.SIP.netty.codec;

import java.util.List;

import com.ceridwen.circulation.SIP.messages.Message;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelHandler.Sharable;
import io.netty.handler.codec.MessageToMessageDecoder;

@Sharable
public class SIPMessageDecoder extends MessageToMessageDecoder<String> {
	private boolean strictChecksumChecking = false; 

	public SIPMessageDecoder() {}

	public SIPMessageDecoder(boolean strictChecksumChecking) 
	{
		this.strictChecksumChecking = strictChecksumChecking;
	}

	@Override
	protected void decode(ChannelHandlerContext ctx, String msg, List<Object> out) throws Exception {
		out.add(Message.decode(msg, null, strictChecksumChecking));
	}
}

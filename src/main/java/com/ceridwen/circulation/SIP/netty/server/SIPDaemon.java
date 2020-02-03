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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.ceridwen.circulation.SIP.netty.server.driver.DriverFactory;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.internal.StringUtil;
import java.io.File;

public class SIPDaemon implements GenericFutureListener<ChannelFuture> {
  private static final Log log = LogFactory.getLog(SIPDaemon.class);

	private final String name;
	private final String ip;
  private final int port;
  private final File keyCertChainFile;
  private final File keyFile;
  private final String keyPassword;
  private final DriverFactory driverFactory;
  private final boolean strictChecksumChecking;

  private ChannelFuture f;
  private EventLoopGroup bossGroup;
  private EventLoopGroup workerGroup;

  public SIPDaemon(String name, String ip, int port, File keyCertChainFile, File keyFile, DriverFactory driverFactory, boolean strictChecksumChecking) {
    this(name, ip, port, keyCertChainFile, keyFile, null, driverFactory, strictChecksumChecking);
  }

  public SIPDaemon(String name, String ip, int port, DriverFactory driverFactory, boolean strictChecksumChecking) {
    this(name, ip, port, null, null, null, driverFactory, strictChecksumChecking);
  }
  
  public SIPDaemon(String name, String ip, int port, File keyCertChainFile, File keyFile, String keyPassword, DriverFactory driverFactory, boolean strictChecksumChecking) {
    this.name = name;
    this.ip = ip;
    this.port = port;
    this.keyCertChainFile = keyCertChainFile;
    this.keyFile = keyFile;
    this.keyPassword = keyPassword;
    this.driverFactory = driverFactory;
    this.strictChecksumChecking = strictChecksumChecking;
  }
  
  public String getName() {
    return name;
  }

  public String getIp() {
    return ip;
  }

  public int getPort() {
    return port;
  }

  public boolean isStrictChecksumChecking() {
    return strictChecksumChecking;
  }

  public void start() throws Exception {
      // Configure SSL.
      log.info("Server " + name + " on " + ip + " " + port + " starting...");

      final SslContext sslCtx;
      
      if (keyCertChainFile == null || keyFile == null) {
        sslCtx = null;
      } else {
        if (StringUtil.isNullOrEmpty(keyPassword)) {
          sslCtx = SslContextBuilder.forServer(keyCertChainFile, keyFile).build();
        } else {
          sslCtx = SslContextBuilder.forServer(keyCertChainFile, keyFile, keyPassword).build();
        }
      }    	

      bossGroup = new NioEventLoopGroup(1);
      workerGroup = new NioEventLoopGroup();

      try {
        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup, workerGroup)
           .channel(NioServerSocketChannel.class)
           .handler(new LoggingHandler(LogLevel.INFO))
           .childHandler(new SIPServerInitializer(driverFactory, strictChecksumChecking, sslCtx))
           .option(ChannelOption.SO_BACKLOG, 128)          
           .childOption(ChannelOption.SO_KEEPALIVE, true); 

           // Bind and start to accept incoming connections.
          f = b.bind(ip, port).sync(); // (7)

          // Wait until the server socket is closed.
          // In this example, this does not happen, but you can do that to gracefully
          // shut down your server.
          f.channel().closeFuture().addListener(this);


          log.info("Server " + name + " on " + ip + " " + port + " startup complete.");
      } catch (Exception ex) {
          workerGroup.shutdownGracefully();
          bossGroup.shutdownGracefully();
      }
  }

  public void stop()
  {
      log.info("Server " + name + " on " + ip + " " + port + " shutting down...");
      if (f != null) {
        f.channel().close();
      }
      workerGroup.shutdownGracefully();
      bossGroup.shutdownGracefully();		
      log.info("Server " + name + " on " + ip + " " + port + " shutdown complete.");
  }

	@Override
	public void operationComplete(ChannelFuture arg0) throws Exception {
        log.info("Server " + name + " on " + ip + " " + port + " shutting down...");
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();		
        log.info("Server " + name + " on " + ip + " " + port + " shutdown complete.");
	}
}
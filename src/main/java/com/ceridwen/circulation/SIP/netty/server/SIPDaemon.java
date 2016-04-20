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
import io.netty.handler.ssl.util.SelfSignedCertificate;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

public class SIPDaemon implements GenericFutureListener {
    private static Log log = LogFactory.getLog(SIPDaemon.class);


	private String name;
	private String ip;
    private int port;
    private boolean ssl;
    private DriverFactory driverFactory;
    private boolean strictChecksumChecking;

    private ChannelFuture f;
    private EventLoopGroup bossGroup;
    private EventLoopGroup workerGroup;
    

    public SIPDaemon(String name, String ip, int port, boolean ssl, DriverFactory driverFactory, boolean strictChecksumChecking) {
    	this.name = name;
    	this.ip = ip;
        this.port = port;
        this.ssl = ssl;
        this.driverFactory = driverFactory;
        this.strictChecksumChecking = strictChecksumChecking;
    }

    public void start() throws Exception {
        // Configure SSL.
        log.info("Server " + name + " on " + ip + " " + port + " starting...");

    	final SslContext sslCtx;
        if (ssl) {
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            sslCtx = SslContext.newServerContext(ssc.certificate(), ssc.privateKey());
        } else {
            sslCtx = null;
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
        log.info("Server " + name + " on " + ip + " " + port + " shuttdown  complete.");
    }

	@Override
	public void operationComplete(Future arg0) throws Exception {
        log.info("Server " + name + " on " + ip + " " + port + " shutting down...");
        workerGroup.shutdownGracefully();
        bossGroup.shutdownGracefully();		
        log.info("Server " + name + " on " + ip + " " + port + " shuttdown  complete.");
	}
}
package com.liurui.server.im;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoop;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.lang.ref.SoftReference;

/**
 * @author liu-rui
 * @date 2019/10/23 下午3:37
 * @description
 * @since
 */
@Component
@Log4j2
public class IMServer implements Runnable {
    @Value("${imserver.port}")
    private int port;

    @PostConstruct
    public void init() {
        Thread thread = new Thread(this);

        thread.start();
    }

    @Override
    public void run() {
        NioEventLoopGroup boss = new NioEventLoopGroup();
        NioEventLoopGroup worker = new NioEventLoopGroup();
        ServerBootstrap serverBootstrap = new ServerBootstrap()
                .group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .localAddress(port)
                .option(ChannelOption.SO_BACKLOG, 100)
                .handler(new LoggingHandler(LogLevel.INFO))
                .childOption(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new IMServerInitializer());

        try {
            final Channel channel = serverBootstrap.bind().addListener(
                    future -> {
                        if (future.isSuccess()) {
                            log.info("IM Server启动成功，端口为:{}", port);
                        } else {
                            log.error("IM Server启动失败", future.cause());
                        }
                    }
            ).sync().channel();

            channel.closeFuture().addListener(future -> {
                boss.shutdownGracefully();
                worker.shutdownGracefully();
            }).sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

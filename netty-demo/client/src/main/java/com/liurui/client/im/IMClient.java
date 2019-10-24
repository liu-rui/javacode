package com.liurui.client.im;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author liu-rui
 * @date 2019/10/23 下午5:25
 * @description
 * @since
 */
@Component
@Log4j2
public class IMClient {
    @Value("${im.host}")
    private String host;
    @Value("${im.port}")
    private int port;
    private Channel channel;


    @PostConstruct
    public void start() {
        Bootstrap bootstrap = new Bootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioSocketChannel.class)
                .handler(new IMClientInitializer());


        try {
            channel = bootstrap.connect(host, port).sync().channel();
        } catch (InterruptedException e) {
            log.error("连接IM Server出现了异常", e);
        }

        send("hell world!!");
    }

    public void  send(String msg){
        channel.writeAndFlush(msg).addListener(future -> System.out.println(future.isSuccess()));
    }
}

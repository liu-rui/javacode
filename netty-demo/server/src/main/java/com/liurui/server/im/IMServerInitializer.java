package com.liurui.server.im;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @author liu-rui
 * @date 2019/10/23 下午3:45
 * @description
 * @since
 */
public class IMServerInitializer extends ChannelInitializer<Channel> {
    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                .addLast(new StringDecoder())
                .addLast(new StringEncoder())
                .addLast(new IMServerHandler());
    }
}

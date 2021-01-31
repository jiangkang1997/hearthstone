package com.jk.game.hearthstone.server.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jk
 * @date 2021/1/31 16:54
 */
@Component
public class ChildChannelHandler extends ChannelInitializer<SocketChannel> {

    @Resource
    private DiscardServerHandler discardServerHandler;

    @Override
    public void initChannel(SocketChannel socketChannel){
        socketChannel.pipeline().addLast(discardServerHandler);
    }
}

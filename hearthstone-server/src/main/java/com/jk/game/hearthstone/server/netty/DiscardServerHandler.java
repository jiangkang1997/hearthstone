package com.jk.game.hearthstone.server.netty;

import com.jk.game.hearthstone.server.exception.IllegalInputException;
import com.jk.game.hearthstone.server.exception.NoSuchCommandException;
import com.jk.game.hearthstone.server.service.CommandParseService;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author jk
 * @date 2021/1/31 16:54
 */
@Slf4j
@Component
@ChannelHandler.Sharable
public class DiscardServerHandler extends ChannelHandlerAdapter {

    @Autowired
    CommandParseService commandParseService;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        try {
            ByteBuf in = (ByteBuf) msg;
            log.info(in.toString(CharsetUtil.UTF_8));
            commandParseService.commandParse(in.toString(CharsetUtil.UTF_8));
        } catch (NoSuchCommandException e) {
            e.printStackTrace();
        } catch (IllegalInputException e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        // 出现异常就关闭
        cause.printStackTrace();
        ctx.close();
    }
}

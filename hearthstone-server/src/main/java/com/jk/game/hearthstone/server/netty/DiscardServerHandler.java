package com.jk.game.hearthstone.server.netty;

import com.jk.game.hearthstone.server.exception.IllegalInputException;
import com.jk.game.hearthstone.server.exception.NoSuchCommandException;
import com.jk.game.hearthstone.server.model.Command;
import com.jk.game.hearthstone.server.service.CommandDispatcherService;
import com.jk.game.hearthstone.server.service.CommandParseService;
import com.jk.game.hearthstone.server.service.CommandService;
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

    @Resource
    CommandParseService commandParseService;
    @Resource
    CommandDispatcherService commandDispatcherService;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {

        try {
            ByteBuf in = (ByteBuf) msg;
            log.info(in.toString(CharsetUtil.UTF_8));
            Command command = commandParseService.commandParse(in.toString(CharsetUtil.UTF_8));
            CommandService commandService = commandDispatcherService.dispatcher(command.getCommandType());
            //todo: 这里做业务逻辑
            //todo：游戏环境的创建和获取
            commandService.doCommand();
        } catch (NoSuchCommandException | IllegalInputException e) {
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

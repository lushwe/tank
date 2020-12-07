package com.lushwe.tank.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * 说明：坦克消息解码器
 *
 * @author Jack Liu
 * @date 2020-12-07 22:16
 * @since 0.1
 */
public class TankMsgDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 8) {
            return;
        }

        //in.markReaderIndex();

        int x = in.readInt();
        int y = in.readInt();

        out.add(new TankMsg(x, y));
    }

}

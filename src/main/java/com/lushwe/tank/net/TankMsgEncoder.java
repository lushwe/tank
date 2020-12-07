package com.lushwe.tank.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 说明：坦克消息编码器
 *
 * @author Jack Liu
 * @date 2020-12-07 22:17
 * @since 0.1
 */
public class TankMsgEncoder extends MessageToByteEncoder<TankMsg> {

    @Override
    protected void encode(ChannelHandlerContext ctx, TankMsg msg, ByteBuf buf) throws Exception {
        buf.writeInt(msg.x);
        buf.writeInt(msg.y);
    }
}

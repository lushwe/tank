package com.lushwe.tank.net;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 说明：坦克加入消息编码器
 *
 * @author Jack Liu
 * @date 2020-12-07 22:25
 * @since 0.1
 */
public class TankJoinMsgEncoder extends MessageToByteEncoder<TankJoinMsg> {

    @Override
    protected void encode(ChannelHandlerContext ctx, TankJoinMsg msg, ByteBuf buf) throws Exception {
        buf.writeBytes(msg.toBytes());
    }


}

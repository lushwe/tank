package com.lushwe.tank.net;

import com.lushwe.tank.enums.Dir;
import com.lushwe.tank.enums.Group;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;
import java.util.UUID;

/**
 * 说明：坦克加入消息解码器
 *
 * @author Jack Liu
 * @date 2020-12-07 22:25
 * @since 0.1
 */
public class TankJoinMsgDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        if (in.readableBytes() < 148) return; //TCP ²ð°ü Õ³°üµÄÎÊÌâ

        //in.markReaderIndex();
        TankJoinMsg msg = new TankJoinMsg();

        msg.x = in.readInt();
        msg.y = in.readInt();
        msg.dir = Dir.values()[in.readInt()];
        msg.moving = in.readBoolean();
        msg.group = Group.values()[in.readInt()];
        msg.id = new UUID(in.readLong(), in.readLong());

        out.add(msg);
    }

}

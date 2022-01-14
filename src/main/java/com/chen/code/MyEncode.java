package com.chen.code;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

public class MyEncode extends MessageToByteEncoder<ByteBuf> {
    @Override
    protected void encode (ChannelHandlerContext ctx, ByteBuf msg, ByteBuf out) throws Exception {
//        byte[] body = convertToBytes(msg);  //将对象转换为byte，伪代码，具体用什么进行序列化，你们自行选择。可以使用我上面说的一些
        int dataLength = msg.capacity();  //读取消息的长度
        out.writeInt(dataLength);  //先将消息长度写入，也就是消息头
        out.writeBytes(msg);  //消息体中包含我们要发送的数据
    }

//    private byte[] convertToBytes (ByteBuf msg) {
//        System.out.println(">>>>>>>>>>:"+msg);
//        return msg;
//    }
}

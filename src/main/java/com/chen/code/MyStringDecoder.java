package com.chen.code;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.netty.util.internal.ObjectUtil;

import java.nio.charset.Charset;
import java.util.List;

public class MyStringDecoder extends MessageToMessageDecoder<ByteBuf> {
    private final Charset charset;

    public MyStringDecoder () {
        this(Charset.defaultCharset());
    }

    public MyStringDecoder (Charset charset) {
        this.charset = (Charset) ObjectUtil.checkNotNull(charset, "charset");
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
        System.out.println(">>>>>>>>"+msg.toString(this.charset));
        out.add(msg.toString(this.charset));
    }
}
package com.dabai.springcloud.netty.nio;

import java.nio.ByteBuffer;

/**
 * @author zhuhaolin
 * @version 2.0
 * @description TODO
 * @date 2020-01-23
 **/
public class BufferDemo {
    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(1024);
        bb.putInt(100);
        bb.putLong(999L);
        bb.putChar('中');
        bb.flip();
        System.out.println(bb.getInt(0));
        System.out.println(bb.getLong(4));
        System.out.println(bb.getChar(12));
    }
}

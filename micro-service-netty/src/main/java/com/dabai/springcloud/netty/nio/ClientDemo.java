package com.dabai.springcloud.netty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author zhuhaolin
 * @version 2.0
 * @description TODO
 * @date 2020-01-26
 **/
public class ClientDemo {
    public static void main(String[] args) throws Exception {
        SocketChannel sc = SocketChannel.open();
        sc.configureBlocking(Boolean.FALSE);

        InetSocketAddress isa = new InetSocketAddress("127.0.0.1", 6666);
        if (!sc.connect(isa)) {
            while (!sc.finishConnect()) {
                //未连接成功，处理其他事情
            }
        }

        //连接上
        String content = "hello, 我是朱浩霖！";
        ByteBuffer buffer = ByteBuffer.wrap(content.getBytes());
        sc.write(buffer);
    }
}

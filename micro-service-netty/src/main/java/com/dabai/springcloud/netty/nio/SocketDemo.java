package com.dabai.springcloud.netty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Arrays;

/**
 * @author zhuhaolin
 * @version 2.0
 * @description TODO
 * @date 2020-01-25
 **/
public class SocketDemo {
    public static void main(String[] args) throws Exception {
        //创建Socket
        ServerSocketChannel ssc = ServerSocketChannel.open();
        //绑定6666端口，并启动Socket
        ssc.socket().bind(new InetSocketAddress(6666));

        ByteBuffer[] byteBuffers = new ByteBuffer[2];
        byteBuffers[0] = ByteBuffer.allocate(8);
        byteBuffers[1] = ByteBuffer.allocate(3);

        SocketChannel accept = ssc.accept();

        while (true) {
            //读取数据
            accept.read(byteBuffers);

            //复位
            Arrays.asList(byteBuffers).forEach(byteBuffer -> {
                byteBuffer.flip();
            });

            //打印读取的数据
            Arrays.asList(byteBuffers).stream().forEach(byteBuffer -> {
                System.out.println(new String(byteBuffer.array()));
            });

            //原样回显给对应连接客户端
            accept.write(byteBuffers);
        }
    }
}
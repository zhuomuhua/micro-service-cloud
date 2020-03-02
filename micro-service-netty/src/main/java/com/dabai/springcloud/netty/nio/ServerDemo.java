package com.dabai.springcloud.netty.nio;

import org.springframework.util.ObjectUtils;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * @author zhuhaolin
 * @version 2.0
 * @description TODO
 * @date 2020-01-26
 **/
public class ServerDemo {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel ssc = ServerSocketChannel.open();
        Selector selector = Selector.open();
        //绑定端口
        ssc.socket().bind(new InetSocketAddress(6666));
        //设置为 非阻塞
        ssc.configureBlocking(Boolean.FALSE);
        //将 ssc 注册到 selector  事件  OP_ACCEPT
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        //循环等待客户端连接
        while (Boolean.TRUE) {
            //这里等待 n 秒，如果没有事件发生，返回
            if (selector.select(2000) == 0) {
                System.out.println("服务器，未接收到任何连接！");
                continue;
            }
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            //这个集合是有事件发生的集合
            System.out.println("selectionKeys 数量 = " + selectionKeys.size());
            for (SelectionKey sk : selectionKeys) {
                if (!ObjectUtils.isEmpty(sk)) {
                    if (sk.isAcceptable()) {
                        SocketChannel accept = ssc.accept();
                        if (!ObjectUtils.isEmpty(accept)) {
                            //设置为非阻塞
                            accept.configureBlocking(Boolean.FALSE);
                            accept.register(selector, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                        }
                    }
                    if (sk.isReadable()) {
                        SocketChannel channel = (SocketChannel) sk.channel();
                        if (!ObjectUtils.isEmpty(channel)) {
                            ByteBuffer bb = (ByteBuffer) sk.attachment();
                            channel.read(bb);
                            System.out.println(new String(bb.array()));
                        }
                    }
                }
            }
        }
    }
}
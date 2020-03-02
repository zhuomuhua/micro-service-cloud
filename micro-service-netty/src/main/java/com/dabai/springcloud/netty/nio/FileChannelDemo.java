package com.dabai.springcloud.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhuhaolin
 * @version 2.0
 * @description TODO
 * @date 2020-01-25
 **/
public class FileChannelDemo {
    public static void main(String[] args) throws Exception {
        readAndWrite();
    }

    private static void write() throws Exception {
        String name = "hello zhuhaolin";
        FileOutputStream fos = new FileOutputStream("G:\\hello.txt");
        FileChannel channel = fos.getChannel();
        ByteBuffer bb = ByteBuffer.allocate(1024);
        bb.put(name.getBytes());
        bb.flip();
        channel.write(bb);
        fos.close();
        channel.close();
    }

    private static void read() throws Exception {
        String path = "G:\\hello.txt";
        FileInputStream fis = new FileInputStream(path);
        FileChannel channel = fis.getChannel();
        ByteBuffer bb = ByteBuffer.allocate((int) channel.size());
        channel.read(bb);
        fis.close();
        channel.close();
        System.out.println(new String(bb.array()));
    }

    private static void readAndWrite() throws Exception {
        String path = "G:\\hello.txt";
        FileInputStream fis = new FileInputStream(path);
        FileChannel readChannel = fis.getChannel();

        String destPath = "G:\\zhu.txt";
        FileOutputStream fos = new FileOutputStream(destPath);
        FileChannel writeChannel = fos.getChannel();
        readChannel.transferTo(0, readChannel.size(), writeChannel);

        fis.close();
        readChannel.close();
        fos.close();
        writeChannel.close();
    }
}







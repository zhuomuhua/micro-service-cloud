package com.dabai.springcloud.netty.nio;

import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author zhuhaolin
 * @version 2.0
 * @description TODO
 * @date 2020-01-25
 **/
public class MappedByteBufferDemo {
    public static void main(String[] args) throws Exception {
        String path = "G:\\hello.txt";
        RandomAccessFile raf = new RandomAccessFile(path, "rw");
        FileChannel channel = raf.getChannel();

        //参数1：FileChannel.MapMode.READ_WRITE 使用的读写模式
        //参数2：可以直接修改的起始位置
        //参数3：是映射到内存的大小，即将 path 的文件的多少个字节映射到内存
        MappedByteBuffer mbb = channel.map(FileChannel.MapMode.READ_WRITE, 0, channel.size());
        mbb.put(2, (byte)'朱');
        raf.close();
        System.out.println("修改成功！");
        System.out.println((byte)'朱');
    }
}
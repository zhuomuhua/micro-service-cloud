package com.dabai.springcloud.netty.bio;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author zhuhaolin
 * @version 2.0
 * @description TODO
 * @date 2020-01-23
 **/
public class BioServer {
    public static void main(String[] args) throws Exception {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder()
                .setNameFormat("demo-pool-%d").build();

        ExecutorService es = new ThreadPoolExecutor(5, 200,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>(1024), namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());

        ServerSocket ss = new ServerSocket(6666);
        System.out.println("服务器启动了");

        while (true) {
            Socket socket = ss.accept();
            es.execute(new Runnable() {
                @Override
                public void run() {
                    String name = Thread.currentThread().getName();
                    System.out.println("客户端 " + name + "连接了");
                    while (true) {
                        try {
                            byte[] bytes = new byte[1024];
                            InputStream is = socket.getInputStream();
                            int read = is.read(bytes);
                            if (read != -1) {
                                System.out.println(new String(bytes, 0, read));
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            try {
                                if (!ObjectUtils.isEmpty(socket)) {
                                    socket.close();
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            });
        }
    }
}
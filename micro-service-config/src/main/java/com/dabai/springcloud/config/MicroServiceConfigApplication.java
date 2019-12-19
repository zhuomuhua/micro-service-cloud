package com.dabai.springcloud.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author zhuhaolin
 * @version v1.8.0
 * @Description: TODO
 * @Date 2019/12/18 10:49
 */
@EnableConfigServer
@EnableEurekaClient
@SpringBootApplication
public class MicroServiceConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(MicroServiceConfigApplication.class, args);
    }
}
